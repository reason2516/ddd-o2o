package com.wmx.o2o.serv.identity.resource.controller;

import com.wmx.o2o.serv.identity.infrastructure.dao.entity.UserDO;
import com.wmx.o2o.serv.identity.infrastructure.dao.jpa.UserRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/add")
    public void add(@RequestBody UserDO userDO) {
//        UserDO userDO = new UserDO();
        userDO.setPhonenumber("18809010904");
        userDO.setPassword("123");
        userDO.setSalt("123");
//        userDO.setRegisterTime(new Date().getTime());
        Date date = new Date();
        date.setTime(0);
        UserDO save = this.userRepositoryJpa.save(userDO);
    }
}
