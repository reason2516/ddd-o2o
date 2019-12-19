package com.wmx.o2o.provider.user.service.domain.user;

import com.wmx.o2o.provider.user.service.infrastructure.common.BaseRepository;

import java.util.Optional;

public interface UserRepository extends BaseRepository<UserId> {

    boolean existsByPhoneNumber(String PhoneNumber);

    User save(User user);

    Optional<User> findByPhoneNumber(String phoneNumber);

    Optional<User> findById(String id);

}
