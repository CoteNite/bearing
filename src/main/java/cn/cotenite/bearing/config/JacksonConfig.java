package cn.cotenite.bearing.config;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author RichardYoung
 * @Description
 * @Date 3/6/2025 9:31 PM
 */
@Configuration
public class JacksonConfig {

    @Bean
    public JavaTimeModule javaTimeModule() {
        return new JavaTimeModule();
    }

}
