package com.github.ducknowledges.spring_boot_scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ConditionalOnProperty(name = "scheduler.enabled", havingValue = "true")

public class ClassLevelConditionalScheduler {
    @Scheduled(fixedRate = 5000)
    public void scheduledTask() {
        log.info("Class-level conditional scheduler is running");
    }
}
