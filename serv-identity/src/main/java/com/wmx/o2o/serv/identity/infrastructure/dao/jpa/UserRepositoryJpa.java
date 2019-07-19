package com.wmx.o2o.serv.identity.infrastructure.dao.jpa;

import com.wmx.o2o.serv.identity.infrastructure.dao.entity.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJpa extends JpaRepository<UserDO, Long> {
    UserDO findByPhonenumber(String phonenumer);
}
