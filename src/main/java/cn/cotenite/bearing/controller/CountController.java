package cn.cotenite.bearing.controller;

import cn.cotenite.bearing.common.response.Response;
import cn.cotenite.bearing.service.BearingService;
import cn.cotenite.bearing.service.BearingWrongService;
import cn.cotenite.bearing.service.UserService;
import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author RichardYoung
 * @Description
 * @Date 3/7/2025 7:44 PM
 */
@RestController
@SaCheckLogin
@SaCheckRole(value = {"admin","superAdmin"},mode = SaMode.OR)
@RequestMapping("/bearing")
public class CountController {

    @Resource
    private BearingService bearingService;

    @Resource
    private UserService userService;

    @Resource
    private BearingWrongService bearingWrongService;

    @GetMapping("/userCount")
    private Response<Long> getUserCount(){
        return Response.success(bearingService.count());
    }

    @GetMapping("/bearingCount")
    private Response<Long> getBearingCount(){
        return Response.success(userService.count());
    }

    @GetMapping("/wrongCount")
    private Response<Long> getBearingWrongCount(){
        return Response.success(bearingWrongService.count());
    }

}
