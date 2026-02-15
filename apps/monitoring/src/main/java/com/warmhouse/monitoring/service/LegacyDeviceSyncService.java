package com.warmhouse.monitoring.service;


import com.warmhouse.monitoring.legacy.smart_home.api.SensorsApi;
import com.warmhouse.monitoring.legacy.smart_home.model.Sensor;
import com.warmhouse.monitoring.model.entity.Device;
import com.warmhouse.monitoring.model.enums.DeviceStatus;
import com.warmhouse.monitoring.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LegacyDeviceSyncService {

    private final DeviceRepository deviceRepository;
    private final SensorsApi sensorsApi;

    private Device toDevice(Sensor sensor) {
        return new Device(String.valueOf(sensor.getId()),
                sensor.getName(),
                sensor.getStatus() == Sensor.StatusEnum.ACTIVE ? DeviceStatus.ONLINE : DeviceStatus.OFFLINE);
    }

    @Transactional
    @Scheduled(cron = "0 */1 * * * *")
    public void syncDevices() {
        List<Sensor> sensors = sensorsApi.apiV1SensorsGet();
        if (sensors != null) {
            for (Sensor sensor : sensors) {
                if (!deviceRepository.existsById(String.valueOf(sensor.getId()))) {
                    log.info("Saving new device {}", sensor.getId());
                    deviceRepository.save(toDevice(sensor));
                }
            }
        }
    }
}
