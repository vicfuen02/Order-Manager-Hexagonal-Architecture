package com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.cache;

import com.springbootessentials.springbootessentials.application.ports.input.cache.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.security.access.prepost.PreAuthorize;
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

    
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping
    public List<Cache> getAllCaches() {
        List<Cache> caches = this.cacheService.getAllCaches();
        return caches;
    }


    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/clearAll")
    public Boolean clearAll() {
        return this.cacheService.clearAll();
    }


}
