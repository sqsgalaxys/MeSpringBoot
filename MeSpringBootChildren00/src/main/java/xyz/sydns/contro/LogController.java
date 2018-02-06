package xyz.sydns.contro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xyz.sydns.utils.Global;

import java.util.concurrent.ScheduledFuture;

/**
 * Created by sqsgalaxys (AT) gmail (DOT) com
 * on 31/01/2018.
 *
 * @author sqsgalaxys
 */

@RestController
@Slf4j
public class LogController {


    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    // public LogController(ThreadPoolTaskScheduler threadPoolTaskScheduler) { this.threadPoolTaskScheduler = threadPoolTaskScheduler; }

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        return new ThreadPoolTaskScheduler();
    }

    private ScheduledFuture<?> future;

    @RequestMapping(value = "/startLoggingF", method = RequestMethod.GET)
    public ResponseEntity startLogging0() {
        future = threadPoolTaskScheduler.schedule(new MeRunnable(), new CronTrigger("0/5 * * * * *"));
        log.info("DynamicTask.startCron()");
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/startLogging", method = RequestMethod.GET)
    public ResponseEntity startLogging() {
        Global.isStop = true;
        return new ResponseEntity(HttpStatus.OK);
    }


    @RequestMapping("/stopLogging")
    public ResponseEntity stopLoggin() {
        Global.isStop = false;
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping("/shutdownLogging")
    public ResponseEntity shutdownLogging() {
        if (future != null) {
            future.cancel(true);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * /@Slf4j 这里不能使用这个注解
     */
    private class MeRunnable implements Runnable {
        @Override
        public void run() {
            log.info("Runnable log");
            // [Java代码中获取运行时内存情况 - java小强博客](http://www.javacui.com/Theory/376.html '0.0')
            log.info("free" + Runtime.getRuntime().freeMemory() / 1024 / 1024 + " M");
            log.info("total" + Runtime.getRuntime().totalMemory() / 1024 / 1024 + " M");
            log.info("max" + Runtime.getRuntime().maxMemory() / 1024 / 1024 + " M");
        }
    }
}
