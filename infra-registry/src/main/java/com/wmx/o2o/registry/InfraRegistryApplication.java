package com.wmx.o2o.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class InfraRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfraRegistryApplication.class, args);
	}

}
