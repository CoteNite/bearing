package cn.cotenite.bearing.service;

import cn.cotenite.bearing.domain.po.BearingWrong;
import cn.cotenite.bearing.domain.vo.req.BearingStatusReqVO;
import cn.cotenite.bearing.domain.vo.req.BearingWrongFinishedVO;
import cn.cotenite.bearing.domain.vo.req.PageReqVO;
import cn.cotenite.bearing.domain.vo.rsp.BearingStatusRspVO;
import cn.cotenite.bearing.domain.vo.rsp.BearingWrongDetailVO;
import cn.cotenite.bearing.domain.vo.rsp.PageRspVO;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 29543
* @description 针对表【bearing_status】的数据库操作Service
* @createDate 2025-03-01 21:06:15
*/
public interface BearingWrongService extends IService<BearingWrong> {


    void addBearingStatus(BearingStatusReqVO reqVO);

    PageRspVO<BearingStatusRspVO> list(PageReqVO pageVO);

    void updateStatus2Paring(Long wrongId);

    void finished(BearingWrongFinishedVO reqVO);


    List<BearingWrongDetailVO> getBearingDetailList(PageReqVO page, @Param("name")String name,@Param("status") Integer status);
}
