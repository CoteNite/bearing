package cn.cotenite.bearing.service.impl;

import cn.cotenite.bearing.domain.vo.rsp.BearingDetailVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.cotenite.bearing.domain.po.Bearing;
import cn.cotenite.bearing.service.BearingService;
import cn.cotenite.bearing.mapper.BearingMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
* @author 29543
* @description 针对表【bearing】的数据库操作Service实现
* @createDate 2025-03-07 19:09:34
*/
@Service
public class BearingServiceImpl extends ServiceImpl<BearingMapper, Bearing> implements BearingService{

    @Resource
    private BearingMapper bearingMapper;

    @Override
    public Page<BearingDetailVO> getPage(Page<Bearing> page, String name, Integer status) {
        return bearingMapper.selectPage4List(page,name,status);
    }
}




