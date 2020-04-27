package com.wmx.o2o.gateway.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableDiscoveryClient
@Configuration
@EnableFeignClients
public class GatewayCustomerApp {

    public static void main(String[] args) {
        SpringApplication.run(GatewayCustomerApp.class, args);
    }
//
//    @Bean
//    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("api-customer", p -> p
//                        .path("/customer/**")
//                        .filters(f -> f.stripPrefix(1))
//                        .uri("lb://api-customer"))
//                .build();
//    }
}
