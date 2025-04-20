package com.springbootessentials.springbootessentials.common.config;

import com.springbootessentials.springbootessentials.common.filters.SPEssentialsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SPEssentialsFilterConfig {

    @Bean
    public FilterRegistrationBean<SPEssentialsFilter> filter() {

        FilterRegistrationBean<SPEssentialsFilter> filter = new FilterRegistrationBean<>();
        filter.setFilter(new SPEssentialsFilter());
        filter.setOrder(1);
        filter.addUrlPatterns("/*");
        return filter;
    }

}
