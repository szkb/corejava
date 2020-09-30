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
    * https://www.liaoxuefeng.com/wiki/1252599548343744/1309138673991714
    * 把读锁和写锁分为乐观锁和悲观锁，能进一步提升并发效率。但这也是有代价的：
    * 一是代码更加复杂，二是StampedLock是不可重入锁，不能在一个线程中反复获取同一个锁。
    * */

    /*
        改进之处在于：读的过程中也允许获取写锁后写入！这样一来，我们读的数据可能不一致，所以需要一点额外的代码
        来判断读的过程是否有写入，这种读锁是一种乐观锁。乐观锁的意思是乐观地估计读的过程中大概率不会有写入，因此
        被称为乐观锁。反过来，悲观锁则是读的过程中拒绝有写入，也就是写入必须等待。显然乐观锁的并发效率高，但是一旦有
        小概率的写入导致读取的数据不一致，需要能检测出来，再读一遍即可。
     */
    @Test
    public void test() {

        System.out.println(0 | 1);
        StampedLock stampedLock = new StampedLock();
    }
}
