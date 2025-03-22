package com.springbootessentials.springbootessentials.service.cache.impl;

import com.springbootessentials.springbootessentials.service.cache.CacheManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

@Service
public class CacheManagerServiceImpl implements CacheManagerService {


    @Autowired
    private CacheManager cacheManager;

    private final Properties cacheProperties;
    private static final String CACHE_EVICT_SUFIX = ".evict";
    private static final String CACHE_ENABLED_SUFIX = ".enabled";

    public CacheManagerServiceImpl() {
        Properties properties;
        try {
            ClassPathResource resource = new ClassPathResource("cacheSPEssentialsConfig.properties");
            properties = PropertiesLoaderUtils.loadProperties(resource);
        }
        catch (IOException e) {
            properties = new Properties();
        }
        this.cacheProperties = properties;
    }

    @Override
    public boolean isCacheEnabled() {
        return Boolean.parseBoolean(this.cacheProperties.getProperty("cacheSPE" + CACHE_ENABLED_SUFIX));
    }

    public Properties getCacheProperties() {
        return cacheProperties;
    }

    public String getCacheProperty(String property) {
        Properties properties = this.getCacheProperties();
        return properties.containsKey(property) ? this.getCacheProperties().getProperty(property) : "";
    }

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
        return this.isCacheEnabled() && this.areCachePropertyEnabled(caches);
    }

    @Override
    public boolean areCachePropertyEnabled(List<Cache> caches) {
        return caches.stream()
                .allMatch(cache -> Boolean.parseBoolean(this.getCacheProperty(cache.getName() + CACHE_ENABLED_SUFIX)));
    }

    public boolean getCacheAndEvict(String[] cacheEvictValues) {

        if (cacheEvictValues == null) {
            return false;
        }

        return Arrays.stream(cacheEvictValues)
                .allMatch(cacheToEvict -> this.evict(cacheToEvict + CACHE_EVICT_SUFIX));
    }

    private boolean evict(String cacheName) {

        if (!StringUtils.hasText(cacheName)) {
            return false;
        }

        Properties properties = this.getCacheProperties();
        if (!properties.containsKey(cacheName)) {
            return false;
        }

        Arrays.stream(properties.getProperty(cacheName).split(","))
                .map(this.cacheManager::getCache) // Get Cache objects
                .forEach(Cache::clear);

        return true;
    }



}
