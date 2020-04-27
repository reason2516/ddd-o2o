package com.wmx.o2o.provider.user.service.app;

import com.wmx.o2o.provider.user.client.dto.cmd.UserRegisterCO;
import com.wmx.o2o.provider.user.service.app.service.UserService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    @Ignore
    public void register() {
        UserRegisterCO command = new UserRegisterCO();
        command.setPassword("123456");
        command.setPhoneNumber("18801230124");
        userService.register(command.getPhoneNumber(), command.getPassword());
    }
}
