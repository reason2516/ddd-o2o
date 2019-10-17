package com.wmx.o2o.api.customer.common.config.web;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.wmx.o2o.common.converters.jackson.EnumDeserializer;
import com.wmx.o2o.common.converters.jackson.EnumSerializer;
import com.wmx.o2o.common.converters.springmvc.DateConverterFactory;
import com.wmx.o2o.common.converters.springmvc.EnumConverterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 声明 module类型的bean spring会自动装配到objectMapper中
     * 如需手动配置 objectMapper如下：
     *  ObjectMapper objectMapper = new ObjectMapper();
     *  objectMapper.registerModule(enumModule);
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

    /**
     * 自定义 formatters
     * objectMapper 只会处理 postJson数据转换
     * 如果期望普通的post或get请求绑定参数时也自动转换，需要自己拓展 converter
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        // 请求 String 转 枚举
        registry.addConverterFactory(new EnumConverterFactory());
        // 用户请求 String 转 date
        registry.addConverterFactory(new DateConverterFactory());
    }
}
