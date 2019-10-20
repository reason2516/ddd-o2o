package com.wmx.o2o.api.customer.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleDemo {
    public Logger logger = LoggerFactory.getLogger(getClass());

//    @Scheduled(fixedDelay = 3000L)
    public void job01() {
        logger.info("job01 is doing : {} ", System.currentTimeMillis());
    }

//    @Scheduled(fixedDelay = 1000L)
    public void job02() {
        logger.info("job02 is start : {} ", System.currentTimeMillis());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("job02 is end   : {} ", System.currentTimeMillis());
    }

//    @Scheduled(cron = "*/1 * * * * *")
    public void job03(){
        logger.info("job03 is begin : {} ", System.currentTimeMillis());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("job03 is end   : {} ", System.currentTimeMillis());


    }
}
