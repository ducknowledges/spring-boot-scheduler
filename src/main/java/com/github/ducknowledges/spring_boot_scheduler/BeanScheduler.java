package com.github.ducknowledges.spring_boot_scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
public class BeanScheduler {

    @Scheduled(fixedRate = 5000)
    public void scheduledTask() {
        log.info("Bean scheduler is running");
    }

}
