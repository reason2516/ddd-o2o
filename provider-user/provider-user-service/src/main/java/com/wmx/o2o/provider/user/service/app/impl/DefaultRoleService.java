package com.wmx.o2o.provider.user.service.app.impl;

import com.wmx.o2o.provider.user.client.beans.command.RoleCreateCommand;
import com.wmx.o2o.provider.user.service.app.RoleService;
import com.wmx.o2o.provider.user.service.domain.role.Role;
import com.wmx.o2o.provider.user.service.domain.role.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultRoleService implements RoleService {

    private RoleRepository roleRepository;

    public DefaultRoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional
    @Override
    public Role create(RoleCreateCommand command) {
        Role role = new Role();
        role.create(roleRepository.nextId(), command.getName());
        roleRepository.save(role);
        return role;
    }
}
