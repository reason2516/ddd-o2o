package com.wmx.o2o.provider.user.service.domain.user;


import com.wmx.o2o.provider.user.common.enums.UserStatus;
import com.wmx.o2o.provider.user.service.infrastructure.common.ddd.BaseDomainEntity;
import com.wmx.o2o.provider.user.service.infrastructure.repository.converters.UserStatusConverter;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PROTECTED)
@Accessors(chain = true)
// jpa
@Entity
@DynamicInsert
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user")
public class User extends BaseDomainEntity {

    @EmbeddedId
    private UserId id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "salt")
    private String salt;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "status")
    @Convert(converter = UserStatusConverter.class)
    private UserStatus status;

    @Column(name = "register_time")
    private Date registerTime;

    @Column(name = "last_login_time")
    private Date lastLoginTime;

    @LastModifiedDate
    @Column(name = "update_time")
    private Date updateTime;

    @CreatedDate
    @Column(name = "create_time")
    private Date createTime;


    /**
     * 注册
     *
     * @param phoneNumber
     * @param password
     */
    public void registerByPhoneNumber(UserId id, String phoneNumber, String password) {

        setId(id);
        setPhoneNumber(phoneNumber);
        setPassword(password);
        setRegisterTime(new Date());
    }
}
