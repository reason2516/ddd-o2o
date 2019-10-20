package com.wmx.o2o.api.customer.quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class JobDetailConfig {

    @Bean
    public JobDetailFactoryBean jobDemoFactoryBean() {
        JobDetailFactoryBean bean = new JobDetailFactoryBean();
        bean.setJobClass(JobDemo.class);
        bean.setName("jobDemo");
        bean.setBeanName("jobDemoDetail");
        bean.setGroup("demo");
        bean.setDescription("this is a demo job");
        bean.setDurability(true);
        return bean;
    }

    @Bean
    public JobDetail jobDemoDetail02(){
        return JobBuilder.newJob(JobDemo.class)
                .withIdentity("jobDemo02","demo")
                .usingJobData("test","Test")
                .storeDurably(true) // 无 trigger 绑定的job 必须为true
                .build();
    }
}
