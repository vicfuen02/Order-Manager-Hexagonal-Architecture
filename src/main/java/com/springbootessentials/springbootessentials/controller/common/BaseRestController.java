package com.springbootessentials.springbootessentials.controller.common;

import com.springbootessentials.springbootessentials.service.cache.CacheManagerService;
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
