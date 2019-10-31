package com.wmx.o2o.provider.user.service.handlers.controller;

import com.wmx.o2o.provider.user.client.api.UserRestApi;
import com.wmx.o2o.provider.user.client.dto.command.UserRegisterCommand;
import com.wmx.o2o.provider.user.client.dto.qo.ListUsersQO;
import com.wmx.o2o.provider.user.client.dto.response.UserDTO;
import com.wmx.o2o.provider.user.client.dto.response.UserRegisterDTO;
import com.wmx.o2o.provider.user.service.app.UserQueryService;
import com.wmx.o2o.provider.user.service.app.UserService;
import com.wmx.o2o.provider.user.service.domain.user.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(UserRestApi.USER_MAPPING_PREFIX)
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserQueryService userQueryService;


    @GetMapping(UserRestApi.GET_USER_MAPPING)
    public UserDTO getUser(@NotNull(message = "用户id 不能为空")
                           @RequestParam("id") String id) {
        User user = userQueryService.getUser(id);
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    @GetMapping(UserRestApi.LIST_USERS_MAPPING)
    public List<UserDTO> listUsers(@Validated ListUsersQO qo) {

        List<User> users = userQueryService.listUsers(qo);
        List<UserDTO> userDTOS = new ArrayList<>();

        for (User user : users) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user, userDTO);
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }

    @PostMapping(UserRestApi.REGISTER_MAPPING)
    public UserRegisterDTO register(@Validated @RequestBody UserRegisterCommand command) {
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
        User user = userService.register(command);

        BeanUtils.copyProperties(user, userRegisterDTO);
        return userRegisterDTO;
    }
}
