package cn.cotenite.bearing.controller;

import cn.cotenite.bearing.common.response.Response;
import cn.cotenite.bearing.domain.vo.req.UserAddReqVO;
import cn.cotenite.bearing.domain.vo.req.UserUpdateReqVO;
import cn.cotenite.bearing.service.UserService;
import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author RichardYoung
 * @Description
 * @Date 2/28/2025 9:19 PM
 */
@SaCheckLogin
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/add")
    @SaCheckRole(value = {"admin","superAdmin"},mode = SaMode.OR)
    public Response<Void> addUser(@Validated @RequestBody UserAddReqVO reqVO){
        userService.addUser(reqVO);
        return Response.success();
    }

    @PostMapping("/update")
    @SaCheckRole(value = {"admin","superAdmin"},mode = SaMode.OR)
    public Response<Void> updateUser(@RequestBody UserUpdateReqVO reqVO){
        userService.updateUser(reqVO);
        return Response.success();
    }

}
