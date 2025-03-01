package cn.cotenite.bearing.config;

import cn.cotenite.bearing.common.enums.UserRoleEnum;
import cn.cotenite.bearing.common.expection.BizException;
import cn.cotenite.bearing.domain.dto.UserRedisDTO;
import cn.cotenite.bearing.utils.RedisKeyUtil;
import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.stp.StpInterface;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author RichardYoung
 * @Description
 * @Date 2/26/2025 6:06 AM
 */
@Configuration
public class SatokenConfig implements WebMvcConfigurer, StpInterface {

    @Resource
    private RedisTemplate<String, UserRedisDTO> redisTemplate;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SaInterceptor()).addPathPatterns("/**");
    }

    @Override
    public List<String> getPermissionList(Object o, String s) {
        return null;
    }

    @Override
    public List<String> getRoleList(Object loginId, String s) {
        UserRedisDTO role = (UserRedisDTO) redisTemplate.opsForHash().get(RedisKeyUtil.buildUserHashKey(),loginId);
        UserRoleEnum userRole = UserRoleEnum.getUserRoleByCode(role.getRole());
        List<String> list=new ArrayList<>();
        if(userRole==null){
            throw new BizException("身份错误");
        }
        list.add(userRole.getDocs());
        return list;
    }

}
