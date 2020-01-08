package com.wmx.o2o.provider.user.service.domain.user;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Ignore
    public void saveTest() {
        User user = new User();
        user.registerByPhoneNumber(userRepository.nextId(), "18801010111", "123");
        userRepository.save(user);
    }
}