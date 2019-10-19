package com.wmx.o2o.api.customer.common.enums;

public enum UserStatus {
    NORMAL(1,"正常"),
    CANCEL(11,"注销");

    private int code;
    private String desc;

    UserStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
