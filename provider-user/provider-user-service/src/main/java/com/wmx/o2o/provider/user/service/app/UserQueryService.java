package com.wmx.o2o.provider.user.service.app;

import com.wmx.o2o.provider.user.client.dto.qo.ListUsersQO;
import com.wmx.o2o.provider.user.service.domain.user.User;

import java.util.List;

public interface UserQueryService {
    User getUser(String id);

    List<User> listUsers(ListUsersQO qo);
}
