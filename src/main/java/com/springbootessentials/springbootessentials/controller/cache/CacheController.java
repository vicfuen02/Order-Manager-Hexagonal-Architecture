package com.springbootessentials.springbootessentials.controller.cache;


import com.springbootessentials.springbootessentials.service.cache.CacheManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CacheController {


    public String getCacheKey(List<Cache> caches, String className, String methodName, Object... params) {
        StringBuilder cacheKeySb = new StringBuilder()
                .append(className)
                .append("-")
                .append(methodName)
                .append(
                        Arrays.stream(params).map(Object::toString).collect(Collectors.joining("-"))
                );

        return cacheKeySb.toString();
    }

    public boolean isCacheEnabled(List<Cache> caches, String className, String methodName, Object... params) {
        return true;
    }



}
