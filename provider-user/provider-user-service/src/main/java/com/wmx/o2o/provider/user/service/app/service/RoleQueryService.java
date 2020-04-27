package com.wmx.o2o.provider.user.service.app.service;

import com.wmx.o2o.provider.user.service.domain.role.Role;
import com.wmx.o2o.provider.user.service.domain.role.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleQueryService {

    private RoleRepository roleRepository;

    public RoleQueryService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getRole(String id) {
        return roleRepository.findById(id).orElse(null);
    }
}
