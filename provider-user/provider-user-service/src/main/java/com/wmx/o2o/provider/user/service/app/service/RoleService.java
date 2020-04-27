package com.wmx.o2o.provider.user.service.app.service;

import com.wmx.o2o.provider.user.service.domain.role.Role;
import com.wmx.o2o.provider.user.service.domain.role.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional
    public Role create(String name) {
        Role role = new Role();
        role.create(roleRepository.nextId(), name);
        roleRepository.save(role);
        return role;
    }
}
