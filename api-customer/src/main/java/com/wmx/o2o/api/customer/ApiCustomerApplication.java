package com.wmx.o2o.api.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ApiCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiCustomerApplication.class, args);
    }
}
