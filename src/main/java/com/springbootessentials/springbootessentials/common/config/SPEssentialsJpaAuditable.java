package com.springbootessentials.springbootessentials.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Configuration
public class SPEssentialsJpaAuditable {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> {
            return Optional.of("SYSTEM");
        };
    }



}
