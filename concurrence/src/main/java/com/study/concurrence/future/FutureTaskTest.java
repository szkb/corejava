package com.study.concurrence.future;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.List;
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

    @Test
    public void test2() throws ExecutionException, InterruptedException, TimeoutException {

        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(5));
        ListenableFuture<String> lf1 = listeningExecutorService.submit(() -> {
            Thread.sleep(10000);
            return String.valueOf(1/0);
        });
        ListenableFuture<String> lf2 = listeningExecutorService.submit(() -> {
            Thread.sleep(1000);
            return "listFuture2";
        });
        List<ListenableFuture<String>> listenableFutures = Lists.newArrayList(lf1, lf2);
        ListenableFuture<List<String>> listListenableFuture = Futures.successfulAsList(listenableFutures);
//        Thread thread = new Thread(() -> {
//            while (true) {
//                System.out.println(Thread.currentThread().getName()+"并发工作中.....");
//                if (listListenableFuture.isDone()){
//                    break;
//                }
//            }
//        },"test-thread");

        System.out.println(listListenableFuture.get(10, TimeUnit.SECONDS));

    }

}
