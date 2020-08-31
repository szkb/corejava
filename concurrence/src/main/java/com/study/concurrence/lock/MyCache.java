package com.study.concurrence.lock;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyCache {

    static HashMap<String, Object> map = new HashMap<>();
    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    static ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
    static ReentrantReadWriteLock.ReadLock readLock = lock.readLock();

    // 根据 key 获取对应的 value
    public Object get(String key) {
        readLock.lock();
        try {
            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public static void put(String key, Object value) {
        writeLock.lock();
        try {
            map.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    public static void clear() {
        writeLock.lock();
        try {
            map.clear();
        } finally {
            writeLock.unlock();
        }
    }
}
