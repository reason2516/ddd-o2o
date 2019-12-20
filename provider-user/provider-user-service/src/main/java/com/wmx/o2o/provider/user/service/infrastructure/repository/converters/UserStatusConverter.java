package com.wmx.o2o.provider.user.service.infrastructure.repository.converters;

import com.wmx.o2o.provider.user.common.enums.UserStatus;

import javax.persistence.AttributeConverter;

public class UserStatusConverter implements AttributeConverter<UserStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(UserStatus attribute) {
        if (attribute == null) {
            return 0;
        }
        return attribute.getCode();
    }

    @Override
    public UserStatus convertToEntityAttribute(Integer dbData) {
        if (dbData == null || dbData == 0) {
            return null;
        }

        UserStatus[] values = UserStatus.values();
        for (UserStatus value : values) {
            if (value.getCode().equals(dbData)) {
                return value;
            }
        }

        throw new IllegalArgumentException("枚举类型转换异常");
    }
}
