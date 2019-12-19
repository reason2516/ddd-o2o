package com.wmx.o2o.provider.user.service.domain.role;

import com.wmx.o2o.provider.user.service.infrastructure.common.BaseRepository;

import java.util.Optional;

public interface RoleRepository extends BaseRepository<RoleId> {

    Role save(Role role);

    Optional<Role> findById(String id);
}
