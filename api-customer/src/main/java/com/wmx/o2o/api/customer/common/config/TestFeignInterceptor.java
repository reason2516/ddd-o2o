package com.wmx.o2o.api.customer.common.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.Target;
import org.springframework.stereotype.Component;

@Component
public class TestFeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        Target<?> target = template.feignTarget();
        String url = template.url();
    }
}
