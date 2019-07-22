package com.wmx.o2o.api.customer.service.Identity;

import com.wmx.o2o.api.customer.service.Identity.dto.UserDO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("serv-identity")
public interface IdentityUserService {
    @RequestMapping(value = "/user/get", method = RequestMethod.GET)
    UserDO get(@RequestParam Long id);
}
