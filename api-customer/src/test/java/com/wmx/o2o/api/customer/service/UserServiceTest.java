package com.wmx.o2o.api.customer.service;

import com.wmx.o2o.provider.user.client.UserRestClient;
import com.wmx.o2o.provider.user.client.dto.cmd.UserRegisterCO;
import com.wmx.o2o.provider.user.client.dto.vo.UserVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    UserRestClient userRestClient;

    @Test
    public void testReg() {
        UserRegisterCO command = new UserRegisterCO();
        command.setPhoneNumber("18810102020");
        command.setPassword("123");
        userRestClient.register(command);
    }

    @Test
    public void getGet() {
        UserVO user = userRestClient.getUser("1");
    }
}
