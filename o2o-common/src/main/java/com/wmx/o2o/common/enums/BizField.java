package com.wmx.o2o.common.enums;

public interface BizField<T> {
    T getCode();

//    void setCode(T code);

    String getDescription();

//    void setDescription(String description);

    static BizField[] values() {
        return null;
    }
}
