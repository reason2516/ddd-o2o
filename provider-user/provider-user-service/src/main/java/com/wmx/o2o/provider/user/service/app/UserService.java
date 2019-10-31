package com.wmx.o2o.provider.user.service.app;

import com.wmx.o2o.provider.user.client.dto.command.UserRegisterCommand;
import com.wmx.o2o.provider.user.service.domain.user.User;

public interface UserService {
    User register(UserRegisterCommand command);
}
