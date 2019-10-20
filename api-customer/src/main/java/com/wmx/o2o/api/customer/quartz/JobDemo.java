package com.wmx.o2o.api.customer.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JobDemo implements Job {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.info("jobDemo is running the job key is: {}", context.getJobDetail().getKey());
        logger.info("jobDemo get param : {}", context.getMergedJobDataMap().get("testKey"));
    }
}
