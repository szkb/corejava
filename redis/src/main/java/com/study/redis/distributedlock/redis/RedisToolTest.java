package com.study.redis.distributedlock.redis;


import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/6/10 20:51
 */
public class RedisToolTest {

    @Test
    public void test() {
        RedissonManager.init(); //初始化
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(() -> {
                try {
                    String key = "test123";
                    DistributedRedisLock.acquire(key);
                    Thread.sleep(1000); //获得锁之后可以进行相应的处理
                    System.out.println("======获得锁后进行相应的操作======");
                    DistributedRedisLock.release(key);
                    System.out.println("=============================");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }
    }
}
