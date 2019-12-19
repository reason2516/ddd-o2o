package com.wmx.o2o.provider.user.service.app.impl;

import com.wmx.o2o.provider.user.client.pojos.command.UserRegisterCommand;
import com.wmx.o2o.provider.user.service.app.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DefaultUserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void register() {
        UserRegisterCommand command = new UserRegisterCommand();
        command.setPassword("123456");
        command.setPhoneNumber("18801233210");
        userService.register(command);
    }
}