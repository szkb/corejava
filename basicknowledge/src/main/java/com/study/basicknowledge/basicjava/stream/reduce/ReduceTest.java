package com.study.basicknowledge.basicjava.stream.reduce;

import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/11/14 11:51
 */
public class ReduceTest {

    @Test
    public void test() {
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5);
        int result = numList.stream().reduce(Integer::sum).get();
        System.out.println(result);
    }

    @Test
    public void test2() {
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5);
        int result = numList.stream().reduce(10, Integer::sum);
        System.out.println(result);
    }

    @Test
    public void test3() {
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6);
        ArrayList<String> result = numList.stream().reduce(new ArrayList<String>(), (a, b) -> {
            a.add("element-" + b);
            return a;
        }, (a, b) -> new ArrayList<>(b));
        System.out.println(result);
    }

    @Test
    public void test4() {
        Set<SearchType> FLIGHT_X_SEARCH_TYPES = EnumSet.of(SearchType.AIRLINE_TRANSFER,
                SearchType.CTRIP_TRANSFER, SearchType.FLIGHT_X_TRAIN);
        System.out.println(FLIGHT_X_SEARCH_TYPES);

        FLIGHT_X_SEARCH_TYPES.remove(SearchType.AIRLINE_TRANSFER);
        System.out.println(FLIGHT_X_SEARCH_TYPES);
    }

    @Test
    public void test5() {
        List<String> a = Collections.emptyList();
        System.out.println(a.size());
    }

    @Test
    public void should_test_furture() throws Exception {
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

        ListenableFuture future1 = service.submit(new Callable<Integer>() {
            public Integer call() throws InterruptedException {
                Thread.sleep(1000);
                System.out.println("call future 1.");
                return 1;
            }
        });

        ListenableFuture future2 = service.submit(new Callable<Integer>() {
            public Integer call() throws InterruptedException {
                Thread.sleep(1000);
                System.out.println(1/0);
                //       throw new RuntimeException("----call future 2.");
                return 2;
            }
        });

        final ListenableFuture allFutures = Futures.allAsList(future1, future2);



        Futures.addCallback(allFutures, new FutureCallback<Object>() {

            public void onSuccess(Object result) {
                System.out.println(result.getClass());
                System.out.printf("success with: %s%n", result);
            }

            public void onFailure(Throwable thrown) {
                System.out.printf("onFailure%s%n", thrown.getMessage());
            }
        });

        System.out.println(allFutures.get());
    }
}
