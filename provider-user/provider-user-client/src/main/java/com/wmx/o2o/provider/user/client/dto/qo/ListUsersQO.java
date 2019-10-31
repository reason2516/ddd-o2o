package com.wmx.o2o.provider.user.client.dto.qo;

import com.wmx.o2o.common.pojos.BaseQO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class ListUsersQO extends BaseQO {
    private String phoneNumber;
}
