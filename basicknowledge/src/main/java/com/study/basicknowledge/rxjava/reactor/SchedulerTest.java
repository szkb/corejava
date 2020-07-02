package com.study.basicknowledge.rxjava.reactor;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * @author hangwu
 * @date 2020/7/1 16:11
 */
public class SchedulerTest {

    @Test
    public void test() {
        Flux.create(sink -> {
            sink.next(Thread.currentThread().getName());
            sink.complete();
        })
            .publishOn(Schedulers.single())
            .map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
            .publishOn(Schedulers.elastic())
            .map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
            .subscribeOn(Schedulers.parallel())
            .toStream()
            .forEach(System.out::println);
    }

}
