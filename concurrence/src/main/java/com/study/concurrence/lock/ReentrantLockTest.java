package com.study.concurrence.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by haicheng.lhc on 17/05/2017.
 *
 * @author haicheng.lhc
 * @date 2017/05/17
 */
public class ReentrantLockTest extends Thread {

    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    public ReentrantLockTest(String name) {
        super.setName(name);
    }

    @Override
    public void run() {
        for (int j = 0; j < 1; j++) {
            lock.lock();
            try {
                System.out.println(this.getName() + " " + i);
                i++;
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest test1 = new ReentrantLockTest("thread1");
        ReentrantLockTest test2 = new ReentrantLockTest("thread2");
        ReentrantLockTest test3 = new ReentrantLockTest("thread3");

        test1.start();
        test2.start();
        test3.start();
        test1.join();
        test2.join();
        test3.join();
        System.out.println(i);
    }
}
