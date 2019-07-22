package com.wmx.o2o.serv.identity.resource.controller;

import com.wmx.o2o.serv.identity.infrastructure.dao.entity.UserDO;
import com.wmx.o2o.serv.identity.infrastructure.dao.jpa.UserRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/get")
    public UserDO get(@RequestParam Long id) {
        return this.userRepositoryJpa.findById(id).orElse(null);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
    @RequestMapping(value = "/add")
    public void add( @RequestBody UserDO userDO) {
//        userDO = new UserDO();
//        userDO.setUsername("wmx02");
//        userDO.setPhonenumber("18801010101");
//        userDO.setPassword("123123");
//        userDO.setSalt("111223");
//        userDO.setRegisterTime(new Date());
        UserDO save = this.userRepositoryJpa.save(userDO);
    }
}
