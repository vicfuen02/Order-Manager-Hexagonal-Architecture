package com.springbootessentials.springbootessentials.common.filters;

import jakarta.servlet.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;


public class SPEssentialsFilter implements Filter {

    private static final Logger log = LogManager.getLogger(SPEssentialsFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init SPEssentialsFilter spessentials");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("init doFilter SPEssentialsFilter spessentials");

        filterChain.doFilter(servletRequest, servletResponse);
        log.info("end doFilter SPEssentialsFilter spessentials");

    }

    @Override
    public void destroy() {
        log.info("destroy SPEssentialsFilter spessentials");
    }

}
