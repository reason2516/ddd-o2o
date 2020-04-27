package com.wmx.o2o.provider.user.client;

import com.wmx.o2o.provider.user.client.dto.cmd.UserRegisterCO;
import com.wmx.o2o.provider.user.client.dto.qo.ListUsersQO;
import com.wmx.o2o.provider.user.client.dto.vo.UserRegisterVO;
import com.wmx.o2o.provider.user.client.dto.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.wmx.o2o.common.service.ServiceNameConst.PROVIDER_USER_SERVICE;

@FeignClient(name = PROVIDER_USER_SERVICE, contextId = PROVIDER_USER_SERVICE + ".user", path = "/user")
public interface UserRestClient {

    @GetMapping(value = "/{id}")
    UserVO getUser(@PathVariable("id") String id);

    @RequestMapping(value = "", method = RequestMethod.GET)
    List<UserVO> listUsers(@RequestParam ListUsersQO qo);

    @RequestMapping(value = "", method = RequestMethod.POST)
    UserRegisterVO register(UserRegisterCO co);
}
