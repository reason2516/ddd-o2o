package com.wmx.o2o.provider.user.service.infrastructure.repository;

import com.wmx.o2o.provider.user.service.domain.user.User;
import com.wmx.o2o.provider.user.service.domain.user.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Random;

@Repository
public interface UserRepositoryJpa extends UserRepository, JpaRepository<User, String> {
    String UID_PREFIX = "UID";

    @Override
    default String nextId() {
        return UID_PREFIX + System.currentTimeMillis() + (10000 + new Random().nextInt(100000));
    }

    @Override
    boolean existsByPhoneNumber(String phoneNumber);

    @Override
    User findByPhoneNumber(String phoneNumber);

}
