package com.wmx.o2o.provider.user.service.facde.rest;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wmx.o2o.provider.user.client.dto.cmd.UserRegisterCO;
import com.wmx.o2o.provider.user.client.dto.qo.ListUsersQO;
import com.wmx.o2o.provider.user.client.dto.vo.UserRegisterVO;
import com.wmx.o2o.provider.user.client.dto.vo.UserVO;
import com.wmx.o2o.provider.user.service.app.service.UserQueryService;
import com.wmx.o2o.provider.user.service.app.service.UserService;
import com.wmx.o2o.provider.user.service.domain.user.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
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

//    @GetMapping("/sessionTest")
//    public String testSession(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        boolean aNew = session.isNew();
//        log.info("now session exist status is :{}", aNew);
//        String id = session.getId();
//        log.info("now session Id is :{}", id);
//        session.setAttribute("test", "test");
//        log.info("now after set attribute session Id is :{}", session.getId());
//        return "session.getId()";
//    }

    @GetMapping("/{id}")
    public UserVO getUser(@NotNull(message = "用户id 不能为空") @PathVariable("id") String id) {
        UserVO userVO = new UserVO();
        return Optional.ofNullable(userQueryService.getUser(id))
                .map(e -> {
                    BeanUtils.copyProperties(e, userVO);
                    userVO.setId(e.getId().getId());
                    return userVO;
                })
                .orElse(null);
    }

    @GetMapping("")
    public List<UserVO> listUsers(@Validated @RequestBody ListUsersQO qo) {

        List<User> users = userQueryService.listUsers(qo);
        List<UserVO> userVOS = new ArrayList<>();

        for (User user : users) {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(user, userVO);
            userVOS.add(userVO);
        }
        return userVOS;
    }

//    @GetMapping("/listDsl")
//    public List<UserVO> listByQueryDsl(@Validated @RequestBody ListUsersQO qo) {
//        QUser user = QUser.user;
//
//        QBean<UserVO> fields = Projections.fields(
//                UserVO.class,
//                user.id,
//                user.phoneNumber,
//                user.username
//        );
//
//        JPAQuery<UserVO> query = jpaQueryFactory.select(fields).from(user);
//        Optional.ofNullable(qo.getPhoneNumber()).ifPresent(e -> query.where(user.phoneNumber.in(e)));
//        Optional.ofNullable(qo.getUsername()).ifPresent(e -> query.where(user.username.eq(e)));
//
//        return query.fetch();
//    }

    @PostMapping("")
    public UserRegisterVO register(@Validated @RequestBody UserRegisterCO co) {
        UserRegisterVO userRegisterVO = new UserRegisterVO();
        User user = userService.register(co.getPhoneNumber(), co.getPassword());
        BeanUtils.copyProperties(user, userRegisterVO);
        userRegisterVO.setId(user.getId().getId());
        return userRegisterVO;
    }

    @Autowired
    public void setJpaQueryFactory(EntityManager entityManager) {
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }
}
