package com.study.concurrence.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/8/19 20:12
 */
public class ReadWriteLockExample {

    /*
    * https://juejin.im/post/6844903680370556941
    *
    * */
    @Test
    public void test() {
        ReadWriteLock lock = new ReentrantReadWriteLock();
    }

}
