package cn.cotenite.bearing.controller;

import cn.cotenite.bearing.common.response.Response;
import cn.cotenite.bearing.domain.po.BearingStatus;
import cn.cotenite.bearing.domain.vo.req.BearingStatusReqVO;
import cn.cotenite.bearing.domain.vo.req.PageReqVO;
import cn.cotenite.bearing.domain.vo.rsp.BearingStatusRspVO;
import cn.cotenite.bearing.domain.vo.rsp.PageRspVO;
import cn.cotenite.bearing.service.BearingStatusService;
import cn.cotenite.bearing.service.impl.BearingStatusServiceImpl;
import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author RichardYoung
 * @Description
 * @Date 3/1/2025 9:07 PM
 */

@RestController
@RequestMapping("/bearingStatus")
public class BearingStatusController {

    @Resource
    private BearingStatusService bearingStatusService;

    @PostMapping("/add")
    private Response<Void> add(@RequestBody @Validated BearingStatusReqVO reqVO){
        bearingStatusService.addBearingStatus(reqVO);
        return Response.success();
    }

    @GetMapping("/list")
    @SaCheckLogin
    private Response<PageRspVO<?>> list(@Validated PageReqVO pageVO){
        PageRspVO<BearingStatusRspVO> pageRspVO = bearingStatusService.list(pageVO);
        return Response.success(pageRspVO);
    }

}
