package com.springbootessentials.springbootessentials.application.service.cache;

import com.springbootessentials.springbootessentials.application.ports.input.cache.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CacheServiceImpl implements CacheService {


    private CacheManager cacheManager;

    @Autowired
    public CacheServiceImpl(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public List<Cache> getAllCaches() {
        return this.cacheManager.getCacheNames()
                .stream()
                .map(cacheManager::getCache)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean clearAll() {

        this.cacheManager.getCacheNames()
                .stream()
                .map(cacheManager::getCache)
                .forEach(Cache::clear);
        return true;
    }

}
