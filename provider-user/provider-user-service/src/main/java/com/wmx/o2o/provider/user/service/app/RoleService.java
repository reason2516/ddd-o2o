package com.wmx.o2o.provider.user.service.app;

import com.wmx.o2o.provider.user.client.pojos.command.RoleCreateCommand;
import com.wmx.o2o.provider.user.service.domain.role.Role;

public interface RoleService {

    Role create(RoleCreateCommand command);
}
