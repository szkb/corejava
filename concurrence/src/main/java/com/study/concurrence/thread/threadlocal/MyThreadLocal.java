package com.study.concurrence.thread.threadlocal;

import java.util.concurrent.CountDownLatch;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/8/5 15:23
 */
public class MyThreadLocal {

    @Test
    public void test() throws InterruptedException {
        // 初始化值是为了防止空指针
        ThreadLocal<StringBuilder> local = ThreadLocal.withInitial(StringBuilder::new);
        CountDownLatch countDownLatch = new CountDownLatch(2);
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 2; j++) {
                    local.set(local.get().append(j));
                }
                System.out.println(Thread.currentThread().getName() + ":" + local.get());
            }).start();
            countDownLatch.countDown();
        }
        countDownLatch.await();
    }

}
