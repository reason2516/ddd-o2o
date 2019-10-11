package com.wmx.o2o.api.customer.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.wmx.o2o.common.converters.jackson.EnumDeserializer;
import com.wmx.o2o.common.converters.jackson.EnumSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * https://doc.yonyoucloud.com/doc/Spring-Boot-Reference-Guide/IX.%20%E2%80%98How-to%E2%80%99%20guides/65.3.%20Customize%20the%20Jackson%20ObjectMapper.html
     * @return
     */
    @Bean
    public SimpleModule enumModule() {
        SimpleModule module = new SimpleModule();
        module.setDeserializerModifier(new EnumDeserializer());
        module.addSerializer(new EnumSerializer(Enum.class));
        return module;
    }

//    @Bean
//    @Primary
//    public ObjectMapper objectMapper(@Autowired SimpleModule enumModule){
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.registerModule(enumModule);
//        return objectMapper;
//    }


}
