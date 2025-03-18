package com.springbootessentials.springbootessentials.service.cache;

import org.springframework.cache.Cache;

import java.util.List;

public interface CacheService {

    List<Cache> getAllCaches();

}
