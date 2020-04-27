package com.wmx.o2o.provider.user.service.facde.rest;

import com.wmx.o2o.provider.user.client.dto.cmd.RoleCreateCO;
import com.wmx.o2o.provider.user.client.dto.vo.RoleVO;
import com.wmx.o2o.provider.user.service.app.service.RoleQueryService;
import com.wmx.o2o.provider.user.service.app.service.RoleService;
import com.wmx.o2o.provider.user.service.domain.role.Role;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/role")
public class RoleController {

    private RoleService roleService;
    private RoleQueryService roleQueryService;

    public RoleController(RoleService roleService,RoleQueryService roleQueryService) {
        this.roleService = roleService;
        this.roleQueryService = roleQueryService;
    }

    @GetMapping("/{id}")
    public RoleVO getById(@PathVariable String id) {
        RoleVO roleVO = new RoleVO();
        return Optional.ofNullable(roleQueryService.getRole(id)).map(e->{
            BeanUtils.copyProperties(e,roleVO);
            return roleVO;
        }).orElse(null);
    }

    @PostMapping("")
    public Role create(@Validated @RequestBody RoleCreateCO co) {
        return roleService.create(co.getName());
    }


}
