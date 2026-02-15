package com.warmhouse.monitoring.model.dto;

import java.math.BigDecimal;
import java.time.Instant;

public record TelemetryDTO(
        String deviceId,
        BigDecimal value,
        String unit,
        Instant timestamp
) {
}
