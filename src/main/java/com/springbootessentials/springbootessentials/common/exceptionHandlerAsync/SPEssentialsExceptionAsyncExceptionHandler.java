package com.springbootessentials.springbootessentials.common.exceptionHandlerAsync;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class SPEssentialsExceptionAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    private static final Logger log = LogManager.getLogger(SPEssentialsExceptionAsyncExceptionHandler.class);


    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        log.error("An error occured in an async task. Handling it with SPEssentialsExceptionAsyncExceptionHandler");
        log.error(ex);
    }
}
