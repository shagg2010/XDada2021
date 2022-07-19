package com.yadas.web.rest.configuration;

import com.yadas.web.rest.interceptors.RestApplicationServiceInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class RestAppServiceInterceptorAppConfig implements WebMvcConfigurer {

    @Autowired
    RestApplicationServiceInterceptor restApplicationServiceInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(restApplicationServiceInterceptor);
    }
}
