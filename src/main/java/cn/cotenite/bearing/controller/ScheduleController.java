package cn.cotenite.bearing.controller;

import cn.cotenite.bearing.common.response.Response;

import cn.cotenite.bearing.domain.po.Schedule;
import cn.cotenite.bearing.domain.vo.req.ScheduleAddVO;
import cn.cotenite.bearing.domain.vo.req.ScheduleUpdateVO;
import cn.cotenite.bearing.domain.vo.rsp.ScheduleRspVO;
import cn.cotenite.bearing.service.ScheduleService;
import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author RichardYoung
 * @Description
 * @Date 3/6/2025 8:32 PM
 */
@SaCheckLogin
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Resource
    private ScheduleService scheduleService;

    @SaCheckRole(value = {"admin","superAdmin"},mode = SaMode.OR)
    @GetMapping("/list")
    public Response<List<ScheduleRspVO>> list(){
        List<Schedule> list = scheduleService.list();
        List<ScheduleRspVO> vos = list.stream().map(item -> ScheduleRspVO.builder()
                .id(item.getId())
                .startTime(item.getStartTime())
                .getOffTime(item.getGetOffTime())
                .build()).toList();
        return Response.success(vos);
    }

    @SaCheckRole(value = {"admin","superAdmin"},mode = SaMode.OR)
    @PostMapping("/add")
    public Response<Void> add(@Validated @NotNull ScheduleAddVO addVO){
        Schedule schedule=new Schedule();
        BeanUtils.copyProperties(addVO,schedule);
        scheduleService.save(schedule);
        return Response.success();
    }

    @SaCheckRole(value = {"admin","superAdmin"},mode = SaMode.OR)
    @PostMapping("/update")
    public Response<Void> update(ScheduleUpdateVO updateVO){
        Schedule schedule=new Schedule();
        BeanUtils.copyProperties(updateVO,schedule);
        scheduleService.updateById(schedule);
        return Response.success();
    }


    @SaCheckRole(value = {"admin","superAdmin"},mode = SaMode.OR)
    @PostMapping("/delete")
    public Response<Void> delete(@Validated @NotNull Long id){
        scheduleService.removeById(id);
        return Response.success();
    }


}
