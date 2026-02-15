package com.warmhouse.monitoring.listener;

import com.warmhouse.monitoring.model.enums.DeviceStatus;
import com.warmhouse.monitoring.service.DeviceService;
import com.warmhouse.monitoring.service.TelemetryService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
@Component
public class TelemetryEventListener {

    private static final Logger log = LoggerFactory.getLogger(TelemetryEventListener.class);
    public static final BigDecimal BASE = BigDecimal.valueOf(20.0D);

    private final TelemetryService telemetryService;
    private final DeviceService deviceService;

    @PostConstruct
    public void init() {
        log.info("TelemetryEventListener initialized (MQTT stubbed - generating simulated data)");
        generateSimulatedTelemetry();
    }

    private void generateSimulatedTelemetry() {
        String deviceId = "device-001";
        deviceService.updateDeviceState(deviceId, DeviceStatus.ONLINE);

        for (int i = 0; i < 20; i++) {
            telemetryService.processTelemetry(
                    deviceId,
                    BASE.add(BigDecimal.valueOf(ThreadLocalRandom.current().nextDouble(5))),
                    "°C"
            );
        }

        log.info("Generated 20 simulated telemetry readings for device: {}", deviceId);
    }
}
