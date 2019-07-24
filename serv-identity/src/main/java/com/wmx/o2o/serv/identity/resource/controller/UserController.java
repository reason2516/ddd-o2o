package com.wmx.o2o.serv.identity.resource.controller;

import com.wmx.o2o.serv.identity.infrastructure.dao.entity.UserDO;
import com.wmx.o2o.serv.identity.infrastructure.dao.jpa.UserRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private UserRepositoryJpa userRepositoryJpa;

    @Autowired
    private Environment environment;

    @RequestMapping(value = "/get")
    public UserDO get(@RequestParam Long id) {
        UserDO userDO = this.userRepositoryJpa.findById(id).orElse(null);
        userDO.setUsername(userDO.getUsername() + environment.getProperty("server.port"));
        return userDO;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
    @RequestMapping(value = "/add")
    public void add(@RequestBody UserDO userDO) {
//        userDO = new UserDO();
//        userDO.setUsername("wmx02");
//        userDO.setPhonenumber("18801010101");
//        userDO.setPassword("123123");
//        userDO.setSalt("111223");
//        userDO.setRegisterTime(new Date());
        UserDO save = this.userRepositoryJpa.save(userDO);
    }
}
