package cn.cotenite.bearing.service.impl;

import cn.cotenite.bearing.common.enums.StatusEnum;
import cn.cotenite.bearing.common.enums.WrongEnum;
import cn.cotenite.bearing.domain.vo.req.BearingStatusReqVO;
import cn.cotenite.bearing.domain.vo.req.PageReqVO;
import cn.cotenite.bearing.domain.vo.rsp.BearingStatusRspVO;
import cn.cotenite.bearing.domain.vo.rsp.PageRspVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.cotenite.bearing.domain.po.BearingStatus;
import cn.cotenite.bearing.service.BearingStatusService;
import cn.cotenite.bearing.mapper.BearingStatusMapper;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author 29543
* @description 针对表【bearing_status】的数据库操作Service实现
* @createDate 2025-03-01 21:06:15
*/
@Service
public class BearingStatusServiceImpl extends ServiceImpl<BearingStatusMapper, BearingStatus> implements BearingStatusService{

    @Resource
    private BearingStatusMapper bearingStatusMapper;

    @Override
    public void addBearingStatus(BearingStatusReqVO reqVO) {
        BearingStatus bearingStatus=new BearingStatus();
        BeanUtils.copyProperties(reqVO,bearingStatus);
        bearingStatus.setStatus(0);
        bearingStatusMapper.insert(bearingStatus);
    }

    @Override
    public PageRspVO<BearingStatusRspVO> list(PageReqVO pageVO) {
        Page<BearingStatus> page=new Page<>(pageVO.getPageCurrent(),pageVO.getPageSize());
        Page<BearingStatus> bearingStatusPage = bearingStatusMapper.selectPage(page, null);
        List<BearingStatus> records = bearingStatusPage.getRecords();
        List<BearingStatusRspVO> list=new ArrayList<>();
        for (BearingStatus item:records){
            BearingStatusRspVO rspVO=new BearingStatusRspVO();
            BeanUtils.copyProperties(item,rspVO);
            rspVO.setStatus(StatusEnum.getStatus(item.getStatus()));
            rspVO.setWrong(WrongEnum.getWrong(item.getWrong()));
            list.add(rspVO);
        }
        return new PageRspVO<>(bearingStatusPage.getCurrent(),bearingStatusPage.getSize(),list);
    }

}




