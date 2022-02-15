package com.study.concurrence.listenablefuture;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2022/2/9 19:35
 */
public class ListenableFutureExample {

    public static void main(String[] args) {
        Executor executor = MoreExecutors.directExecutor();
        executor.execute(() -> {
            System.out.println("Thread:" + Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Thread:" + Thread.currentThread().getName());
    }

    @Test
    public void should_test_furture() throws Exception {
        Executor service =  MoreExecutors.directExecutor();

        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hello");
            }
        });

        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(1/2);
            }
        });

        System.out.println("world");


//        Futures.addCallback(allFutures, new FutureCallback<Object>() {
//
//            @Override
//            public void onSuccess(Object result) {
//                System.out.println(result.getClass());
//                System.out.printf("success with: %s%n", result);
//            }
//
//            @Override
//            public void onFailure(Throwable thrown) {
//                System.out.printf("onFailure%s%n", thrown.getMessage());
//            }
//        });
//
//        System.out.println(allFutures.get());
    }

}
