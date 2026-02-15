package com.warmhouse.monitoring.controller;

import com.warmhouse.monitoring.model.dto.DeviceStatusDTO;
import com.warmhouse.monitoring.model.dto.MetricsDTO;
import com.warmhouse.monitoring.model.dto.TelemetryDTO;
import com.warmhouse.monitoring.service.DeviceService;
import com.warmhouse.monitoring.service.MonitoringService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class MonitoringController {

    private final MonitoringService monitoringService;
    private final DeviceService deviceService;

    @GetMapping("/telemetry")
    public ResponseEntity<List<TelemetryDTO>> getTelemetry(
            @RequestParam(required = false) String deviceId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant from,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant to
    ) {
        if (from == null) from = Instant.now().minusSeconds(3600);
        if (to == null) to = Instant.now();
        if (deviceId == null) deviceId = "device-001";

        return ResponseEntity.ok(monitoringService.getDeviceTelemetry(deviceId, from, to));
    }

    @GetMapping("/telemetry/{deviceId}/latest")
    public ResponseEntity<TelemetryDTO> getLatestTelemetry(@PathVariable String deviceId) {
        return monitoringService.getLatestTelemetry(deviceId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/devices/{deviceId}/status")
    public ResponseEntity<DeviceStatusDTO> getDeviceStatus(@PathVariable String deviceId) {
        return deviceService.getDeviceStatus(deviceId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/metrics/{deviceId}")
    public ResponseEntity<MetricsDTO> getAggregatedMetrics(
            @PathVariable String deviceId,
            @RequestParam(required = false, defaultValue = "DAILY") String aggregation
    ) {
        Instant from = switch (aggregation.toUpperCase()) {
            case "HOURLY" -> Instant.now().minusSeconds(3600);
            case "DAILY" -> Instant.now().minusSeconds(86400);
            case "WEEKLY" -> Instant.now().minusSeconds(604800);
            case "MONTHLY" -> Instant.now().minusSeconds(2592000);
            default -> Instant.now().minusSeconds(86400);
        };
        Instant to = Instant.now();

        return ResponseEntity.ok(monitoringService.getAggregatedMetrics(deviceId, from, to));
    }
}
