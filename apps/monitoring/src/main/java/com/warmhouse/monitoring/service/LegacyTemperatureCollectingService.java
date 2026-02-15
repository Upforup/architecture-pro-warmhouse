package com.warmhouse.monitoring.service;


import com.warmhouse.monitoring.legacy.smart_home.api.SensorsApi;
import com.warmhouse.monitoring.legacy.smart_home.model.Sensor;
import com.warmhouse.monitoring.model.entity.Device;
import com.warmhouse.monitoring.model.enums.DeviceStatus;
import com.warmhouse.monitoring.repository.DeviceRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LegacyTemperatureCollectingService {

    private final TelemetryService telemetryService;
    private final DeviceRepository deviceRepository;
    private final SensorsApi sensorsApi;




    @Scheduled(cron = "0 */1 * * * *")
    public void collectLegacyTemperatureSensorData() {
        List<Sensor> sensors = sensorsApi.apiV1SensorsGet();
        if (sensors != null) {
            for (Sensor sensor : sensors) {
                log.info("Process telemetry {}", sensor);
                telemetryService.processTelemetry(String.valueOf(sensor.getId()), sensor.getValue(), sensor.getUnit());
            }
        }
        log.info("update temperature sensor metrics");
    }
}
