package cn.cotenite.bearing.mapper;

import cn.cotenite.bearing.domain.po.Bearing;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 29543
* @description 针对表【bearing】的数据库操作Mapper
* @createDate 2025-03-07 19:09:34
* @Entity cn.cotenite.bearing.domain.po.Bearing
*/
@Mapper
public interface BearingMapper extends BaseMapper<Bearing> {


}




