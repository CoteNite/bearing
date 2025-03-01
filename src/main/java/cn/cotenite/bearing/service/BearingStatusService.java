package cn.cotenite.bearing.service;

import cn.cotenite.bearing.domain.po.BearingStatus;
import cn.cotenite.bearing.domain.vo.req.BearingStatusReqVO;
import cn.cotenite.bearing.domain.vo.req.PageReqVO;
import cn.cotenite.bearing.domain.vo.rsp.BearingStatusRspVO;
import cn.cotenite.bearing.domain.vo.rsp.PageRspVO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 29543
* @description 针对表【bearing_status】的数据库操作Service
* @createDate 2025-03-01 21:06:15
*/
public interface BearingStatusService extends IService<BearingStatus> {

    void addBearingStatus(BearingStatusReqVO reqVO);

    PageRspVO<BearingStatusRspVO> list(PageReqVO pageVO);
}
