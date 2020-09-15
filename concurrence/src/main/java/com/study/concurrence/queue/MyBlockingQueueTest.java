package com.study.concurrence.queue;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.*;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/9/14 21:58
 */
public class MyBlockingQueueTest {

    @Test
    public void test() throws InterruptedException {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        AtomicInteger number = new AtomicInteger(0);
//        Thread threadProduce = new Thread(() -> {
//            System.out.println("生产数据:" + number.get());
//        });
//        Thread threadConsume = new Thread(() -> {
//            System.out.println("消费数据:" + number.get());
//        });

        while (true) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "生产数据:" + number.get());
                queue.offer(number.getAndIncrement());
            }).start();
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "消费数据:" + queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "消费数据:" + queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

            Thread.sleep(3000);
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "生产数据:" + number.get());
                queue.offer(number.getAndIncrement());
            }).start();
            Thread.sleep(3000);
        }
    }

    @Test
    public void test2() throws Exception {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        AtomicInteger number = new AtomicInteger(0);

        while (true) {
            new Thread(() -> {

                if (queue.isEmpty()) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    System.out.println(Thread.currentThread().getName() + "消费数据:" + queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();

            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "生产数据:" + number.get());
                queue.offer(number.getAndIncrement());
                if (!queue.isEmpty()) {
                    condition.signal();
                }
            }).start();
        }
//        System.out.println("hello world");

    }

    @Test
    public void test3() throws InterruptedException {
        System.out.println("hello");

        new Thread(() -> {
            while (true) {
                System.out.println("I am " + Thread.currentThread().getName());
            }
        }).start();

        System.out.println("world");

//        Thread.sleep(1000);
    }

}
