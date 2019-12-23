package com.wmx.o2o.provider.user.service.domain.role;


import com.wmx.o2o.provider.user.service.domain.user.User;
import com.wmx.o2o.provider.user.service.infrastructure.common.ddd.BaseDomainEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
// jpa
@Entity
@DynamicInsert
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
@Table(name = "role")
public class Role extends BaseDomainEntity {

    private static final long serialVersionUID = 333045563728675700L;

    @EmbeddedId
    private RoleId id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "user_role", inverseJoinColumns = @JoinColumn(name = "role_id"), joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    @LazyCollection(LazyCollectionOption.TRUE)
    private List<User> users;

    // 创建时间
    @CreatedDate
    @Column(name = "create_time")
    protected Date createTime;

    // 更新时间
    @LastModifiedDate
    @Column(name = "update_time")
    protected Date updateTime;

    public void create(RoleId id, String name) {
        this.id = id;
        this.name = name;
    }
}
