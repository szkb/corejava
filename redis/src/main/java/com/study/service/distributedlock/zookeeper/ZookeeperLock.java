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
public class ZookeeperLock {

    public boolean getZookeeperLock(CuratorFramework client) {

        //创建分布式锁, 锁空间的根节点路径为/curator/lock
        InterProcessMutex mutex = new InterProcessMutex(client, "/curator/lock");
        try {
            mutex.acquire();
            //获得了锁, 进行业务流程
            System.out.println(Thread.currentThread().getName() + ": Enter mutex");
            //完成业务流程, 释放锁
            mutex.release();
        } catch (Exception e) {
            return false;
        }
        //关闭客户端
        client.close();
        return true;
    }

    @Test
    public void testDistributedLock() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        // 这里应该先启动zookeeper
        CuratorFramework client = CuratorFrameworkFactory.newClient("localhost:2181", retryPolicy);
        client.start();
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                try {
                    if (getZookeeperLock(client)) {
                        System.out.println(Thread.currentThread().getName() + ": hello");
                    }
                } catch (Exception e) {
                    System.out.println("getLock fail");
                    e.printStackTrace();
                }
            }).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
