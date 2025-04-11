package com.github.ducknowledges.spring_boot_scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MethodLevelConditionalScheduler {

    @Scheduled(fixedRate = 5000)
    @ConditionalOnProperty(name = "scheduler.enabled", havingValue = "true")
    public void scheduledTask() {
        log.info("Method-level conditional scheduler is running");
    }
}
