package com.study.concurrence.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/6/8 17:35
 */
public class MultiThread implements Runnable {
    Map<String, AtomicInteger> map = new ConcurrentHashMap<>();
    public MultiThread() {

    }


    @Test
    public void test() throws InterruptedException {
        for (int i = 0; i < 1; i++) {
            new Thread(new MultiThread()).start();
        }
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + map);
    }

    @Override
    public void run() {
        Map<String, AtomicInteger> map1 = new ConcurrentHashMap<>();
        for (int i = 0; i < 3; i++) {
            if (i % 2 == 0) {
                map1.computeIfAbsent("hello world", key -> new AtomicInteger()).decrementAndGet();
                System.out.println(Thread.currentThread().getName() + map1);
            } else {
                map1.computeIfAbsent("hello world", key -> new AtomicInteger()).incrementAndGet();
                System.out.println(Thread.currentThread().getName() + map1);
            }
        }
        map = map1;
    }

    @Test
    public void test2() {
        Map<String, AtomicInteger> map = new ConcurrentHashMap<>();

        map.computeIfAbsent("hello world", key -> new AtomicInteger()).decrementAndGet();

        System.out.println(map);
    }

    @Test
    public void test3() {
        String ans = "12_B_KW-WS";
        String temp = "12_B_";
        System.out.println(ans.replace(temp, ""));
        System.out.println(ans);
        System.out.println(temp);
    }
}
