package com.wasu.service.impl;

import com.wasu.service.EhCacheTestService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by kale on 2017/3/22.
 */
@Service("EhCacheTestService")
public class EhCacheTestServiceImpl implements EhCacheTestService {
    @Cacheable(value="cacheTest",key="#param")
    public String getTimestamp(String param) {
        Long timestamp=System.currentTimeMillis();
        return timestamp.toString();
    }
}
