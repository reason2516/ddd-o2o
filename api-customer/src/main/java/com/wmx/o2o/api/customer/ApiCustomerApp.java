package com.wmx.o2o.api.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 客户端 - 系统
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling
@EnableFeignClients(basePackages = {
        "com.wmx.o2o.api.customer",
        "com.wmx.o2o.provider.user.client"})
public class ApiCustomerApp {
    public static void main(String[] args) {
        SpringApplication.run(ApiCustomerApp.class, args);
    }
}

