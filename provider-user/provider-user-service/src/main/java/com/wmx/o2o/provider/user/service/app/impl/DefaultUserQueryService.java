package com.wmx.o2o.provider.user.service.app.impl;

import com.wmx.o2o.provider.user.client.beans.qo.ListUsersQO;
import com.wmx.o2o.provider.user.service.app.UserQueryService;
import com.wmx.o2o.provider.user.service.domain.user.User;
import com.wmx.o2o.provider.user.service.domain.user.UserId;
import com.wmx.o2o.provider.user.service.infrastructure.repository.UserRepositoryJpa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultUserQueryService implements UserQueryService {

    private final UserRepositoryJpa repositoryJpa;

    public DefaultUserQueryService(UserRepositoryJpa repositoryJpa) {
        this.repositoryJpa = repositoryJpa;
    }

    @Override
    public User getUser(String id) {
        return repositoryJpa.findById(new UserId(id)).orElse(null);
    }

    @Override
    public List<User> listUsers(ListUsersQO qo) {
        return repositoryJpa.findAll();
    }
}
