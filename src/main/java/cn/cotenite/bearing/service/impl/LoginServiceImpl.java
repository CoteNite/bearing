package cn.cotenite.bearing.service.impl;

import cn.cotenite.bearing.common.enums.ResponseErrorEnum;
import cn.cotenite.bearing.common.enums.UserRoleEnum;
import cn.cotenite.bearing.common.expection.BizException;
import cn.cotenite.bearing.utils.RedisKeyUtil;
import cn.cotenite.bearing.utils.SnowFlakUtil;
import cn.cotenite.bearing.domain.po.User;
import cn.cotenite.bearing.domain.vo.req.LoginReqVO;
import cn.cotenite.bearing.domain.vo.rsp.CaptchaVO;
import cn.cotenite.bearing.domain.vo.rsp.LoginRspVO;
import cn.cotenite.bearing.mapper.UserMapper;
import cn.cotenite.bearing.service.LoginService;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wf.captcha.SpecCaptcha;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author RichardYoung
 * @Description
 * @Date 2/26/2025 5:35 AM
 */
@Service
@Slf4j
public class LoginServiceImpl extends ServiceImpl<UserMapper, User> implements LoginService {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Resource
    private UserMapper userMapper;

    @Override
    public CaptchaVO buildCaptcha() {
        SpecCaptcha specCaptcha = new SpecCaptcha(72, 38, 4);
        String captchaBase64 = specCaptcha.toBase64();
        String verCode = specCaptcha.text().toLowerCase();
        String snowId= SnowFlakUtil.getSnowFlakeId();
        String key = RedisKeyUtil.buildCaptchaKey(snowId);
        log.info("生成验证码：key:{},word:{}",key,verCode);
        redisTemplate.opsForValue().set(key,verCode,3, TimeUnit.MINUTES);
        return CaptchaVO.builder()
                .key(snowId)
                .captcha(captchaBase64)
                .build();
    }

    @Override
    public LoginRspVO login(LoginReqVO loginReqVO) {
        String captchaKey = RedisKeyUtil.buildCaptchaKey(loginReqVO.getKey());
        if (!redisTemplate.hasKey(captchaKey)) {
            throw new BizException(ResponseErrorEnum.CAPTCHA_ERROR);
        }

        String code = (String) redisTemplate.opsForValue().get(captchaKey);
        if (!StrUtil.equals(code, loginReqVO.getCode().toLowerCase())){
            log.error("用户传入验证码错误，key：{}，code:{}",captchaKey,loginReqVO.getCode());
            throw new BizException(ResponseErrorEnum.CAPTCHA_ERROR);
        }


        User user = userMapper.selectUserByUsername(loginReqVO.getUsername());

        if(user==null){
            throw new BizException(ResponseErrorEnum.USER_NOT_FOUND);
        }


        if(!BCrypt.checkpw(loginReqVO.getPassword(),user.getPassword())){
            throw new BizException(ResponseErrorEnum.PASSWORD_OR_USERNAME_FAILURE);
        }

        UserRoleEnum userRole=UserRoleEnum.getUserRoleByCode(user.getRole());

        if (userRole==null){
            throw new BizException(ResponseErrorEnum.SYSTEM_ERROR);
        }

        StpUtil.login(user.getId(),loginReqVO.getRememberMe());

        return LoginRspVO.builder()
                .userId(user.getId())
                .nickname(user.getRealName())
                .role(userRole.getDocs())
                .token(StpUtil.getTokenInfo().getTokenValue())
                .build();
    }
}
