package com.wmx.o2o.gateway.customer.config.xservice.auth;

import com.wmx.o2o.gateway.customer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AuthTokenRegister {
    /**
     * 服务发现 client
     */
    private DiscoveryClient discoveryClient;

    private UserService userService;

    public static final String AUTH_SERVICE_ID = "xsh.service.auth";

    /**
     * token缓存 serviceId->token
     */
    private Map<String, String> cacheTokenMap = new HashMap<>();


    public String token(String serviceId) {

        if(serviceId.equals(AUTH_SERVICE_ID)){
            return null;
        }

        if (!discoveryClient.getServices().contains(serviceId)) {
            return null;
        }

        String token = cacheTokenMap.get(serviceId);
        if (token != null) {
            if (!valid(token)) {
                token = registerToken(serviceId);
            }
            return token;
        }
        return registerToken(serviceId);
    }

    private synchronized String registerToken(String serviceId) {
        // double check
        String currentToken = cacheTokenMap.get(serviceId);

        if (currentToken != null && valid(currentToken)) {
            return currentToken;
        }
        // TODO 调用鉴权服务 获取 token
        String token = "123";

        cacheTokenMap.put(serviceId, token);
        return token;
    }

    private boolean valid(String token) {
        // TODO 验证有效应该加一个 提前量 以保证请求到目标服务时也是有效的
        return true;
    }

    @Autowired
    public void setDiscoveryClient(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
