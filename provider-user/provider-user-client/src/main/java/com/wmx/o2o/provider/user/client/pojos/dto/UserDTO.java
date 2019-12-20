package com.wmx.o2o.provider.user.client.pojos.dto;

import com.wmx.o2o.provider.user.common.enums.UserStatus;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

@Getter
@Setter
@Accessors(chain = true)
public class UserDTO {

    private String id;

    private String phoneNumber;

    private String username;

    private String email;

    private UserStatus status;

    private Date registerTime;

    private Date lastLoginTime;

    private Date createTime;

    private Date updateTime;

    private UserDTO desc;
}
