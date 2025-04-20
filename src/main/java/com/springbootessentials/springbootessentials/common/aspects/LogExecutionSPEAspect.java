package com.springbootessentials.springbootessentials.common.aspects;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

@Component
@Aspect
public class LogExecutionSPEAspect {

    private static Logger log = LogManager.getLogger(LogExecutionSPEAspect.class);
    private Gson gson = new Gson();

    @Pointcut("@annotation(com.springbootessentials.springbootessentials.common.annotations.LogExecutionSPE) || " +
            "@within(com.springbootessentials.springbootessentials.common.annotations.LogExecutionSPE)")
    public void getLoggableClasses() {}


    @Around("getLoggableClasses()")
    public Object log(ProceedingJoinPoint pJp) throws Throwable {

        Object[] args = pJp.getArgs();
        MethodSignature signature = (MethodSignature) pJp.getSignature();
        Method method = signature.getMethod();

        StringBuilder startSb = new StringBuilder();
        startSb.append("STARTING METHOD CALL: ");

        StringBuilder methodInfoSb = new StringBuilder();
        methodInfoSb.append(pJp.getTarget().getClass().getSimpleName());
        methodInfoSb.append(".");
        methodInfoSb.append(method.getName());
        methodInfoSb.append("(");
        methodInfoSb.append(Arrays.stream(args).map(gson::toJson).collect(Collectors.toList()));
        methodInfoSb.append(")");



        log.info(startSb.append(methodInfoSb).toString());

        long startTime = System.currentTimeMillis();

        Object result = pJp.proceed();

        long endTime = System.currentTimeMillis();
        long executionTime = (endTime - startTime);

        StringBuilder endSb = new StringBuilder();
        endSb.append("ENDING METHOD CALL: ");
        methodInfoSb.append("; Final Execution time: ");
        methodInfoSb.append(executionTime);
        methodInfoSb.append(" ms.");
        log.info(endSb.append(methodInfoSb).toString());


        return result;
    }

}
