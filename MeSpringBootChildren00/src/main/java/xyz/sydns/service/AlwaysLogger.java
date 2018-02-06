package xyz.sydns.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.ScheduledMethodRunnable;
import org.springframework.stereotype.Service;
import xyz.sydns.utils.Global;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

/**
 * 如何使用 lombok 的日志注解:
 * https://stackoverflow.com/questions/43901810/spring-boot-logging-with-lombok
 * Slf4j :
 * Simple Logging Facade for Java
 * Facade(面,正面,表面)
 * logback Slf4j
 * SpringBoot 如何定时执行任务:
 * https://stackoverflow.com/questions/36541857/spring-boot-infinite-loop-service
 *
 * @author sqsgalaxys
 */
@Service
@Slf4j
public class AlwaysLogger {


    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        if (Global.isStop) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            log.info("The time is now {}", dateFormat.format(new Date()));
        }
        // log.info("logging 1");
    }

    @Scheduled(fixedRate = 4000)
    public void outLogger() {
        if (Global.isStop) {
            log.error("logging....");
        }
        // log.info("logging 2");
    }


}