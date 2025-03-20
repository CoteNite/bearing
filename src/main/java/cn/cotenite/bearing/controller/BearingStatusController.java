package cn.cotenite.bearing.controller;

import cn.cotenite.bearing.common.response.Response;
import cn.cotenite.bearing.domain.vo.req.BearingStatusReqVO;
import cn.cotenite.bearing.domain.vo.req.BearingWrongFinishedVO;
import cn.cotenite.bearing.domain.vo.req.PageReqVO;
import cn.cotenite.bearing.domain.vo.rsp.BearingStatusRspVO;
import cn.cotenite.bearing.domain.vo.rsp.PageRspVO;
import cn.cotenite.bearing.service.BearingWrongService;
import cn.dev33.satoken.annotation.SaCheckLogin;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author RichardYoung
 * @Description
 * @Date 3/1/2025 9:07 PM
 */
@RestController
@RequestMapping("/bearingStatus")
public class BearingStatusController {

    @Resource
    private BearingWrongService bearingWrongService;

    @PostMapping("/add")
    private Response<Void> add(@RequestBody @Validated BearingStatusReqVO reqVO){
        bearingWrongService.addBearingStatus(reqVO);
        return Response.success();
    }

    @GetMapping("/list")
    @SaCheckLogin
    private Response<PageRspVO<?>> list(@Validated PageReqVO pageVO){
        PageRspVO<BearingStatusRspVO> pageRspVO = bearingWrongService.list(pageVO);
        return Response.success(pageRspVO);
    }

    @PostMapping("/finished")
    @SaCheckLogin
    private Response<Void> finished(@RequestBody BearingWrongFinishedVO reqVO){
        bearingWrongService.finished(reqVO);
        return Response.success();
    }

}
