package com.springbootessentials.springbootessentials.common.config;

import com.springbootessentials.springbootessentials.common.interceptors.OrderControllerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SPEssentialsWebMvcConfig implements WebMvcConfigurer {


    @Autowired
    OrderControllerInterceptor orderControllerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(orderControllerInterceptor)
                .addPathPatterns("/order/*")
                .excludePathPatterns("/order");
    }



}
