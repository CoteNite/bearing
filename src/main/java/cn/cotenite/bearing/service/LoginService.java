package cn.cotenite.bearing.service;

import cn.cotenite.bearing.domain.po.User;
import cn.cotenite.bearing.domain.vo.req.LoginReqVO;
import cn.cotenite.bearing.domain.vo.rsp.CaptchaVO;
import cn.cotenite.bearing.domain.vo.rsp.LoginRspVO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Author RichardYoung
 * @Description
 * @Date 2/26/2025 5:35 AM
 */
public interface LoginService extends IService<User> {

    CaptchaVO buildCaptcha();

    LoginRspVO login(LoginReqVO loginReqVO);

}
