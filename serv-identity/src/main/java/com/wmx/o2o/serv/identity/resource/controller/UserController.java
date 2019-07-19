package com.wmx.o2o.serv.identity.resource.controller;

import com.wmx.o2o.serv.identity.infrastructure.dao.entity.UserDO;
import com.wmx.o2o.serv.identity.infrastructure.dao.jpa.UserRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepositoryJpa userRepositoryJpa;

    @RequestMapping(value = "/get")
    public UserDO get(@RequestParam Long id) {
        return this.userRepositoryJpa.findById(id).orElse(null);
    }

    @RequestMapping(value = "/add")
    public void add() {
        UserDO userDO = new UserDO();
        userDO.setPhonenumber("18809010902");
        userDO.setPassword("123");
        userDO.setSalt("123");
        userDO.setRegisterTime(new Date().getTime());
        UserDO save = this.userRepositoryJpa.save(userDO);
    }
}
