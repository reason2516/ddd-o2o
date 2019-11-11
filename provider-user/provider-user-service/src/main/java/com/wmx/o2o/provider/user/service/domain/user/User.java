package com.wmx.o2o.provider.user.service.domain.user;


import com.wmx.o2o.provider.user.common.enums.UserStatusEnum;
import com.wmx.o2o.provider.user.service.infrastructure.common.ddd.BaseDomainEntity;
import com.wmx.o2o.provider.user.service.infrastructure.repository.converters.UserStatusConverter;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@Accessors(chain = true)
// jpa
@Entity
@DynamicInsert
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user")
public class User extends BaseDomainEntity implements Serializable {

    private static final long serialVersionUID = -5230908019247124358L;

    @Id
    @Column(name = "id")
    private String id;

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
    private UserStatusEnum status;

    @Column(name = "register_time")
    private Date registerTime;

    @Column(name = "last_login_time")
    private Date lastLoginTime;

    /**
     * 注册
     *
     * @param phoneNumber
     * @param password
     */
    public void registerByPhoneNumber(String id, String phoneNumber, String password) {
        setId(id)
                .setPhoneNumber(phoneNumber)
                .setStatus(UserStatusEnum.NORMAL)
                .setPassword(password)
                .setRegisterTime(new Date());
    }
}
