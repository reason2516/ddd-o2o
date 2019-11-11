package com.wmx.o2o.provider.user.service.domain.user;

import org.springframework.stereotype.Repository;


public interface UserRepository {

    String nextId();

    boolean existsByPhoneNumber(String PhoneNumber);

    User save(User user);

    User findByPhoneNumber(String phoneNumber);
}
