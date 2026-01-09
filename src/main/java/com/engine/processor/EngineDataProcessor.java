package com.engine.processor;

import com.engine.model.EngineAlert;
import com.engine.model.EngineSensorData;
import com.engine.repository.EngineAlertRepository;
import com.engine.repository.EngineDataRepository;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;

@Component
public class EngineDataProcessor {

    private final BlockingQueue<EngineSensorData> queue;
    private final EngineDataRepository dataRepo;
    private final EngineAlertRepository alertRepo;
    private final ExecutorService executor;

    public EngineDataProcessor(
            BlockingQueue<EngineSensorData> queue,
            EngineDataRepository dataRepo,
            EngineAlertRepository alertRepo,
            ExecutorService executor) {

        this.queue = queue;
        this.dataRepo = dataRepo;
        this.alertRepo = alertRepo;
        this.executor = executor;

        startProcessing();
    }

    private void startProcessing() {
        for (int i = 0; i < 4; i++) {
            executor.submit(this::process);
        }
    }

    private void process() {
        while (true) {
            try {
                EngineSensorData data = queue.take();

                if (data.getTemperature() > 750) {
                    EngineAlert alert = new EngineAlert();
                    alert.setEngineId(data.getEngineId());
                    alert.setMessage("Overheat detected");
                    alert.setTimestamp(Instant.now());
                    alertRepo.save(alert);
                }

                dataRepo.save(data);

            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

