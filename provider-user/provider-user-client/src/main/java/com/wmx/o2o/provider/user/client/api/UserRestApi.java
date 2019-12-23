package com.wmx.o2o.provider.user.client.api;

import com.wmx.o2o.provider.user.client.beans.dto.UserRegisterDTO;
import com.wmx.o2o.provider.user.client.beans.command.UserRegisterCommand;
import com.wmx.o2o.provider.user.client.beans.qo.ListUsersQO;
import com.wmx.o2o.provider.user.client.beans.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("provider-user-service")
public interface UserRestApi {

    String USER_MAPPING_PREFIX = "/user";

    String GET_USER_MAPPING = "/getUser";

    String LIST_USERS_MAPPING = "/listUsers";

    String REGISTER_MAPPING = "register";

    @RequestMapping(value = USER_MAPPING_PREFIX + GET_USER_MAPPING, method = RequestMethod.GET)
    UserDTO getUser(@RequestParam("id") Integer id);

    @RequestMapping(value = USER_MAPPING_PREFIX + LIST_USERS_MAPPING, method = RequestMethod.GET)
    List<UserDTO> listUsers(@RequestParam ListUsersQO qo);

    @RequestMapping(value = USER_MAPPING_PREFIX + REGISTER_MAPPING, method = RequestMethod.POST)
    UserRegisterDTO register(UserRegisterCommand command);
}
