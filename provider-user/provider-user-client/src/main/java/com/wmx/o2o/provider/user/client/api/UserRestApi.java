package com.wmx.o2o.provider.user.client.api;

import com.wmx.o2o.provider.user.client.beans.command.UserRegisterCommand;
import com.wmx.o2o.provider.user.client.beans.dto.UserDTO;
import com.wmx.o2o.provider.user.client.beans.dto.UserRegisterDTO;
import com.wmx.o2o.provider.user.client.beans.qo.ListUsersQO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("provider-user-service")
public interface UserRestApi {

    @RequestMapping(value = "/user/getUser", method = RequestMethod.GET)
    UserDTO getUser(@RequestParam("id") String id);

    @RequestMapping(value = "/user/listUsers", method = RequestMethod.GET)
    List<UserDTO> listUsers(@RequestParam ListUsersQO qo);

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    UserRegisterDTO register(UserRegisterCommand command);
}
