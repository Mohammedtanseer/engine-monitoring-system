package com.engine.repository;

import com.engine.model.EngineSensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EngineDataRepository
        extends JpaRepository<EngineSensorData, Long> {

    List<EngineSensorData> findByEngineId(String engineId);
}

