package com.wmx.o2o.provider.user.service.app.impl;

import com.wmx.o2o.provider.user.client.beans.qo.ListUsersQO;
import com.wmx.o2o.provider.user.service.app.UserQueryService;
import com.wmx.o2o.provider.user.service.domain.user.User;
import com.wmx.o2o.provider.user.service.infrastructure.repository.UserRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultUserQueryService implements UserQueryService {

    @Autowired
    private UserRepositoryJpa repositoryJpa;


    @Override
    public User getUser(String id) {
        return repositoryJpa.findById(id).orElse(null);
    }

    @Override
    public List<User> listUsers(ListUsersQO qo) {
        return repositoryJpa.findAll();
    }
}
