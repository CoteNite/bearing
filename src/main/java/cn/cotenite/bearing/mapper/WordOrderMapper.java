package cn.cotenite.bearing.mapper;

import cn.cotenite.bearing.domain.po.WordOrder;
import cn.cotenite.bearing.domain.vo.rsp.WorkOrderReqVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author 29543
* @description 针对表【word_order】的数据库操作Mapper
* @createDate 2025-03-02 06:06:16
* @Entity cn.cotenite.bearing.domain.po.WordOrder
*/
@Mapper
public interface WordOrderMapper extends BaseMapper<WordOrder> {

    Page<WorkOrderReqVO> selectPage4List(Page<WorkOrderReqVO> page, @Param("id") Long id, @Param("realName") String realName, @Param("wrong") Integer wrong,@Param("status") Integer status );
}




