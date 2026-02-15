package com.warmhouse.monitoring.service;

import com.warmhouse.monitoring.model.entity.TelemetryData;
import com.warmhouse.monitoring.repository.DeviceRepository;
import com.warmhouse.monitoring.repository.TelemetryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;

@Slf4j
@Service
public class TelemetryService {

    private final TelemetryRepository telemetryRepository;
    private final DeviceRepository deviceRepository;

    public TelemetryService(TelemetryRepository telemetryRepository, DeviceRepository deviceRepository) {
        this.telemetryRepository = telemetryRepository;
        this.deviceRepository = deviceRepository;
    }

    @Transactional
    public void processTelemetry(String deviceId, BigDecimal value, String unit) {
        TelemetryData data = new TelemetryData(deviceId, value, unit, Instant.now(), null);
        if (validateTelemetry(data)) {
            log.info("Save telemetry deviceId = {}", deviceId);
            telemetryRepository.save(data);
        }
    }

    public boolean validateTelemetry(TelemetryData data) {
        return data.getValue() != null && data.getDeviceId() != null && data.getUnit() != null &&
                deviceRepository.existsById(data.getDeviceId());
    }
}
