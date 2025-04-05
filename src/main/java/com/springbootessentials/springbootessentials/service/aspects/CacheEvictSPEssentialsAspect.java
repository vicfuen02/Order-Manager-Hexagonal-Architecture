package com.springbootessentials.springbootessentials.service.aspects;

import com.springbootessentials.springbootessentials.service.cache.CacheManagerService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;


@Aspect
@Component
public class CacheEvictSPEssentialsAspect {

    @Autowired
    private CacheManagerService cacheManagerService;

    @Pointcut("@annotation(org.springframework.cache.annotation.CacheEvict)")
    public void cacheEvictionMethods() {
    }


    @Around("cacheEvictionMethods()")
    public Object getAndEvictCache(ProceedingJoinPoint pJp) throws Throwable {

        MethodSignature signature = (MethodSignature) pJp.getSignature();
        Method method = signature.getMethod();
        CacheEvict cacheEvictAnnotation = method.getAnnotation(CacheEvict.class);

        this.cacheManagerService.getCacheAndEvict(cacheEvictAnnotation.value());

        Object methodResult = pJp.proceed();

        return methodResult;
    }



}
