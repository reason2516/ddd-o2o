package com.wmx.o2o.serv.identity.infrastructure.dao.entity;
import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@DynamicInsert
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user")
public class UserDO implements Serializable{

  private static final long serialVersionUID = 1016358663479619840L;

    // 自增id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // 手机号码
    @Column(name = "phonenumber")
    private String phonenumber;

    // 用户名
    @Column(name = "username")
    private String username;

    // 密码
    @Column(name = "password")
    private String password;

    // 密码盐值
    @Column(name = "salt")
    private String salt;

    // 注册时间
    @Column(name = "register_time")
    private Date registerTime;

    // 更新时间
    @LastModifiedDate
    @Column(name = "update_time")
    private Date updateTime;

    // 创建时间
    @CreatedDate
    @Column(name = "create_time")
    private Date createTime;

    // 测试时间格式-专属字段
    @Column(name = "test_time")
    private Long testTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }


    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }


    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public Long getTestTime() {
        return testTime;
    }

    public void setTestTime(Long testTime) {
        this.testTime = testTime;
    }

}
