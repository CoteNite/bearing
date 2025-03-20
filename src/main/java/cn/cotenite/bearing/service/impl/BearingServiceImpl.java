package cn.cotenite.bearing.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.cotenite.bearing.domain.po.Bearing;
import cn.cotenite.bearing.service.BearingService;
import cn.cotenite.bearing.mapper.BearingMapper;
import org.springframework.stereotype.Service;

/**
* @author 29543
* @description 针对表【bearing】的数据库操作Service实现
* @createDate 2025-03-07 19:09:34
*/
@Service
public class BearingServiceImpl extends ServiceImpl<BearingMapper, Bearing> implements BearingService{

    @Override
    public Page<Bearing> getPage(Page<Bearing> page) {
        return null;
    }
}




