package com.study.concurrence.listenablefuture;

import static com.study.concurrence.listenablefuture.Common.process;

import com.google.common.util.concurrent.*;
import java.util.*;
import java.util.concurrent.*;
import org.apache.commons.collections4.IterableUtils;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2021/8/17 17:15
 */
public class ListenableFutureTest {

    @Test
    public void test() throws InterruptedException, ExecutionException {
        SearchContext searchContext = new SearchContext();
        ExecutorService executorService = Executors.newCachedThreadPool();
        long time = System.currentTimeMillis();
        ListenableFuture<List<SearchContext>> future =
            Futures.successfulAsList(Common.getAge(searchContext), Common.getName(searchContext));
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
        System.out.println(ans.get().get(1).get());
        long time4 = System.currentTimeMillis();
        System.out.println(time4 - time3);
    }

    @Test
    public void test2() {
        System.out.println(Calendar.getInstance().getTime());
    }

    @Test
    public void test3() throws InterruptedException {
        SearchContext searchContext = new SearchContext();
        ListenableFuture<List<SearchContext>> future =
            Futures.successfulAsList(Common.getAge(searchContext), Common.getName(searchContext));
    }
}
