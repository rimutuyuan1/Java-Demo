package com.forezp.thread.guavaCache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class GuavaCacheTest {

    public static void main(String[] args) {
        Cache<String,String> cache = CacheBuilder.newBuilder()
                .maximumSize(2)
                .build();
        cache.put("word","Hello Guava Cache");
        System.out.println(cache.getIfPresent("word"));
    }
}
