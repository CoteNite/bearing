package cn.cotenite.bearing.mapper;

import cn.cotenite.bearing.domain.po.BearingWrong;
import cn.cotenite.bearing.domain.vo.rsp.BearingDetailVO;
import cn.cotenite.bearing.domain.vo.rsp.BearingWrongDetailVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 29543
* @description 针对表【bearing_status】的数据库操作Mapper
* @createDate 2025-03-01 21:06:15
* @Entity cn.cotenite.bearing.domain.po.BearingWrong
*/
@Mapper
public interface BearingWrongMapper extends BaseMapper<BearingWrong> {

    void updateStatusById(@Param("id")Long id,@Param("status")Integer status);

    void finished(@Param("bearingId")Long bearingId);

    List<BearingWrongDetailVO> selectBearingDetail(Page<BearingDetailVO> bearingDetailVOPage);

}




