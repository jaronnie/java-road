package com.jaronnie.springboot.component.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
@Slf4j
public class Test {
    @Scheduled(cron = "* * * * * *")
    public void test1() {
        log.info("\n" +
                "     __                                  .__        \n" +
                "    |__|____ _______  ____   ____   ____ |__| ____  \n" +
                "    |  \\__  \\\\_  __ \\/  _ \\ /    \\ /    \\|  |/ __ \\ \n" +
                "    |  |/ __ \\|  | \\(  <_> )   |  \\   |  \\  \\  ___/ \n" +
                "/\\__|  (____  /__|   \\____/|___|  /___|  /__|\\___  >\n" +
                "\\______|    \\/                  \\/     \\/        \\/ \n");
        log.info("every second");
    }
}
