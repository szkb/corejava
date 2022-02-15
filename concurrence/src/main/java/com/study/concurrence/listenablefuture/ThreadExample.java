package com.study.concurrence.listenablefuture;

import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hangwu
 * @date 2022/2/9 20:17
 */
public class ThreadExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread:" + Thread.currentThread().getName());
        });

        System.out.println("Thread:" + Thread.currentThread().getName());
    }
}
