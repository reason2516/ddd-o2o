package com.wmx.o2o.provider.user.service.app.impl;

import com.wmx.o2o.provider.user.service.app.UserQueryService;
import com.wmx.o2o.provider.user.service.domain.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultUserQueryServiceTest {
    @Autowired
    private UserQueryService userQueryService;

    @Test
    public void getUser() {
        User user = userQueryService.getUser("18810498066");
    }


    @Test
    public void listUsers() {
    }
}