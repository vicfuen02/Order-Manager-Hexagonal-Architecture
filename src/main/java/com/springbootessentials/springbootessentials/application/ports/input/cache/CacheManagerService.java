package com.springbootessentials.springbootessentials.application.ports.input.cache;

import org.springframework.cache.Cache;

import java.util.List;

public interface CacheManagerService {

    String getCacheKey(List<Cache> caches, String className, String methodName, Object... params);

    boolean isCacheEnabled(List<Cache> caches, String className, String methodName, Object... params);
    boolean areCachePropertyEnabled(List<Cache> caches);
    boolean isCacheEnabled();

    boolean getCacheAndEvict(String... cachesToEvic);


}
