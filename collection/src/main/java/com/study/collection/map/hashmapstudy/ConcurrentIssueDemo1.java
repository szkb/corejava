package com.study.collection.map.hashmapstudy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class ConcurrentIssueDemo1 {

    private static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) throws Exception {

        CountDownLatch countDownLatch = new CountDownLatch(2);

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

        // 线程1 => t1
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 9999; i++) {
                    map.put("thread1_key" + i, "thread1_value" + i);
                }
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        // 线程2 => t2
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 9999; i++) {
                    map.put("thread2_key" + i, "thread2_value" + i);
                }
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        cyclicBarrier.reset();
//        countDownLatch.await();
        System.out.println(map.size());
    }
}
