package com.wmx.o2o.gateway.customer.config.xservice.auth;

import com.wmx.o2o.gateway.customer.config.xfeign.FeignClientInterceptor;
import feign.Request;
import feign.Response;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.Collections;

@Component
public class FeignInterceptor implements FeignClientInterceptor {

    private AuthTokenRegister register;

    public FeignInterceptor(AuthTokenRegister register) {
        this.register = register;
    }

    @Override
    public void preExecute(Request request, Request.Options options) {
        String token = register.token(getHost(request));
        request.headers().put(AuthConstant.HTTP_TOKEN_HEADER_NAME, Collections.singletonList(token));
    }

    private String getHost(Request request) {
        try {
            URI uri = new URI(request.url());
            return uri.getHost();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void afterExecute(Response response) {

    }
}
