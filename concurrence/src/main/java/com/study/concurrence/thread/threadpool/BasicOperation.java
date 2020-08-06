package com.study.concurrence.thread.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.*;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/8/5 11:01
 */
public class BasicOperation {

    private static final String DB_THREAD_NAME_FORMAT = "db-thread-pool-%d";

    @Test
    public void test() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat(DB_THREAD_NAME_FORMAT).build();
        final RejectedExecutionHandler handler = new AbortPolicy();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 8, 60, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(3), threadFactory, handler);

        threadPoolExecutor.execute(this::testThreadPool);
        System.out.println(Thread.currentThread().getName() + "world");
    }

    private void testThreadPool() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "hello");
        }
    }
}
