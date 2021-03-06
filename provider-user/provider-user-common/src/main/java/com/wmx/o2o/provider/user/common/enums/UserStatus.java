package com.wmx.o2o.provider.user.common.enums;

import com.wmx.o2o.common.enums.BizField;

/**
 * 用户状态
 */
public enum UserStatus implements BizField<Integer> {

    NORMAL(1, "正常"),
    DELETE(11, "删除"),
    ;

    private int code;
    private String description;

    UserStatus(Integer code, String description) {
        this.code = code;
        this.description = description;
    }


    @Override
    public Integer getCode() {
        return code;
    }


    @Override
    public String getDescription() {
        return description;
    }
}
