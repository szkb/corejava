package com.study.concurrence.automic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/4/10 11:06
 */
public class AutomicTest {

    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    @Test
    public void test() throws InterruptedException {
        AtomicInteger number = new AtomicInteger(3);
        final int[] a = {3};
        for (int i = 0; i < 10; i++) {
            int finali = i;
            threadPool.execute(() -> {
                if (finali % 2 == 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                number.getAndAdd(3);
                a[0] += 3;
            });
        }

        Thread.sleep(6000);
        System.out.println(number.get());
        System.out.println(a[0]);
    }

    @Test
    public void test1() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            test();
        }
    }

    @Test
    public void test2() {
        AtomicInteger number = new AtomicInteger(3);
        AtomicInteger number1 = new AtomicInteger(3);
        System.out.println(number.getAndAdd(3));
        System.out.println(number1.addAndGet(4));
    }

    @Test
    public void test3() {
        AtomicInteger number = new AtomicInteger(3);
        int temp = number.getAndUpdate((a) -> {
            System.out.println("hello");
            return a + 3;
        });
        System.out.println(temp);
        System.out.println(number.get());

        int temp2 = number.updateAndGet((a) -> a - 1);
        System.out.println(temp2);
        System.out.println(number.get());
    }

    @Test
    public void test4() {
        AtomicInteger number = new AtomicInteger(3);
        int temp = number.accumulateAndGet(100, (a, x) -> a * x);
        System.out.println(temp);
        System.out.println(number);

        int temp2 = number.getAndAccumulate(100, (a, x) -> a * x);
        System.out.println(temp2);
        System.out.println(number);
    }

}
