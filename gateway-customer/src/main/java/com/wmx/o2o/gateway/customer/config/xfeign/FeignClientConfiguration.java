package com.wmx.o2o.gateway.customer.config.xfeign;

import feign.Client;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.cloud.openfeign.ribbon.CachingSpringLoadBalancerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FeignClientConfiguration {


    @Bean
    @ConditionalOnClass(CachingSpringLoadBalancerFactory.class)
    public Client feignClient(CachingSpringLoadBalancerFactory cachingLBClientFactory,
                              SpringClientFactory clientFactory,
                              List<FeignClientInterceptor> interceptors) {
        return new FeignClient(
                new Client.Default(null, null),
                cachingLBClientFactory,
                clientFactory)
                .setInterceptors(interceptors);
    }

}
