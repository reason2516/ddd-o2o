package com.wmx.o2o.common.converters.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdScalarSerializer;

import java.io.IOException;

/**
 * 枚举类解析
 */
@SuppressWarnings("all")
public class EnumSerializer extends StdScalarSerializer<Enum> {


    private static final long serialVersionUID = -1619265164997062015L;

    public EnumSerializer(Class<Enum> t) {
        super(t);
    }

    protected EnumSerializer(Class<?> t, boolean dummy) {
        super(t, dummy);
    }

    @Override
    public void serialize(Enum value, JsonGenerator gen, SerializerProvider provider) throws IOException {

        gen.writeString(value.name().toLowerCase());
    }
}
