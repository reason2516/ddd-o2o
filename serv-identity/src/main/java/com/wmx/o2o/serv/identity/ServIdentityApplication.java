package com.wmx.o2o.serv.identity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@Configuration
@EnableEurekaClient
@EnableJpaAuditing
public class ServIdentityApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServIdentityApplication.class, args);
    }

}
