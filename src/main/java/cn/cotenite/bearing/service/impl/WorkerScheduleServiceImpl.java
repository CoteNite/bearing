package cn.cotenite.bearing.service.impl;

import cn.cotenite.bearing.domain.aggregate.WorkScheduleAggregate;
import cn.cotenite.bearing.utils.RedisKeyUtil;
import cn.cotenite.bearing.utils.TimeUtil;
import cn.cotenite.bearing.service.WorkerScheduleService;
import cn.cotenite.bearing.mapper.WorkerScheduleMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
* @author 29543
* @description 针对表【worker_schedule】的数据库操作Service实现
* @createDate 2025-03-02 04:23:23
*/
@Slf4j
@Service
public class WorkerScheduleServiceImpl implements WorkerScheduleService{

    @Resource
    private WorkerScheduleMapper workerScheduleMapper;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public void saveWorkingWorker() {
        List<WorkScheduleAggregate> workScheduleAggregates = workerScheduleMapper.selectAllWorkWithSchedule();
        List<Long> workingWorkerList=new ArrayList<>();
        for (WorkScheduleAggregate aggregate:workScheduleAggregates){
            workingWorkerList.add(aggregate.getWorkerId());

        }
        if (!workingWorkerList.isEmpty()) {
            redisTemplate.opsForSet().add(
                    RedisKeyUtil.buildUserWorkKey(),
                    workingWorkerList.toArray(new Long[0])
            );

            if (workScheduleAggregates.get(0) != null) {
                redisTemplate.expire(
                        RedisKeyUtil.buildUserWorkKey(),
                        TimeUtil.betweenNow2EndLong(workScheduleAggregates.get(0).getGetOffTime()),
                        TimeUnit.SECONDS
                );
            }
        } else {
            log.warn("当前无有效的工作排班数据");
        }
    }


}




