package com.wmx.o2o.provider.user.client.dto.cmd;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Accessors(chain = true)
public class RoleCreateCO {
    @NotBlank(message = "角色名称 不能为空")
    private String name;
}
