package cn.cotenite.bearing.controller;

import cn.cotenite.bearing.common.response.Response;

import cn.cotenite.bearing.domain.po.Schedule;
import cn.cotenite.bearing.domain.vo.rsp.ScheduleRspVO;
import cn.cotenite.bearing.service.ScheduleService;
import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
