package com.study.concurrence.lock;

import java.util.concurrent.locks.ReentrantLock;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/8/10 14:37
 */
public class ReEntrantLockNN {

    @Test
    public void test() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.tryLock();
        lock.lockInterruptibly();
    }
}
