package cn.cotenite.bearing.controller;

import cn.cotenite.bearing.common.response.Response;
import cn.cotenite.bearing.domain.po.User;
import cn.cotenite.bearing.domain.vo.req.PageReqVO;
import cn.cotenite.bearing.domain.vo.req.UserAddReqVO;
import cn.cotenite.bearing.domain.vo.req.UserUpdateReqVO;
import cn.cotenite.bearing.domain.vo.rsp.PageRspVO;
import cn.cotenite.bearing.domain.vo.rsp.UserDetailVO;
import cn.cotenite.bearing.service.UserService;
import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    @GetMapping("/get")
    public Response<UserDetailVO> get(@RequestParam Long id){
        UserDetailVO detailVO=userService.getDetailById(id);
        return Response.success(detailVO);
    }

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

    @GetMapping("/list")
    public Response<PageRspVO> list( PageReqVO reqVO){
        PageRspVO rspVO=userService.getPage(reqVO);
        return Response.success(rspVO);
    }

    @PostMapping("/delete")
    @SaCheckRole(value = {"admin","superAdmin"},mode = SaMode.OR)
    public Response<Void> deleteUser(@Validated @RequestBody Long id){
        userService.removeById(id);
        return Response.success();
    }

}
