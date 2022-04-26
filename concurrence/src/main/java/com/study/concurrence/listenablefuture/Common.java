package com.study.concurrence.listenablefuture;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import lombok.SneakyThrows;
import org.slf4j.MDC;

/**
 * @author hangwu
 * @date 2021/8/17 17:17
 */
public class Common {

    public static ListenableFuture<SearchContext> getName(SearchContext searchContext) throws InterruptedException {
//        System.out.println(Thread.currentThread().getName());
        searchContext.setName("hello");
        Thread.sleep(500);
        return Futures.immediateFuture(searchContext);
    }

    public static ListenableFuture<SearchContext> getAge(SearchContext searchContext) throws Exception {
        SettableFuture<SearchContext> future = SettableFuture.create();
        //        System.out.println(Thread.currentThread().getName());
        Futures.addCallback(Futures.immediateFuture(
            getNumber()), new FutureCallback<String>() {
            @Override
            public void onSuccess(String age) {
                try {
                    Thread.sleep(500);
                    searchContext.setAge(age);
                    future.set(searchContext);
                    System.out.println("hello");
//            searchContext.setAge(String.valueOf(1 / 0));
                } catch (Exception e) {
                }
            }

            @Override
            public void onFailure(Throwable e) {
                future.setException(e);
            }
        });

//        return Futures.transformAsync(Futures.immediateFuture(
//            getNumber()), item -> {
//            searchContext.setAge(item);
//            return Futures.immediateFuture(searchContext);
//        });
        return future;
    }

    private static String getNumber() throws InterruptedException {
        Thread.sleep(1000);
        return "123";
    }

    public static ListenableFuture<SearchContext> process(SearchContext searchContext) throws InterruptedException {
//        System.out.println(Thread.currentThread().getName());
        Thread.sleep(5000);
        return Futures.immediateFuture(searchContext);
    }

    public static ListenableFuture<SearchContext> getAsyncAge(CallBack callBack) throws InterruptedException {
        return null;

    }
}
