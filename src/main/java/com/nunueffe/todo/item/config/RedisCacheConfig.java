package com.nunueffe.todo.item.config;

import java.time.Duration;

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;

@Configuration
public class RedisCacheConfig {

	
	@Bean
	public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
		
		return (builder) -> builder.withCacheConfiguration("todo#item", 
				RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(20)));
	}
}
