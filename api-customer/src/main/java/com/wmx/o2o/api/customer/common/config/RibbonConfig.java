package com.wmx.o2o.api.customer.common.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonConfig implements RequestInterceptor {


    @Override
    public void apply(RequestTemplate template) {
    }
}

