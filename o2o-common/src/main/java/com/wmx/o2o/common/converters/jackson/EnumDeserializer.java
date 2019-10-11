package com.wmx.o2o.common.converters.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;

import java.io.IOException;

/**
 * 枚举类逆解析
 */
public class EnumDeserializer extends BeanDeserializerModifier {
    @Override
    public JsonDeserializer<Enum> modifyEnumDeserializer(DeserializationConfig config, JavaType type, BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
        return new JsonDeserializer<Enum>() {

            @SuppressWarnings("all")
            @Override
            public Enum deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
                Class<? extends Enum> rawClass = (Class<? extends Enum>) type.getRawClass();
                Enum[] enumConstants = rawClass.getEnumConstants();
                String s = p.getValueAsString().toUpperCase();
                for (Enum enumConstant : enumConstants) {
                    if (enumConstant.name().equals(s)) {
                        return enumConstant;
                    }
                }

                return null;
            }
        };
    }
}
