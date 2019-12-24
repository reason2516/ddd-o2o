package com.wmx.o2o.provider.user.service.handlers.controller;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.QBean;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
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
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    private final UserQueryService userQueryService;

    private JPAQueryFactory jpaQueryFactory;

    public UserController(UserService userService, UserQueryService userQueryService) {
        this.userService = userService;
        this.userQueryService = userQueryService;
    }

    @GetMapping("/getUser")
    public UserDTO getUser(@NotNull(message = "用户id 不能为空")
                           @RequestParam("id") String id) {
        User user = userQueryService.getUser(id);
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    @GetMapping("/listUsers")
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

        return query.fetch();
    }

    @PostMapping("/register")
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
