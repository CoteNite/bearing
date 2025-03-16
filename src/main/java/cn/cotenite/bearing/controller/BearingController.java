package cn.cotenite.bearing.controller;

import cn.cotenite.bearing.common.response.Response;
import cn.cotenite.bearing.domain.po.Bearing;
import cn.cotenite.bearing.domain.vo.req.BearingAddVO;
import cn.cotenite.bearing.domain.vo.req.BearingUpdateVO;
import cn.cotenite.bearing.domain.vo.req.IdReqVO;
import cn.cotenite.bearing.domain.vo.req.PageReqVO;
import cn.cotenite.bearing.domain.vo.rsp.BearingDetailVO;
import cn.cotenite.bearing.domain.vo.rsp.PageRspVO;
import cn.cotenite.bearing.service.BearingService;
import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author RichardYoung
 * @Description
 * @Date 3/7/2025 7:14 PM
 */
@RestController
@SaCheckLogin
@RequestMapping("/bearing")
public class BearingController {

    @Resource
    private BearingService bearingService;

    @PostMapping("/add")
    @SaCheckRole(value = {"admin","superAdmin"},mode = SaMode.OR)
    public Response<Void> addBearing(@Validated @RequestBody BearingAddVO reqVO){
        Bearing bearing=new Bearing();
        BeanUtils.copyProperties(reqVO,bearing);
        bearingService.save(bearing);
        return Response.success();
    }

    @PostMapping("/update")
    @SaCheckRole(value = {"admin","superAdmin"},mode = SaMode.OR)
    public Response<Void> updateBearing(@RequestBody @Validated BearingUpdateVO reqVO){
        Bearing bearing=new Bearing();
        BeanUtils.copyProperties(reqVO,bearing);
        bearingService.save(bearing);
        return Response.success();
    }

    @GetMapping("/list")
    public Response<PageRspVO<BearingDetailVO>> list(PageReqVO reqVO){

        Page<Bearing> page=new Page<>(reqVO.getPageCurrent(), reqVO.getPageCurrent());
        page = bearingService.page(page);
        List<BearingDetailVO> list = page.getRecords()
                .stream()
                .map(item -> {
                    BearingDetailVO vo = new BearingDetailVO();
                    BeanUtils.copyProperties(item, vo);
                    return vo;
                })
                .toList();
        return Response.success(PageRspVO.<BearingDetailVO>builder()
                        .dataList(list)
                        .pageCurrent(page.getCurrent())
                        .pageSize(page.getSize())
                .build());
    }

    @PostMapping("/delete")
    @SaCheckRole(value = {"admin","superAdmin"},mode = SaMode.OR)
    public Response<Void> deleteBearing(@Validated @RequestBody IdReqVO vo){
        bearingService.removeById(vo.getId());
        return Response.success();
    }

}
