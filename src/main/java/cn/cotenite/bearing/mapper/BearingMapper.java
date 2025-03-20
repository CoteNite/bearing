package cn.cotenite.bearing.mapper;

import cn.cotenite.bearing.domain.po.Bearing;
import cn.cotenite.bearing.domain.vo.rsp.BearingDetailVO;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author 29543
* @description 针对表【bearing】的数据库操作Mapper
* @createDate 2025-03-07 19:09:34
* @Entity cn.cotenite.bearing.domain.po.Bearing
*/
@Mapper
public interface BearingMapper extends BaseMapper<Bearing> {

    Page<BearingDetailVO> selectPage4List(Page<Bearing> page, @Param("name") String name, @Param("status") Integer status);

}




