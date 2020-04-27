package com.wmx.o2o.provider.user.client.dto.cmd;


import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Accessors(chain = true)
public class UserRegisterCO {

    @NotBlank(message = "手机号 不能为空")
    private String phoneNumber;

    @NotBlank(message = "密码 不能为空")
    private String password;
}
