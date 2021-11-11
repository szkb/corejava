package com.study.redis;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2021/8/16 11:28
 */
public class CacheTest {

    @Test
    public void test() {
        Cache needNotifyXForbidEntitiesCache = CacheBuilder.newBuilder().recordStats().maximumSize(3).build();
        needNotifyXForbidEntitiesCache.put(1, 2);
        needNotifyXForbidEntitiesCache.put(2, 2);
        needNotifyXForbidEntitiesCache.put(3, 2);
        needNotifyXForbidEntitiesCache.put(5, 2);
        needNotifyXForbidEntitiesCache.put(4, 2);
        needNotifyXForbidEntitiesCache.put(27492749274L, 3);
        System.out.println(needNotifyXForbidEntitiesCache.asMap());
        System.out.println(needNotifyXForbidEntitiesCache.getIfPresent(27492749274L));
    }

}
