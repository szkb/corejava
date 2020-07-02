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

    @Test
    public void test() {
        Observable.just(1)
            .map(new Function<Integer, Integer>() {
                @Override
                public Integer apply(@NonNull Integer integer) throws Exception {
                    System.out.println("map-1:"+Thread.currentThread().getName());
                    return integer;
                }
            })
            .subscribeOn(Schedulers.newThread())
            .map(new Function<Integer, Integer>() {
                @Override
                public Integer apply(@NonNull Integer integer) throws Exception {
                    System.out.println("map-2:"+Thread.currentThread().getName());
                    return integer;
                }
            })
            .subscribeOn(Schedulers.io())
            .map(new Function<Integer, Integer>() {
                @Override
                public Integer apply(@NonNull Integer integer) throws Exception {
                    System.out.println("map-3:"+Thread.currentThread().getName());
                    return integer;
                }
            })
//            .subscribeOn(Schedulers.computation())
            .subscribe(new Consumer<Integer>() {
                @Override
                public void accept(@NonNull Integer integer) throws Exception {
                    System.out.println("subscribe:"+Thread.currentThread().getName());
                }
            });
    }

}
