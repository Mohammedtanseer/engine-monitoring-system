package com.engine.config;

import com.engine.model.EngineSensorData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

@Configuration
public class ProcessingConfig {

    @Bean
    public BlockingQueue<EngineSensorData> queue() {
        return new LinkedBlockingQueue<>(1000);
    }

    @Bean
    public ExecutorService executorService() {
        return Executors.newFixedThreadPool(4);
    }
}

