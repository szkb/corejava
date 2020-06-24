package com.study.service.distributedlock.redis;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class LockExamples {
    public static void main(String[] args) throws InterruptedException {

        Config config = new Config();
        config.useMasterSlaveServers()
            .setMasterAddress("redis://10.5.166.231:6379");
        RedissonClient client = Redisson.create(config);
//        Config config = new Config();
//        config.useClusterServers() //这是用的集群server
//            .setScanInterval(2000) //设置集群状态扫描时间
//            .setMasterConnectionPoolSize(10000) //设置连接数
//            .setSlaveConnectionPoolSize(10000)
//            .addNodeAddress("rediss:// 10.5.166.231:6379");
//        // 默认连接上127.0.0.1:6379
//        RedissonClient client = Redisson.create(config);
        // RLock 继承了 java.util.concurrent.locks.Lock 接口
        RLock lock = client.getLock("lock");

        lock.lock();
        System.out.println("lock acquired");

        Thread t = new Thread(() -> {
            RLock lock1 = client.getLock("lock");
            lock1.lock();
            System.out.println("lock acquired by thread");
            lock1.unlock();
            System.out.println("lock released by thread");
        });

        t.start();
        t.join(1000);

        lock.unlock();
        System.out.println("lock released");

        t.join();

        client.shutdown();
    }
}
