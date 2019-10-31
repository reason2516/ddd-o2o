package com.wmx.o2o.provider.user.client.dto.response;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

@Getter
@Setter
@Accessors(chain = true)
public class UserRegisterDTO {

    private String Id;

    private Date registerTime;

    private Date lastLoginTime;

}
