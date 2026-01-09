package com.engine.controller;

import com.engine.model.EngineAlert;
import com.engine.model.EngineSensorData;
import com.engine.repository.EngineAlertRepository;
import com.engine.repository.EngineDataRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/engines")
public class EngineController {

    private final EngineDataRepository dataRepo;
    private final EngineAlertRepository alertRepo;

    public EngineController(
            EngineDataRepository dataRepo,
            EngineAlertRepository alertRepo) {
        this.dataRepo = dataRepo;
        this.alertRepo = alertRepo;
    }

    @GetMapping("/{id}/metrics")
    public List<EngineSensorData> getMetrics(@PathVariable String id) {
        return dataRepo.findByEngineId(id);
    }

    @GetMapping("/{id}/alerts")
    public List<EngineAlert> getAlerts(@PathVariable String id) {
        return alertRepo.findByEngineId(id);
    }
}

