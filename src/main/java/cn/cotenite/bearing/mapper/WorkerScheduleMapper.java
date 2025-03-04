package cn.cotenite.bearing.mapper;


import cn.cotenite.bearing.domain.aggregate.WorkScheduleAggregate;
import cn.cotenite.bearing.domain.po.WorkerSchedule;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 29543
* @description 针对表【worker_schedule】的数据库操作Mapper
* @createDate 2025-03-02 04:23:23
* @Entity cn.cotenite.bearing.domain.po.WorkerSchedule
*/
@Mapper
public interface WorkerScheduleMapper extends BaseMapper<WorkerSchedule> {

    List<WorkScheduleAggregate> selectAllWorkWithSchedule();

}




