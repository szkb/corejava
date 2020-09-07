package com.study.concurrence.future;

import java.util.concurrent.*;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/9/2 16:54
 */
public class FutureTaskTest {

    @Test
    public void test() throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(() -> "hello");

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(task);
        Thread.sleep(100000);
        System.out.println(task.get());


        ExecutorService executorService1 = Executors.newCachedThreadPool();

        FutureTask<String> futureTask = new FutureTask<>(() -> System.out.println("are you ok"), "world");
        executorService1.execute(futureTask);
        Thread.sleep(100000);

        System.out.println(futureTask.isCancelled());
        System.out.println(futureTask.get());


    }

}
