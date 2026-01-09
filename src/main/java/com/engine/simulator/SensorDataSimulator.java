package com.engine.simulator;

import com.engine.model.EngineSensorData;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.concurrent.BlockingQueue;

@Component
public class SensorDataSimulator {

    private final BlockingQueue<EngineSensorData> queue;

    public SensorDataSimulator(BlockingQueue<EngineSensorData> queue) {
        this.queue = queue;
    }

    @Scheduled(fixedRate = 200)
    public void generateData() throws InterruptedException {
        EngineSensorData data = new EngineSensorData();
        data.setEngineId("ENG-1");
        data.setTemperature(600 + Math.random() * 200);
        data.setPressure(30 + Math.random() * 10);
        data.setRpm(4000 + (int) (Math.random() * 2000));
        data.setTimestamp(Instant.now());

        queue.put(data);
    }
}

