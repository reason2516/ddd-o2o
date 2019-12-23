package com.wmx.o2o.provider.user.service.app;

import com.wmx.o2o.provider.user.client.beans.command.UserLoginCommand;
import com.wmx.o2o.provider.user.client.beans.command.UserRegisterCommand;
import com.wmx.o2o.provider.user.service.domain.user.User;

public interface UserService {

    User register(UserRegisterCommand command);

    User login(UserLoginCommand command);
}
