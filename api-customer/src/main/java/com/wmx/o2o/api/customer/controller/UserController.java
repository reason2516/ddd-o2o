package com.wmx.o2o.api.customer.controller;

import com.wmx.o2o.provider.user.client.UserRestClient;
import com.wmx.o2o.provider.user.client.dto.cmd.UserRegisterCO;
import com.wmx.o2o.provider.user.client.dto.vo.UserRegisterVO;
import com.wmx.o2o.provider.user.client.dto.vo.UserVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    private final UserRestClient userRestClient;

    public UserController(UserRestClient userRestClient) {
        this.userRestClient = userRestClient;
    }


    @GetMapping("/{id}")
    public UserVO get(@PathVariable String id) {
        return userRestClient.getUser(id);
    }

    @PostMapping
    public UserRegisterVO register(@Validated @RequestBody UserRegisterCO co) {
        return userRestClient.register(co);
    }
}
