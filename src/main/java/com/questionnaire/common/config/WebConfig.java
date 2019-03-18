package com.questionnaire.common.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Package: com.questionnaire.common.config
 * @Auther: yxd
 * @Date: 2019-02-19 14:14:26
 * @Description:
 */
@Component
public class WebConfig extends WebMvcConfigurationSupport {

    /**
     * 配置静态资源 css、js、img、png
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }
}
