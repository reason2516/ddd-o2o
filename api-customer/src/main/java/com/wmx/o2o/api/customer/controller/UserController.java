package com.wmx.o2o.api.customer.controller;

import com.wmx.o2o.api.customer.service.Identity.IdentityUserService;
import com.wmx.o2o.api.customer.service.Identity.dto.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IdentityUserService identityUserService;

    @RequestMapping("/info")
    public UserDO info(@RequestParam Long id) {
        return this.identityUserService.get(id);
    }

    @RequestMapping("/test")
    public UserDO test() {
        UserDO userDO = new UserDO();
        userDO.setUsername("wmx02");
        userDO.setPhonenumber("18801010101");
        userDO.setPassword("123123");
        userDO.setSalt("111223");
        userDO.setRegisterTime(new Date());
        return userDO;
    }

    @RequestMapping("/register")
    public void register() {
        UserDO userDO = new UserDO();
        userDO.setUsername("wmx02");
        userDO.setPhonenumber("18801010101");
        userDO.setPassword("123123");
        userDO.setSalt("111223");
        userDO.setRegisterTime(new Date());
        this.identityUserService.add(userDO);
    }
}
