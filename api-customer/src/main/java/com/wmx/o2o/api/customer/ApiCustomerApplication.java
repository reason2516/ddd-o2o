package com.wmx.o2o.api.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@EnableEurekaClient
@Configuration
public class ApiCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiCustomerApplication.class, args);
    }
}
