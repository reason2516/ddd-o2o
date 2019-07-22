package com.wmx.o2o.api.customer.controller;

import com.wmx.o2o.api.customer.service.Identity.IdentityUserService;
import com.wmx.o2o.api.customer.service.Identity.dto.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class User {

    @Autowired
    private IdentityUserService identityUserService;

    @RequestMapping("/info")
    public UserDO info(@RequestParam Long id) {
        return this.identityUserService.get(id);
    }
}
