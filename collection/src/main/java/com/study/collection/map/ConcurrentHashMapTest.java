package com.study.collection.map;

import java.util.concurrent.ConcurrentHashMap;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/6/1 15:49
 */
public class ConcurrentHashMapTest {

    @Test
    public void test() {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("hello", 1);
        map.put("world", 2);
        System.out.println(map.remove("hel"));
    }

    @Test
    public void test2() {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        map.computeIfAbsent("hello", (key) -> 1);
    }
}
