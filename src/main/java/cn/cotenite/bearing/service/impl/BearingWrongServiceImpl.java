package cn.cotenite.bearing.service.impl;

import cn.cotenite.bearing.common.enums.StatusEnum;
import cn.cotenite.bearing.common.enums.WrongEnum;
import cn.cotenite.bearing.domain.po.Bearing;
import cn.cotenite.bearing.domain.po.BearingWrong;
import cn.cotenite.bearing.domain.vo.req.BearingStatusReqVO;
import cn.cotenite.bearing.domain.vo.req.BearingWrongFinishedVO;
import cn.cotenite.bearing.domain.vo.req.PageReqVO;
import cn.cotenite.bearing.domain.vo.rsp.BearingDetailVO;
import cn.cotenite.bearing.domain.vo.rsp.BearingStatusRspVO;
import cn.cotenite.bearing.domain.vo.rsp.BearingWrongDetailVO;
import cn.cotenite.bearing.domain.vo.rsp.PageRspVO;
import cn.cotenite.bearing.mapper.BearingMapper;
import cn.cotenite.bearing.service.BearingWrongService;
import cn.cotenite.bearing.utils.RedisKeyUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.cotenite.bearing.mapper.BearingWrongMapper;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author 29543
* @description 针对表【bearing_status】的数据库操作Service实现
* @createDate 2025-03-01 21:06:15
*/
@Service
public class BearingWrongServiceImpl extends ServiceImpl<BearingWrongMapper, BearingWrong> implements BearingWrongService {

    @Resource
    private BearingWrongMapper bearingWrongMapper;

    @Resource
    private BearingMapper bearingMapper;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public void addBearingStatus(BearingStatusReqVO reqVO) {
        BearingWrong bearingWrong =new BearingWrong();
        BeanUtils.copyProperties(reqVO, bearingWrong);
        bearingWrong.setStatus(StatusEnum.WAITING.getCode());
        bearingWrongMapper.insert(bearingWrong);
        bearingMapper.update(Wrappers.<Bearing>update().set("status",1).eq("id",reqVO.getBearingId()));
        redisTemplate.opsForHash().put(RedisKeyUtil.buildBearingWrongKey(),bearingWrong.getId().toString(),reqVO);
    }

    @Override
    public PageRspVO<BearingStatusRspVO> list(PageReqVO pageVO) {
        Page<BearingWrong> page=new Page<>(pageVO.getPageCurrent(),pageVO.getPageSize());
        Page<BearingWrong> bearingStatusPage = bearingWrongMapper.selectPage(page, null).addOrder(OrderItem.desc("update_time"));
        List<BearingWrong> records = bearingStatusPage.getRecords();
        List<BearingStatusRspVO> list=new ArrayList<>();
        for (BearingWrong item:records){
            BearingStatusRspVO rspVO=new BearingStatusRspVO();
            BeanUtils.copyProperties(item,rspVO);
            rspVO.setStatus(StatusEnum.getStatus(item.getStatus()));
            rspVO.setWrong(WrongEnum.getWrong(item.getWrong()));
            list.add(rspVO);
        }
        return new PageRspVO<>(bearingStatusPage.getCurrent(),bearingStatusPage.getSize(),list);
    }

    @Override
    public void updateStatus2Paring(Long wrongId) {
        bearingWrongMapper.updateStatusById(wrongId,StatusEnum.PARING.getCode());
    }

    @Override
    public void finished(BearingWrongFinishedVO reqVO) {
        bearingWrongMapper.finished(reqVO.getBearingId());
        redisTemplate.opsForSet().add(RedisKeyUtil.buildUserWorkKey(),reqVO.getUserId());
    }

    @Override
    public List<BearingWrongDetailVO> getBearingDetailList(PageReqVO page) {
        Page<BearingDetailVO> bearingDetailVOPage=new Page<>(page.getPageCurrent(), page.getPageSize());
        return bearingWrongMapper.selectBearingDetail(bearingDetailVOPage);

    }



}




