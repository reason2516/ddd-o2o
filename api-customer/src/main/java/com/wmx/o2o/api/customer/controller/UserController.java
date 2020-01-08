package com.wmx.o2o.api.customer.controller;

import com.wmx.o2o.api.customer.service.UserService;
import com.wmx.o2o.provider.user.client.beans.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/{id}")
    public UserDTO get(@PathVariable String id) {
        return userService.getUser(id);
    }
}
