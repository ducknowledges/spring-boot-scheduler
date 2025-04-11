package com.github.ducknowledges.spring_boot_scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InternalScheduler {

    @Value("${scheduler.enabled}")
    private boolean enabled;

    @Scheduled(fixedRate = 5000)
    public void scheduledTask() {
        if (!enabled) {
            log.info("Internal scheduler is disabled");
            return;
        }
        log.info("Internal scheduler is running");
    }
}
