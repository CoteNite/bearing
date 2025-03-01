package cn.cotenite.bearing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class BearingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BearingApplication.class, args);
    }

}
