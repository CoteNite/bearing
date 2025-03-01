package cn.cotenite.bearing.listener;

import cn.cotenite.bearing.service.WordOrderService;
import jakarta.annotation.Resource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author RichardYoung
 * @Description
 * @Date 3/2/2025 6:30 AM
 */
@Component
public class BearingWrongListener {

    @Resource
    private WordOrderService wordOrderService;

    @Scheduled(cron ="*/5 * * * * ?")
    public void listenBearingWrong(){
        wordOrderService.createOrder();
    }
}
