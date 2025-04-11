package com.github.ducknowledges.spring_boot_scheduler;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner checkBeansRunner(ApplicationContext context) {
        return args -> {
            System.out.println("\n=====================================");
            System.out.println("ПРОВЕРКА СОЗДАННЫХ БИНОВ В КОНТЕКСТЕ");
            System.out.println("=====================================\n");

            // Проверяем, созданы ли наши классы в контексте Spring
            checkBeanExists(context, "classLevelConditionalScheduler");
            checkBeanExists(context, "methodLevelConditionalScheduler");
            checkBeanExists(context, "beanScheduler"); // Бин из BeanConditionalConfig
            checkBeanExists(context, "internalCheckScheduler");

            System.out.println("\n=====================================");
            System.out.println("РЕЗУЛЬТАТЫ ЭКСПЕРИМЕНТА:");
            System.out.println("=====================================\n");

            System.out.println("1. @ConditionalOnProperty на уровне класса: " +
                    (context.containsBean("classLevelConditionalScheduler") ? "РАБОТАЕТ" : "НЕ РАБОТАЕТ"));

            System.out.println("2. @ConditionalOnProperty на уровне метода с @Scheduled: " +
                    (context.containsBean("methodLevelConditionalScheduler") ? "ВСЕГДА РАБОТАЕТ (НЕ РАБОТАЕТ КАК ОЖИДАЕТСЯ)" : "НЕ РАБОТАЕТ"));

            System.out.println("3. @ConditionalOnProperty на методе с @Bean, создающем шедулер: " +
                    (context.containsBean("beanScheduler") ? "РАБОТАЕТ" : "НЕ РАБОТАЕТ"));

            System.out.println("4. Проверка условия внутри метода: " +
                    (context.containsBean("internalScheduler") ? "РАБОТАЕТ (ПРОВЕРКА ВНУТРИ МЕТОДА)" : "НЕ РАБОТАЕТ"));

            System.out.println("\nПодождите несколько секунд, чтобы увидеть, какие планировщики выполняются...");
        };
    }

    private void checkBeanExists(ApplicationContext context, String beanName) {
        boolean exists = context.containsBean(beanName);
        System.out.println("Бин '" + beanName + "': " + (exists ? "СОЗДАН" : "НЕ СОЗДАН"));
    }
}
