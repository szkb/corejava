package com.study.basicknowledge.rxjava;

import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/6/29 15:21
 */
public class FromIterable {

    @Test
    public void test() {
        List<Integer> temp = Arrays.asList(1, 2, 3, 4);
        Observable.fromIterable(temp).flatMap(item -> divide(item).onErrorReturn(throwable -> {
            try {
                System.out.println("hello world");
                System.out.println(item + "yes");
            } catch (Exception e) {
                return item;
            }
            System.out.println(throwable);
            return item + 2;
        }).toObservable()).subscribe(System.out::println);

        System.out.println("hhhhhh");
    }

    private Single<Object> divide(Integer item) throws InterruptedException {
        Thread.sleep(1000);
        return Single.just(item * (item + 2));
//        try {
//            return Single.just(item / (item - 2));
//        } catch (Exception e) {
//            return Single.just(item);
//        }
    }

    private Integer add(Integer item) {
        return item + 3;
    }

    @Test
    public void test1() {
        String ans = StringUtils.leftPad(String.valueOf(1), 2, "0");
        System.out.println(ans);
    }

    @Test
    public void test2() throws ExecutionException, InterruptedException {
        List<Integer> temp = Arrays.asList(1, 2, 3, 4);
        CompletableFuture<Void> number = CompletableFuture
            .runAsync(() -> temp.forEach(item -> System.out.println(add(item))));

        System.out.println(number.get());
    }

}
