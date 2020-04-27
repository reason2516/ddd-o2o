package com.wmx.o2o.gateway.customer.config.xfeign;

import feign.Client;
import feign.Request;
import feign.Response;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.cloud.openfeign.ribbon.CachingSpringLoadBalancerFactory;
import org.springframework.cloud.openfeign.ribbon.LoadBalancerFeignClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FeignClient extends LoadBalancerFeignClient {

    private List<FeignClientInterceptor> interceptors = new ArrayList<>();

    public FeignClient(Client delegate,
                       CachingSpringLoadBalancerFactory lbClientFactory,
                       SpringClientFactory clientFactory) {
        super(delegate, lbClientFactory, clientFactory);
    }


    @Override
    public Response execute(Request request, Request.Options options) throws IOException {
        // requestTemplate.headers()方法 将header 改写为 UnmodifiableMap 所以需要 requestWrap
        Request requestWrap = Request.create(request.httpMethod(),
                request.url(),
                new HashMap<>(request.headers()),
                request.body(), request.charset(),
                request.requestTemplate());

        for (FeignClientInterceptor interceptor : interceptors) {
            interceptor.preExecute(requestWrap, options);
        }

        Response response = super.execute(requestWrap, options);

        for (FeignClientInterceptor interceptor : interceptors) {
            interceptor.afterExecute(response);
        }

        return response;
    }

    public FeignClient setInterceptors(FeignClientInterceptor interceptor) {
        interceptors.add(interceptor);
        return this;
    }

    public FeignClient setInterceptors(List<FeignClientInterceptor> interceptors) {
        this.interceptors.addAll(interceptors);
        return this;
    }
}
