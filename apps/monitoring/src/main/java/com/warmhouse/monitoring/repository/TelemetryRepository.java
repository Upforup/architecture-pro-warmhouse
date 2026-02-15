package com.warmhouse.monitoring.repository;

import com.warmhouse.monitoring.model.entity.TelemetryData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface TelemetryRepository extends JpaRepository<TelemetryData, Long> {

    Optional<TelemetryData> findFirstByDeviceIdOrderByTimestampDesc(String deviceId);

    @Query("SELECT t FROM TelemetryData t WHERE t.deviceId = :deviceId AND t.timestamp BETWEEN :from AND :to")
    List<TelemetryData> findByDeviceIdAndTimeRange(@Param("deviceId") String deviceId,
                                                   @Param("from") Instant from,
                                                   @Param("to") Instant to);

    void deleteByTimestampBefore(Instant timestamp);
}
