package com.springbootessentials.springbootessentials.application.ports.input.cache;

import org.springframework.cache.Cache;

import java.util.List;

public interface CacheService {

    List<Cache> getAllCaches();

    Boolean clearAll();

}
