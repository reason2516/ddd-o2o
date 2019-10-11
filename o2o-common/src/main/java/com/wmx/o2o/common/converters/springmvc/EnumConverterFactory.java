package com.wmx.o2o.common.converters.springmvc;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

public class EnumConverterFactory implements ConverterFactory<String, Enum> {
  @Override
  public <T extends Enum> Converter<String, T> getConverter(Class<T> targetType) {
    return new StringToEnum<>(targetType);
  }

  @SuppressWarnings("all")
  private class StringToEnum<T extends Enum> implements Converter<String, T> {
    private Class<T> targetType;

    public StringToEnum(Class<T> targetType) {
      this.targetType = targetType;
    }

    @Override
    public T convert(String s) {

      return getEnum(s);
    }

    public <T extends Enum> T getEnum(String s) {
      if (s == null) {
        return null;
      }
      T[] enumConstants = (T[]) this.targetType.getEnumConstants();
      for (T enumConstant : enumConstants) {
        if (enumConstant.name().equals(s.toUpperCase())) {
          return enumConstant;
        }
      }

      return null;
    }

  }
}
