package com.wmx.o2o.api.customer.service;

import com.wmx.o2o.provider.user.client.UserRestClient;

/**
 * 启动类上的 EnableFeignClients注解 需要包含 二方包 目标 Client的路径
 * 默认扫描当前项目的 client
 */
//@FeignClient("provider-user-service")
public interface UserService extends UserRestClient {

}
