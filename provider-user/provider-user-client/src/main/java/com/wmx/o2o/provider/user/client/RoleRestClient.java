package com.wmx.o2o.provider.user.client;

import com.wmx.o2o.provider.user.client.dto.cmd.RoleCreateCO;
import com.wmx.o2o.provider.user.client.dto.vo.RoleVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.wmx.o2o.common.service.ServiceNameConst.PROVIDER_USER_SERVICE;

@FeignClient(name = PROVIDER_USER_SERVICE, contextId = PROVIDER_USER_SERVICE + ".role", path = "/role")
public interface RoleRestClient {

    @PostMapping("/")
    RoleVO create(@RequestBody RoleCreateCO co);

    @GetMapping("/{id}")
    RoleVO getRole(@PathVariable("id") String id);
}
