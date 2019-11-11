package com.wmx.o2o.provider.user.service.infrastructure.repository.converters;

import com.wmx.o2o.common.enums.BaseBizFieldEnum;
import com.wmx.o2o.provider.user.common.enums.UserStatusEnum;

import javax.persistence.AttributeConverter;

public class UserStatusConverter implements AttributeConverter<UserStatusEnum, Integer> {
    @Override
    public Integer convertToDatabaseColumn(UserStatusEnum attribute) {
        if (attribute == null) {
            return 0;
        }
        return attribute.getCode();
    }

    @Override
    public UserStatusEnum convertToEntityAttribute(Integer dbData) {
        if (dbData == null || dbData == 0) {
            return null;
        }

        UserStatusEnum[] values = UserStatusEnum.values();
        for (UserStatusEnum value : values) {
            if (value.getCode().equals(dbData)) {
                return value;
            }
        }

        throw new IllegalArgumentException("枚举类型转换异常");
    }
}
