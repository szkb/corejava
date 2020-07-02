package com.study.basicknowledge.rxjava.reactor;

import java.util.ArrayList;
import java.util.Random;
import org.junit.Test;
import reactor.core.publisher.Flux;

/**
 * @author hangwu
 * @date 2020/7/1 15:38
 */
public class FluxTest {

    @Test
    public void test() {
        Flux.generate(sink -> {
            sink.next("Hello");
            sink.complete();
        }).subscribe(System.out::println);

        final Random random = new Random();
        Flux.generate(ArrayList::new, (list, sink) -> {
            int value = random.nextInt(100);
            list.add(value);
            sink.next(value);
            if (list.size() == 10) {
                sink.complete();
            }
            return list;
        }).subscribe(System.out::println);
    }

    @Test
    public void test1() {
        Flux.create(sink -> {
            for (int i = 0; i < 10; i++) {
                sink.next(i);
            }
            System.out.println(Thread.currentThread().getName());
            sink.complete();
        }).subscribe(System.out::println);
    }

    @Test
    public void test2() {
        Flux.range(1, 100).buffer(20).subscribe(System.out::println);
        Flux.intervalMillis(100).bufferMillis(1001).take(2).toStream().forEach(System.out::println);
        Flux.range(1, 10).bufferUntil(i -> i % 2 == 0).subscribe(System.out::println);
        Flux.range(1, 10).bufferWhile(i -> i % 2 == 0).subscribe(System.out::println);
    }

}
