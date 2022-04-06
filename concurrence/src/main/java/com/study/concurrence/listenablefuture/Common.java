package com.study.concurrence.listenablefuture;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/**
 * @author hangwu
 * @date 2021/8/17 17:17
 */
public class Common {

    public static ListenableFuture<SearchContext> getName(SearchContext searchContext) throws InterruptedException {
//        System.out.println(Thread.currentThread().getName());
        searchContext.setName("hello");
//        Thread.sleep(5000);
        return Futures.immediateFuture(searchContext);
    }

    public static ListenableFuture<SearchContext> getAge(SearchContext searchContext) throws InterruptedException {
//        System.out.println(Thread.currentThread().getName());
        searchContext.setAge("120");
        try {
//            Thread.sleep(5000);
//            Thread.sleep(5000);searchContext.setAge(String.valueOf(1 / 0));
        } catch (Exception e) {
            return Futures.immediateFailedFuture(e);
        }
        return Futures.immediateFuture(searchContext);
    }

    public static ListenableFuture<SearchContext> process(SearchContext searchContext) throws InterruptedException {
//        System.out.println(Thread.currentThread().getName());
        Thread.sleep(5000);
        return Futures.immediateFuture(searchContext);
    }
}
