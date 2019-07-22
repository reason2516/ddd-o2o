package com.wmx.o2o.serv.identity.infrastructure.common.advcice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Field;
import java.util.Date;

@RestControllerAdvice
public class DateResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if(o == null){
            return null;
        }
        Field[] declaredFields = o.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            DefaultDateToNull annotation = field.getAnnotation(DefaultDateToNull.class);
            if (annotation != null) {
                try {
                    Object val = field.get(o);
                    if (val instanceof Date) {
                        if (((Date) val).getTime() == 0L) {
                            field.set(o, null);
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return o;
    }
}
