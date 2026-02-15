package com.warmhouse.monitoring.model;

import java.time.Instant;

public record TelemetryDTO(
        String deviceId,
        Double value,
        String unit,
        Instant timestamp
) {
}
