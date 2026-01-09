package com.engine.repository;

import com.engine.model.EngineAlert;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EngineAlertRepository
        extends JpaRepository<EngineAlert, Long> {

    List<EngineAlert> findByEngineId(String engineId);
}

