package com.wmx.o2o.gateway.customer.service;

import com.wmx.o2o.provider.user.client.UserRestClient;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("provider-user-service")
public interface UserService extends UserRestClient {

}
