package com.wmx.o2o.provider.user.service.domain.user;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
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
public class User implements Serializable {

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

    @Column(name = "register_time")
    private Date registerTime;

    @Column(name = "last_login_time")
    private Date lastLoginTime;

    // 创建时间
    @CreatedDate
    @Column(name = "create_time")
    private Date createTime;

    // 更新时间
    @LastModifiedDate
    @Column(name = "update_time")
    private Date updateTime;

    public void registerByPhoneNumber(String phoneNumber, String password) {
        setPhoneNumber(phoneNumber)
                .setPhoneNumber(password)
                .setRegisterTime(new Date());
    }
}
