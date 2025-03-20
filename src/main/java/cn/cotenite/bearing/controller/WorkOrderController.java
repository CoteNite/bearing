package cn.cotenite.bearing.controller;

import cn.cotenite.bearing.domain.vo.req.PageReqVO;
import cn.cotenite.bearing.service.WordOrderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author RichardYoung
 * @Description
 * @Date 2025/3/20 21:51
 */
@RestController
@RequestMapping("/workOrder")
public class WorkOrderController {

    @Resource
    private WordOrderService workOrderService;

    @GetMapping("/list")
    public String list(PageReqVO pageReqVO,Long id, String realName){
        workOrderService.createOrder();
        return "success";
    }
}
