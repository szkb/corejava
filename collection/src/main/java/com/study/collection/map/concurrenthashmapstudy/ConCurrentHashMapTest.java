package com.study.collection.map.concurrenthashmapstudy;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/8/11 11:45
 */
public class ConCurrentHashMapTest {

    @Test
    public void test() {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("hello", "world");
        concurrentHashMap.put("1", "1");

        System.out.println(concurrentHashMap.get("1"));
        System.out.println(concurrentHashMap.get("2"));

        Map<String, String> map = new HashMap<>();
        Collections.synchronizedMap(map);
    }
}
