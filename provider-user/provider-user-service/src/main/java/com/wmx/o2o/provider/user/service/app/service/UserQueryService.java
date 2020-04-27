package com.wmx.o2o.provider.user.service.app.service;

import com.wmx.o2o.provider.user.client.dto.qo.ListUsersQO;
import com.wmx.o2o.provider.user.service.domain.user.User;
import com.wmx.o2o.provider.user.service.domain.user.UserId;
import com.wmx.o2o.provider.user.service.infrastructure.repository.UserRepositoryJpa;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserQueryService {

    private final UserRepositoryJpa repositoryJpa;

    public UserQueryService(UserRepositoryJpa repositoryJpa) {
        this.repositoryJpa = repositoryJpa;
    }

    public User getUser(String id) {
        return repositoryJpa.findById(new UserId(id)).orElse(null);
    }

    public List<User> listUsers(ListUsersQO qo) {
        return repositoryJpa.findAll();
    }

    public void search(ListUsersQO qo) {
        repositoryJpa.findAll((Specification<User>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (qo.getUserId() != null) {
                // 第一个id User.id 第二个id User.id.id
                predicates.add(criteriaBuilder.equal(root.get("id").get("id"), qo.getUserId()));
            }

            if (qo.getUsername() != null) {
                predicates.add(criteriaBuilder.equal(root.get("username"), qo.getUsername()));
            }

            if (qo.getPhoneNumber() != null) {
                predicates.add(criteriaBuilder.equal(root.get("phonenumber"), qo.getPhoneNumber()));
            }

//            criteriaBuilder.

            return criteriaQuery.where(predicates.toArray(new Predicate[0])).getRestriction();
        });
    }
}
