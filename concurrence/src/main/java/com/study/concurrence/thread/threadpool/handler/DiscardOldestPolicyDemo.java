package com.study.concurrence.thread.threadpool.handler;

import java.util.concurrent.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiscardOldestPolicyDemo {

    private static final int THREADS_SIZE = 1;
    private static final int CAPACITY = 2;

    public static void main(String[] args) throws Exception {

        // 创建线程池。线程池的"最大池大小"和"核心池大小"都为1(THREADS_SIZE)，"线程池"的阻塞队列容量为1(CAPACITY)。  
        ThreadPoolExecutor pool = new ThreadPoolExecutor(THREADS_SIZE, THREADS_SIZE, 0, TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(CAPACITY));
        // 设置线程池的拒绝策略为"DiscardOldestPolicy"  
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        pool.setRejectedExecutionHandler(new DiscardAndLogPolicy());
        // 新建10个任务，并将它们添加到线程池中。  
        for (int i = 0; i < 4; i++) {
            Runnable myrun = new MyRunnable("task-" + i);
            pool.execute(myrun);
        }
        // 关闭线程池  
        pool.shutdown();
    }

    public static class DiscardAndLogPolicy implements RejectedExecutionHandler {
        private static final Logger LOGGER = LoggerFactory.getLogger(DiscardAndLogPolicy.class);

        public DiscardAndLogPolicy() {
        }

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            LOGGER.error("Task " + r.toString() + " rejected from " + e.toString());
        }
    }
}  