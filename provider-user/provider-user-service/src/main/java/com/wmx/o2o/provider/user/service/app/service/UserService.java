package com.wmx.o2o.provider.user.service.app.service;

import com.wmx.o2o.provider.user.client.dto.cmd.UserLoginCO;
import com.wmx.o2o.provider.user.service.domain.user.User;
import com.wmx.o2o.provider.user.service.domain.user.UserRegisterDomainService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRegisterDomainService userRegisterDomainService;

    public UserService(UserRegisterDomainService userRegisterDomainService) {
        this.userRegisterDomainService = userRegisterDomainService;
    }

    @Transactional
    public User register(String phoneNumber, String password) {
        return userRegisterDomainService.doRegister(phoneNumber, password);
    }

    public User login(UserLoginCO command) {
        return null;
    }
}
