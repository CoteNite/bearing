package cn.cotenite.bearing.listener;

import cn.cotenite.bearing.service.WorkerScheduleService;
import cn.cotenite.bearing.utils.RedisKeyUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

/**
 * @Author RichardYoung
 * @Description
 * @Date 3/2/2025 5:21 AM
 */
@Slf4j
@Component
public class RedisKeyExpireListener  extends KeyExpirationEventMessageListener  {

    @Resource
    private WorkerScheduleService workerScheduleService;

    public RedisKeyExpireListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String key=message.toString();
        if (!key.equals(RedisKeyUtil.buildUserWorkKey())){
            return;
        }
        log.info("工人已换班，开始更新工作工人!!!");
        workerScheduleService.saveWorkingWorker();

    }
}
