package com.study.basicknowledge.rxjava;

import static org.junit.Assert.assertEquals;

import io.reactivex.*;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/6/29 20:40
 */
public class SingleHelper {

    @Test
    public void test() {
        System.out.println(Thread.currentThread().getName());

        Observable.create(new ObservableOnSubscribe<String>() {

            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                System.out.println(Thread.currentThread().getName());
                e.onNext("hello");
//                e.onComplete();
                e.onNext("world");
            }

        }).subscribeOn(Schedulers.io()).subscribe(new Consumer<String>() {

            @Override
            public void accept(String s) {
                System.out.println(Thread.currentThread().getName());
                System.out.println(s);
            }
        });
    }

    @Test
    public void doOnEventComplete() {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        Single.just(10).doOnEvent(new BiConsumer<Integer, Throwable>() {
            @Override
            public void accept(final Integer integer, final Throwable throwable) throws Exception {
                if (integer != null) {
                    atomicInteger.incrementAndGet();
                }
                System.out.println(Thread.currentThread().getName());
                System.out.println(atomicInteger);
            }
        }).subscribe();
        assertEquals(1, atomicInteger.get());
    }

    @Test
    public void test3() {
        AtomicInteger executeCount = new AtomicInteger(1);
        System.out.println(executeCount.decrementAndGet());
    }
}
