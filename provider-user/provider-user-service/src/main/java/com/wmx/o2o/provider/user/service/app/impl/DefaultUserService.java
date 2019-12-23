package com.wmx.o2o.provider.user.service.app.impl;

import com.wmx.o2o.provider.user.client.beans.command.UserLoginCommand;
import com.wmx.o2o.provider.user.client.beans.command.UserRegisterCommand;
import com.wmx.o2o.provider.user.service.app.UserService;
import com.wmx.o2o.provider.user.service.domain.user.User;
import com.wmx.o2o.provider.user.service.domain.user.UserRegisterDomainService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultUserService implements UserService {

    private final UserRegisterDomainService userRegisterDomainService;

    public DefaultUserService(UserRegisterDomainService userRegisterDomainService) {
        this.userRegisterDomainService = userRegisterDomainService;
    }

    @Transactional
    @Override
    public User register(UserRegisterCommand command) {
        return userRegisterDomainService.doRegister(command);
    }

    @Override
    public User login(UserLoginCommand command) {
        return null;
    }
}
