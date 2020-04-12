package com.study.concurrence.completablefuture;

import java.time.LocalTime;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hangwu
 * @date 2020/4/3 10:35
 */
public class DubboCloseCanaryConnection {
    private static Map<Integer, String> CHANNELS = new ConcurrentHashMap<>();

    private static void closeCanaryConnection(int timeout) {
        long start = System.currentTimeMillis();

        while (CHANNELS.containsKey(1) && System.currentTimeMillis() - start < timeout) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.printf("request begin: %s%n", LocalTime.now());
        CHANNELS.put(1, "connection-1");

        CompletableFuture<String> resultFuture = new CompletableFuture<>();

        resultFuture.whenComplete((value, throwable) -> {
            System.out.println("1" + Thread.currentThread().getName());
            System.out.printf("closeCanaryConnection begin: %s%n", LocalTime.now());
            closeCanaryConnection(10000);
            System.out.printf("closeCanaryConnection done: %s%n", LocalTime.now());
            System.out.println("------------------------------");
        });

        System.out.println("2" + Thread.currentThread().getName());
        System.out.printf("result complete begin: %s%n", LocalTime.now());
        System.out.println("------------------------------");
        resultFuture.complete("result");
        System.out.printf("result complete done: %s%n", LocalTime.now());

        CHANNELS.remove(1);
        System.out.printf("request done: %s%n", LocalTime.now());
    }
}
