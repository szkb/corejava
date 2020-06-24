package com.study.service.distributedlock.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/6/22 15:58
 */
public class ZookeeperTest {

    void test() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory
            .newClient("localhost:2181", retryPolicy);

        client.start();

//创建分布式锁, 锁空间的根节点路径为/curator/lock

        InterProcessMutex mutex = new InterProcessMutex(client, "/curator/lock");

        try {
            mutex.acquire();

//获得了锁, 进行业务流程

            System.out.println("Enter mutex");

//完成业务流程, 释放锁

            mutex.release();
        } catch (Exception e) {
            e.printStackTrace();
        }

//关闭客户端

        client.close();
    }

    @Test
    public void testDistributedLock() {
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                try {
                    test();
                    System.out.println("hello");
                } catch (Exception e) {
                    System.out.println("getLock fail");
                    e.printStackTrace();
                }
            }).start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
