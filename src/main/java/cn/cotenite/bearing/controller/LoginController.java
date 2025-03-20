package cn.cotenite.bearing.controller;

import cn.cotenite.bearing.common.response.Response;
import cn.cotenite.bearing.domain.vo.req.LoginReqVO;
import cn.cotenite.bearing.domain.vo.rsp.CaptchaVO;
import cn.cotenite.bearing.domain.vo.rsp.LoginRspVO;
import cn.cotenite.bearing.service.LoginService;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author RichardYoung
 * @Description
 * @Date 2/25/2025 8:11 PM
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping("/captcha")
    public Response<CaptchaVO> captcha(){
        CaptchaVO captchaVO = loginService.buildCaptcha();
        return Response.success(captchaVO);
    }

    @PostMapping("/login")
    public Response<LoginRspVO> login(@Validated @RequestBody LoginReqVO loginReqVO){
        LoginRspVO rspVO = loginService.login(loginReqVO);
        return Response.success(rspVO);
    }



}
