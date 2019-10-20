package com.wmx.o2o.api.customer.quartz;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JobHandlerDemo {

    private JobDetail jobDemoDetail02;

    private Scheduler scheduler;

    @Autowired
    public void setJobDemoDetail02(JobDetail jobDemoDetail02) {
        this.jobDemoDetail02 = jobDemoDetail02;
    }

    @Autowired
    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void testJobDemo() {
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder
                .simpleSchedule()
                .withIntervalInSeconds(10)
                .withRepeatCount(0);

        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .forJob(jobDemoDetail02)
                .usingJobData("testKey", "testVal")
                .withSchedule(simpleScheduleBuilder).startAt(new Date()).build();

        try {
            scheduler.scheduleJob(trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
