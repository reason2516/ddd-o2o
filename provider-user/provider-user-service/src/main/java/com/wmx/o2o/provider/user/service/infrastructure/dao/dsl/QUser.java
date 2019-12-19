package com.wmx.o2o.provider.user.service.infrastructure.dao.dsl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.wmx.o2o.provider.user.service.domain.user.User;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 1814755646L;

    public static final QUser user = new QUser("user");

    public final StringPath email = createString("email");

    public final StringPath id = createString("id");

    public final DateTimePath<java.util.Date> lastLoginTime = createDateTime("lastLoginTime", java.util.Date.class);

    public final StringPath password = createString("password");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final DateTimePath<java.util.Date> registerTime = createDateTime("registerTime", java.util.Date.class);

    public final StringPath salt = createString("salt");

    public final EnumPath<com.wmx.o2o.provider.user.common.enums.UserStatusEnum> status = createEnum("status", com.wmx.o2o.provider.user.common.enums.UserStatusEnum.class);

    public final StringPath username = createString("username");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

