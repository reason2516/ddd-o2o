package com.wmx.o2o.common.enums;

public interface BaseBizFieldEnum<T> {
    T getCode();

//    void setCode(T code);

    String getDescription();

//    void setDescription(String description);

    static BaseBizFieldEnum[] values() {
        return null;
    }
}
