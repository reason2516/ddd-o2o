package com.wmx.o2o.provider.user.client.beans.command;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Accessors(chain = true)
public class UserLoginCommand {

    @NotBlank(message = "手机号 不能为空")
    private String phoneNumber;

    @NotBlank(message = "密码 不能为空")
    private String password;

}