package cn.cotenite.bearing.run;

import cn.cotenite.bearing.common.enums.UserRoleEnum;
import cn.cotenite.bearing.domain.dto.UserRedisDTO;
import cn.cotenite.bearing.domain.po.WorkerSchedule;
import cn.cotenite.bearing.mapper.UserMapper;
import cn.cotenite.bearing.mapper.WorkerScheduleMapper;
import cn.cotenite.bearing.service.UserService;
import cn.cotenite.bearing.service.WorkerScheduleService;
import cn.cotenite.bearing.utils.RedisKeyUtil;
import cn.cotenite.bearing.utils.TimeUtil;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author RichardYoung
 * @Description
 * @Date 3/2/2025 3:05 AM
 */
@Slf4j
@Component
public class MyInitializer implements ApplicationRunner {

    @Resource
    private UserService userService;

    @Resource
    private WorkerScheduleService workerScheduleService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("==> 服务启动,开始同步当前工人信息数据到 Redis 中...");
        userService.getAllUser4Redis();
        workerScheduleService.saveWorkingWorker();
        log.info("==> 服务启动成功!!!!!!");
    }
}
