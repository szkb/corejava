package com.study.concurrence.listenablefuture;

import static com.study.concurrence.listenablefuture.Common.process;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.Futures.FutureCombiner;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.commons.collections4.IterableUtils;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2021/8/17 17:15
 */
public class ListenableFutureTest {

    @Test
    public void test() throws Exception {
        SearchContext searchContext = new SearchContext();
        ExecutorService executorService = Executors.newCachedThreadPool();
        long time = System.currentTimeMillis();
        ListenableFuture<List<SearchContext>> future =
            Futures.allAsList(Common.getAge(searchContext), Common.getName(searchContext));
        long time1 = System.currentTimeMillis();
//        System.out.println(time1 - time);
//        System.out.println(future.get());

        long time2 = System.currentTimeMillis();
        ListenableFuture<List<ListenableFuture<SearchContext>>> ans = Futures.transformAsync(future, list -> {
            List<ListenableFuture<SearchContext>> resultList = new ArrayList<>(list.size());
            IterableUtils.forEach(list, c -> {
                try {
                    resultList.add(process(c));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            return Futures.immediateFuture(resultList);
        }, MoreExecutors.directExecutor());
        long time3 = System.currentTimeMillis();
        System.out.println(time3 - time2);
        System.out.println(ans.get().get(0).get());
        System.out.println(ans.get().get(1).get());
        long time4 = System.currentTimeMillis();
        System.out.println(time4 - time3);
    }

    @Test
    public void test2() {
        System.out.println(Calendar.getInstance().getTime());
    }

    @Test
    public void test3() throws Exception {
        SearchContext searchContext = new SearchContext();
        long time = System.currentTimeMillis();
        ListenableFuture<List<SearchContext>> future =
            Futures.successfulAsList(Common.getAge(searchContext), Common.getName(searchContext));
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time);
    }

    @Test
    public void test4() throws Exception {
        SearchContext searchContext = new SearchContext();

        ListenableFuture<SearchContext> future = Common.getAge(searchContext);
        Future<SearchContext> future1 = Futures.lazyTransform(future, context -> {
            context.setAge("100");
            return context;
        });

        System.out.println(future.get().getAge());
//        System.out.println(future1.get().getAge());
        System.out.println(future1.isDone());
    }

    @Test
    public void test5() throws Exception {
        // https://www.1ju.org/article/guava-futures-listenablefuture
        SearchContext searchContext = new SearchContext();
        long time = System.currentTimeMillis();
        FutureCombiner<SearchContext> future =
            Futures.whenAllSucceed(Common.getAge(searchContext), Common.getName(searchContext));
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time);
        System.out.println(future.call(() -> future).get());
    }

    @Test
    public void test6() throws Exception {
        SearchContext searchContext = new SearchContext();

        ListenableFuture<SearchContext> future = Common.getAge(searchContext);
        Future<SearchContext> future1 = Futures.immediateCancelledFuture();
        System.out.println(future.get());
        System.out.println(future1.get());
    }

    @Test
    public void test7() {
        Map<String, String> ans = new HashMap<>();
        ans.put("hello", "world");
        System.out.println(ans.getOrDefault("111", null));
    }

    @Test
    public void test8() throws Exception {
        SearchContext searchContext = new SearchContext();

        long time = System.currentTimeMillis();
        ListenableFuture<SearchContext> future = Common.getAge(searchContext);
        System.out.println(System.currentTimeMillis() - time);
//        CallBack callBack = new CallBack() {
//            @Override
//            public void execute(SearchContext searchContext1) {
//                searchContext1.setAge("120");
//            }
//        };
//        ListenableFuture<SearchContext> future = Common.getAsyncAge(callBack);
        ListenableFuture<SearchContext> future1 = Common.getName(searchContext);
        Futures.transformAsync(future1, item -> {
            System.out.println(future.get());
            long time1 = System.currentTimeMillis();
            System.out.println(time1 - time);
            return null;
        });
    }
}
