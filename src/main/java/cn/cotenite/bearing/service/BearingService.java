package cn.cotenite.bearing.service;

import cn.cotenite.bearing.domain.po.Bearing;
import cn.cotenite.bearing.domain.vo.rsp.BearingDetailVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 29543
* @description 针对表【bearing】的数据库操作Service
* @createDate 2025-03-07 19:09:34
*/
public interface BearingService extends IService<Bearing> {

    Page<BearingDetailVO> getPage(Page<Bearing> page, String name, Integer status);
}
