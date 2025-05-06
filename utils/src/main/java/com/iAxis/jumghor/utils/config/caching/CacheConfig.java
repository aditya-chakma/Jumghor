package com.iAxis.jumghor.utils.config.caching;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

/**
 * @author aditya.chakma
 * @since 05 May, 2025 12:58 PM
 */
@EnableCaching
@Configuration
public class CacheConfig {

    // simple cache
    // todo: replace with redis
    // todo: ehcache
    @Bean
    CacheManager cacheManager() {
        // configure and return an implementation of Spring's CacheManager SPI
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Set.of(
                new ConcurrentMapCache("default"),
                new ConcurrentMapCache("app_user")));
        return cacheManager;
    }
}
