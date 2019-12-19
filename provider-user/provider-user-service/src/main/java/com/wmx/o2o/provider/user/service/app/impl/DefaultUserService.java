package com.wmx.o2o.provider.user.service.app.impl;

import com.wmx.o2o.provider.user.client.pojos.command.UserLoginCommand;
import com.wmx.o2o.provider.user.client.pojos.command.UserRegisterCommand;
import com.wmx.o2o.provider.user.service.app.UserService;
import com.wmx.o2o.provider.user.service.domain.user.User;
import com.wmx.o2o.provider.user.service.domain.user.UserRegisterDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultUserService implements UserService {

    @Autowired
    private UserRegisterDomainService userRegisterDomainService;

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
