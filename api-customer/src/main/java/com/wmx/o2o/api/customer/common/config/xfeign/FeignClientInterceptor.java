package com.wmx.o2o.api.customer.common.config.xfeign;

import feign.Request;
import feign.Response;

public interface FeignClientInterceptor {
    void preExecute(Request request, Request.Options options);

    void afterExecute(Response response);
}
