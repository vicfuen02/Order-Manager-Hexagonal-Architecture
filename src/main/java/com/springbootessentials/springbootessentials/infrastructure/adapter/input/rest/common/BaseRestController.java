package com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.common;

import com.springbootessentials.springbootessentials.application.ports.input.cache.CacheManagerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;

import java.util.List;


public abstract class BaseRestController {


    private Logger log = LogManager.getLogger(BaseRestController.class);

    @Autowired
    private CacheManagerService cacheManagerService;


    public String getCacheKey(List<Cache> caches, String className, String methodName, Object[] params) {
        return this.cacheManagerService.getCacheKey(caches, className, methodName, params);
    }

    public boolean isCacheEnabled(List<Cache> caches, String className, String methodName, Object[] params) {
        return this.cacheManagerService.isCacheEnabled(caches, className, methodName, params);
    }
}
