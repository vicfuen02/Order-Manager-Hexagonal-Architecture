package com.springbootessentials.springbootessentials.common.config;


import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableMethodSecurity
@EnableWebSecurity
@EnableJpaAuditing
@EnableCaching
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableAsync
//@PropertySources({
//        @PropertySource("classpath:cacheSPEssentialsConfig.properties")
//})
@Configuration
public class SPEssentialsConfig {





}
