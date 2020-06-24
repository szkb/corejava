package com.study.service.distributedlock.redis;

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RLock;

public class DistributedRedisLock {

    private static Redisson redisson = RedissonManager.getRedisson();
    private static final String LOCK_TITLE = "redisLock_";

    public static void acquire(String lockName) {
        String key = LOCK_TITLE + lockName;
        RLock mylock = redisson.getLock(key);
        mylock.lock(2, TimeUnit.SECONDS); //lock提供带timeout参数，timeout结束强制解锁，防止死锁
        System.out.println("======lock======" + Thread.currentThread().getName());
    }

    public static void release(String lockName) {
        String key = LOCK_TITLE + lockName;
        RLock mylock = redisson.getLock(key);
        mylock.unlock();
        System.out.println("======unlock======" + Thread.currentThread().getName());
    }

}