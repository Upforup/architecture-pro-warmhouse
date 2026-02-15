package com.warmhouse.monitoring.model;

import java.time.Instant;

public record DeviceStatusDTO(
        String deviceId,
        String status,
        Instant lastSeen
) {
}
