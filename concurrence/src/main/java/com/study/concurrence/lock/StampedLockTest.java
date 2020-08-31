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
    * */
    @Test
    public void test() {

        System.out.println(0 | 1);
        StampedLock stampedLock = new StampedLock();
    }
}
