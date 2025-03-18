package com.springbootessentials.springbootessentials.controller.cache;


import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class CacheController {

    public String getCacheKey(String className, String methodName, Object... params) {
        StringBuilder cacheKeySb = new StringBuilder()
                .append(className)
                .append("-")
                .append(methodName)
                .append(
                        Arrays.stream(params).map(Object::toString).collect(Collectors.joining("-"))
                );

        return cacheKeySb.toString();
    }


}
