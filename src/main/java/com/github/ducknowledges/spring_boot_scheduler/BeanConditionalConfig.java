package com.github.ducknowledges.spring_boot_scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class BeanConditionalConfig {

    @Bean
    @ConditionalOnProperty(name = "scheduler.enabled", havingValue = "true")
    public BeanScheduler beanScheduler() {
        log.info("Creating BeanScheduler bean");
        return new BeanScheduler();
    }

}
