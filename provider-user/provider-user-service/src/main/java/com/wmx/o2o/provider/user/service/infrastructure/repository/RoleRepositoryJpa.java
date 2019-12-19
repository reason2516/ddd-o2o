package com.wmx.o2o.provider.user.service.infrastructure.repository;

import com.wmx.o2o.provider.user.service.domain.role.Role;
import com.wmx.o2o.provider.user.service.domain.role.RoleId;
import com.wmx.o2o.provider.user.service.domain.role.RoleRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Random;

@Repository
public interface RoleRepositoryJpa extends RoleRepository, JpaRepository<Role, String> {

    String RID = "RID";

    @Override
    default RoleId nextId() {
        return new RoleId(RID + System.currentTimeMillis() + (10000 + new Random().nextInt(100000)));
    }

    @Override
    Role save(Role role);

    @SuppressWarnings("NullableProblems")
    @Override
    Optional<Role> findById(String id);

}
