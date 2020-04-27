package com.wmx.o2o.api.customer.common.config.xservice.auth;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.Target;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.Collections;

@Component
public class FeignInterceptor implements RequestInterceptor {

    private AuthTokenRegister register;

    public FeignInterceptor(AuthTokenRegister register) {
        this.register = register;
    }

    @Override
    public void apply(RequestTemplate template) {
        String token = register.token(getHost(template.feignTarget()));
        if (token != null) {
            template.header(AuthConstant.HTTP_TOKEN_HEADER_NAME, Collections.singletonList(token));
        }
    }

    private String getHost(Target<?> target) {
        try {
            URI uri = new URI(target.url());
            return uri.getHost();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
