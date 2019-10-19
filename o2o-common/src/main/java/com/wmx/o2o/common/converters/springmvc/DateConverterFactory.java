package com.wmx.o2o.common.converters.springmvc;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import java.lang.reflect.Constructor;
import java.util.Date;


public class DateConverterFactory implements ConverterFactory<String, Date> {


  @Override
  public <T extends Date> Converter<String, T> getConverter(Class<T> aClass) {
    return new LongToDate<>(aClass);
  }

  @SuppressWarnings("all")
  private class LongToDate<T extends Date> implements Converter<String, T> {
    private Class<T> targetType;

    public LongToDate(Class<T> targetType) {
      this.targetType = targetType;
    }

    @Override
    public T convert(String s) {
      Constructor<T> constructor = null;
      T date = null;
      try {
        constructor = targetType.getDeclaredConstructor(long.class);
        date = constructor.newInstance(Long.valueOf(s));
      } catch (Exception e) {
        e.printStackTrace();
      }
      return date;
    }
  }
}
