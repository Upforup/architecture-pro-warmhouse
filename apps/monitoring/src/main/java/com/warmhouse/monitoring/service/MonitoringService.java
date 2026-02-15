package com.warmhouse.monitoring.service;

import com.warmhouse.monitoring.model.dto.MetricsDTO;
import com.warmhouse.monitoring.model.dto.TelemetryDTO;
import com.warmhouse.monitoring.model.entity.TelemetryData;
import com.warmhouse.monitoring.repository.TelemetryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MonitoringService {

    private final TelemetryRepository telemetryRepository;

    public List<TelemetryDTO> getDeviceTelemetry(String deviceId, Instant from, Instant to) {
        List<TelemetryData> data = telemetryRepository.findByDeviceIdAndTimeRange(deviceId, from, to);
        return data.stream()
                .map(this::toDTO)
                .sorted(Comparator.comparing(TelemetryDTO::timestamp).reversed())
                .toList();
    }

    public Optional<TelemetryDTO> getLatestTelemetry(String deviceId) {
        return telemetryRepository.findFirstByDeviceIdOrderByTimestampDesc(deviceId)
                .map(this::toDTO);
    }

    public MetricsDTO getAggregatedMetrics(String deviceId, Instant from, Instant to) {
        List<TelemetryData> data = telemetryRepository.findByDeviceIdAndTimeRange(deviceId, from, to);

        if (data.isEmpty()) {
            return new MetricsDTO(deviceId, 0.0, 0.0, 0.0, 0L);
        }

        DoubleSummaryStatistics stats = data.stream()
                .map(TelemetryData::getValue)
                .mapToDouble(BigDecimal::doubleValue)
                .summaryStatistics();

        return new MetricsDTO(deviceId, stats.getAverage(), stats.getMin(), stats.getMax(), stats.getCount());
    }

    private TelemetryDTO toDTO(TelemetryData entity) {
        return new TelemetryDTO(
                entity.getDeviceId(),
                entity.getValue(),
                entity.getUnit(),
                entity.getTimestamp()
        );
    }
}
