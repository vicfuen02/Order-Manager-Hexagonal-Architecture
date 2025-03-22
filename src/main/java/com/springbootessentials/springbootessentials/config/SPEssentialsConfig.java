package com.springbootessentials.springbootessentials.config;


import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@EnableCaching
@EnableAspectJAutoProxy(proxyTargetClass = true)
//@PropertySources({
//        @PropertySource("classpath:cacheSPEssentialsConfig.properties")
//})
@Configuration
public class SPEssentialsConfig {
}
