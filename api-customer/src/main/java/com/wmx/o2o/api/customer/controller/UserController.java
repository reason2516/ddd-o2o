package com.wmx.o2o.api.customer.controller;

import com.wmx.o2o.api.customer.common.enums.UserStatus;
import com.wmx.o2o.api.customer.service.Identity.IdentityUserService;
import com.wmx.o2o.api.customer.service.Identity.dto.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IdentityUserService identityUserService;
    @Value("${test.value}")
    private String value;
    @Value("${test.value02}")
    private String value02;

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
        userDO.setStatus(UserStatus.NORMAL);
        return userDO;
    }

    @RequestMapping("/test02")
    public UserDO test02(UserDO userDO, HttpServletRequest request) {
        return userDO;
    }

    @RequestMapping("/testValue")
    public Map testValue() {
        HashMap<String, String> map = new HashMap<>();
        map.put("value", value);
        map.put("value02", value02);
        return map;
    }

    @PostMapping("/register")
    public void register(@RequestBody UserDO userDO) {
        System.out.println(userDO);
//        UserDO userDO = new UserDO();
//        userDO.setUsername("wmx02");
//        userDO.setPhonenumber("18801010101");
//        userDO.setPassword("123123");
//        userDO.setSalt("111223");
//        userDO.setRegisterTime(new Date());
//        this.identityUserService.add(userDO);
    }
}
