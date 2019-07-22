package com.wmx.o2o.api.customer.service.Identity;

import com.wmx.o2o.api.customer.service.Identity.dto.UserDO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "serv-identity")
public interface IdentityUserService {
    @RequestMapping(value = "/user/get", method = RequestMethod.GET)
    UserDO get(@RequestParam("id") Long id);

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    void add(@RequestBody UserDO userDO);
}
