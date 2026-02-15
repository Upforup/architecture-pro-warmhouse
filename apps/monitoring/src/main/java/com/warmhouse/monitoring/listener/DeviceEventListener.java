package com.warmhouse.monitoring.listener;

import com.warmhouse.monitoring.service.DeviceService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DeviceEventListener {

    private static final Logger log = LoggerFactory.getLogger(DeviceEventListener.class);

    private final DeviceService deviceService;

    @PostConstruct
    public void init() {
        log.info("DeviceEventListener initialized (Kafka stubbed - lifecycle events simulated)");
    }
}
