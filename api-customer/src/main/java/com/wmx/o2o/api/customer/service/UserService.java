package com.wmx.o2o.api.customer.service;

import com.wmx.o2o.provider.user.client.api.UserRestApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("provider-user-service")
public interface UserService extends UserRestApi {

}
