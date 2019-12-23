package com.wmx.o2o.provider.user.service.handlers.controller;

import com.wmx.o2o.provider.user.client.beans.command.RoleCreateCommand;
import com.wmx.o2o.provider.user.service.app.RoleService;
import com.wmx.o2o.provider.user.service.domain.role.Role;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("")
    public Role create(@Validated @RequestBody RoleCreateCommand command) {
        return roleService.create(command);
    }
}
