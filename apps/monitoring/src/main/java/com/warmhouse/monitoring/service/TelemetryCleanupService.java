package com.warmhouse.monitoring.service;

import com.warmhouse.monitoring.repository.TelemetryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;

@RequiredArgsConstructor
@Service
public class TelemetryCleanupService {

    private final TelemetryRepository telemetryRepository;
    private static final int RETENTION_DAYS = 90;

    @Scheduled(cron = "0 0 2 * * ?")
    public void cleanupExpiredTelemetry() {
        Instant cutoff = Instant.now().minusSeconds(RETENTION_DAYS * 24L * 60 * 60);
        telemetryRepository.deleteByTimestampBefore(cutoff);
    }
}
