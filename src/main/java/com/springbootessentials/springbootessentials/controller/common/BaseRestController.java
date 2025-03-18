package com.springbootessentials.springbootessentials.controller.common;

import com.springbootessentials.springbootessentials.controller.cache.CacheController;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class BaseRestController {

    @Autowired
    private CacheController cacheController;


    public String getCacheKey(String className, String methodName, Object[] params) {
        return this.cacheController.getCacheKey(className, methodName, params);
    }

}
