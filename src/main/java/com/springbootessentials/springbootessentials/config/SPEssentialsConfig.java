package com.springbootessentials.springbootessentials.config;


import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableCaching
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableAsync
//@PropertySources({
//        @PropertySource("classpath:cacheSPEssentialsConfig.properties")
//})
@Configuration
public class SPEssentialsConfig {





}
