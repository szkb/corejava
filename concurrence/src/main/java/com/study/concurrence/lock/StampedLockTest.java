package com.study.concurrence.lock;

import java.util.concurrent.locks.StampedLock;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/8/19 20:25
 */
public class StampedLockTest {

    /*
    * https://cloud.tencent.com/developer/article/1470988
    *
    * 把读锁和写锁分为乐观锁和悲观锁，能进一步提升并发效率。但这也是有代价的：
    * 一是代码更加复杂，二是StampedLock是不可重入锁，不能在一个线程中反复获取同一个锁。
    * */
    @Test
    public void test() {

        System.out.println(0 | 1);
        StampedLock stampedLock = new StampedLock();
    }
}
