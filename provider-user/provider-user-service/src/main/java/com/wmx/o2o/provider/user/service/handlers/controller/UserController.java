package com.wmx.o2o.provider.user.service.handlers.controller;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.QBean;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wmx.o2o.provider.user.client.api.UserRestApi;
import com.wmx.o2o.provider.user.client.beans.command.UserRegisterCommand;
import com.wmx.o2o.provider.user.client.beans.qo.ListUsersQO;
import com.wmx.o2o.provider.user.client.beans.dto.UserDTO;
import com.wmx.o2o.provider.user.client.beans.dto.UserRegisterDTO;
import com.wmx.o2o.provider.user.service.app.UserQueryService;
import com.wmx.o2o.provider.user.service.app.UserService;
import com.wmx.o2o.provider.user.service.domain.user.User;
import com.wmx.o2o.provider.user.service.infrastructure.dao.dsl.QUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(UserRestApi.USER_MAPPING_PREFIX)
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserQueryService userQueryService;

    private JPAQueryFactory jpaQueryFactory;

    @GetMapping(UserRestApi.GET_USER_MAPPING)
    public UserDTO getUser(@NotNull(message = "用户id 不能为空")
                           @RequestParam("id") String id) {
        User user = userQueryService.getUser(id);
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    @GetMapping(UserRestApi.LIST_USERS_MAPPING)
    public List<UserDTO> listUsers(@Validated @RequestBody ListUsersQO qo) {

        List<User> users = userQueryService.listUsers(qo);
        List<UserDTO> userDTOS = new ArrayList<>();

        for (User user : users) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user, userDTO);
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }

    @GetMapping("/listDsl")
    public List<UserDTO> listByQueryDsl(@Validated @RequestBody ListUsersQO qo) {
        QUser user = QUser.user;

        QBean<UserDTO> fields = Projections.fields(
                UserDTO.class,
                user.id,
                user.phoneNumber,
                user.username,
                Projections.fields(UserDTO.class, user.id).as("desc")
        );

        JPAQuery<UserDTO> query = jpaQueryFactory.select(fields).from(user);
        Optional.ofNullable(qo.getPhoneNumber()).ifPresent(e -> query.where(user.phoneNumber.in(e)));
        Optional.ofNullable(qo.getUsername()).ifPresent(e -> query.where(user.username.eq(e)));

        List<UserDTO> list = query.fetch();

        return list;
    }

    @PostMapping(UserRestApi.REGISTER_MAPPING)
    public UserRegisterDTO register(@Validated @RequestBody UserRegisterCommand command) {
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
        User user = userService.register(command);

        BeanUtils.copyProperties(user, userRegisterDTO);
        return userRegisterDTO;
    }

    @Autowired
    public void setJpaQueryFactory(EntityManager entityManager) {
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }
}
