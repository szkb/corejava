package com.study.basicknowledge.rxjava;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import lombok.NonNull;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/6/29 20:17
 */
public class SubScribe {

    /*
     * 详解线程切换：https://blog.csdn.net/jdsjlzx/article/details/51685769
     *
     * */

    /*
     * 默认情况下， doOnSubscribe() 执行在 subscribe() 发生的线程；
     * 而如果在 doOnSubscribe() 之后有subscribeOn() 的话，它将执行在离它最近的 subscribeOn() 所指定的线程。
     *
     * */

    @Test
    public void test() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Observable.just(1)
            .map(new Function<Integer, Integer>() {
                @Override
                public Integer apply(@NonNull Integer integer) throws Exception {
                    System.out.println("map-1:" + Thread.currentThread().getName());
                    return integer;
                }
            })
            .subscribeOn(Schedulers.computation())
            .map(new Function<Integer, Integer>() {
                @Override
                public Integer apply(@NonNull Integer integer) throws Exception {
                    System.out.println("map-2:" + Thread.currentThread().getName());
                    return integer;
                }
            })
            .subscribeOn(Schedulers.newThread())
            .map(new Function<Integer, Integer>() {
                @Override
                public Integer apply(@NonNull Integer integer) throws Exception {
                    System.out.println("map-3:" + Thread.currentThread().getName());
                    return integer;
                }
            })
            .observeOn(Schedulers.io())
            .subscribe(new Consumer<Integer>() {
                @Override
                public void accept(@NonNull Integer integer) throws Exception {
                    System.out.println("subscribe:" + Thread.currentThread().getName());
                }
            });

        Thread.sleep(10000);
    }

    @Test
    public void test2() throws InterruptedException {
        Observable.just(1)
            .map(new Function<Integer, Integer>() {
                @Override
                public Integer apply(@NonNull Integer integer) throws Exception {
                    System.out.println("map-1:" + Thread.currentThread().getName());
                    return integer;
                }
            })
            .subscribeOn(Schedulers.computation())
            .doOnSubscribe(item -> System.out.println("hello:" + Thread.currentThread().getName()))
            .observeOn(Schedulers.io())
            .subscribe(item -> System.out.println("world:" + Thread.currentThread().getName()));

        Thread.sleep(10000);

    }

}
