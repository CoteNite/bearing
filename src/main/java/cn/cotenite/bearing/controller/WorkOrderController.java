package cn.cotenite.bearing.controller;

import cn.cotenite.bearing.common.response.Response;
import cn.cotenite.bearing.domain.vo.req.PageReqVO;
import cn.cotenite.bearing.domain.vo.rsp.PageRspVO;
import cn.cotenite.bearing.domain.vo.rsp.WorkOrderReqVO;
import cn.cotenite.bearing.service.WordOrderService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    public Response<PageRspVO<WorkOrderReqVO>> list(PageReqVO pageReqVO, Long id, String realName, Integer wrong, Integer status){
        Page<WorkOrderReqVO> page=new Page<>(pageReqVO.getPageCurrent(), pageReqVO.getPageSize());
        Page<WorkOrderReqVO> workOrderReqVOPage=workOrderService.getList(page,id,realName,wrong,status);
        return Response.success(
                PageRspVO.<WorkOrderReqVO>builder()
                        .dataList(workOrderReqVOPage.getRecords())
                        .pageCurrent(workOrderReqVOPage.getCurrent())
                        .pageSize(workOrderReqVOPage.getSize())
                        .build()
        );
    }
}
