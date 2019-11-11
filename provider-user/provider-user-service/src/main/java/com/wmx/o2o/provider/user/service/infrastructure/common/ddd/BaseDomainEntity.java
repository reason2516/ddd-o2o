package com.wmx.o2o.provider.user.service.infrastructure.common.ddd;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import java.util.Date;

public abstract class BaseDomainEntity {
    // 创建时间
    @CreatedDate
    @Column(name = "create_time")
    private Date createTime;

    // 更新时间
    @LastModifiedDate
    @Column(name = "update_time")
    private Date updateTime;
}
