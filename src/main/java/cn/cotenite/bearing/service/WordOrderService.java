package cn.cotenite.bearing.service;

import cn.cotenite.bearing.domain.po.WordOrder;
import cn.cotenite.bearing.domain.vo.rsp.WorkOrderReqVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 29543
* @description 针对表【word_order】的数据库操作Service
* @createDate 2025-03-02 06:06:16
*/
public interface WordOrderService extends IService<WordOrder> {

    void createOrder();

    Page<WorkOrderReqVO> getList(Page<WorkOrderReqVO> page, Long id, String realName, Integer wrong, Integer status);
}
