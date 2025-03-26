package com.springbootessentials.springbootessentials.config;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class SPEssentialsAsyncConfig implements AsyncConfigurer {


    @Autowired
    private AsyncUncaughtExceptionHandler asyncUncaughtExceptionHandler;


    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return this.asyncUncaughtExceptionHandler;
    }

    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(8);
        executor.setQueueCapacity(50);
        executor.setThreadNamePrefix("SPEssentialsThreadExecutor-");
        executor.setRejectedExecutionHandler(new SPEssentialsAbortPolicy());
        executor.initialize();
        return executor;
    }

    public static class SPEssentialsAbortPolicy extends ThreadPoolExecutor.AbortPolicy {

        private final Logger log = LogManager.getLogger(SPEssentialsAbortPolicy.class);
        public SPEssentialsAbortPolicy() {
            super();
            log.warn("Task discarded silently by SPEssentialsAbortPolicy");
        }
    }


}
