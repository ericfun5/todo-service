package com.nunueffe.todo.item.config;

import java.time.Duration;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Component;

//@Component
public class RedisCacheManagerCustomizer implements CacheManagerCustomizer<RedisCacheManager>{

	@Override
	public void customize(RedisCacheManager cacheManager) {
		// TODO Auto-generated method stub
		RedisCacheConfiguration config = cacheManager.getCacheConfigurations()
		.getOrDefault("todo#item",RedisCacheConfiguration.defaultCacheConfig() )
		.entryTtl(Duration.ofSeconds(10));
		
		cacheManager.getCacheConfigurations().put("todo#item", config);
	}

	
}
