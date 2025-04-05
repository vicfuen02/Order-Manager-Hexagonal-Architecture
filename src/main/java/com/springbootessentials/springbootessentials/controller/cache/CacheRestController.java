package com.springbootessentials.springbootessentials.controller.cache;

import com.springbootessentials.springbootessentials.service.cache.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/cache")
@RestController
public class CacheRestController {


    private CacheService cacheService;

    @Autowired
    public CacheRestController(CacheService cacheService) {
        this.cacheService = cacheService;
    }


    @GetMapping
    public List<Cache> getAllCaches() {
        List<Cache> caches = this.cacheService.getAllCaches();
        return caches;
    }

    @PostMapping("/clearAll")
    public Boolean clearAll() {
        return this.cacheService.clearAll();
    }


}
