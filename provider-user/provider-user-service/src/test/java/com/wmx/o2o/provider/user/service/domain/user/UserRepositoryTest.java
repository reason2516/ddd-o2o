package com.wmx.o2o.provider.user.service.domain.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void saveTest() {
        User user = new User();
        user.registerByPhoneNumber(userRepository.nextId(), "18801010333", "123");
        userRepository.save(user);
    }

    @Test
    public void saveJdbcTest() {
        jdbcTemplate.update("INSERT INTO `user` " +
                "(`id`, `register_time`) " +
                "VALUES " +
                "(?,?);", 1, new Date());
    }
}