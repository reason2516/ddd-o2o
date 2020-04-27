package com.wmx.o2o.gateway.customer.config.xservice.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthConfiguration {

    @Bean
    public FeignInterceptor authFeignInterceptor(AuthTokenRegister authTokenRegister) {
        return new FeignInterceptor(authTokenRegister);
    }
}
