package com.study.basicknowledge.rxjava.reactor;

import org.junit.Test;
import reactor.core.publisher.Flux;

/**
 * @author hangwu
 * @date 2020/7/1 16:06
 */
public class TakeTest {

    @Test
    public void test() {
        Flux.range(1, 1000).take(10).subscribe(System.out::println);
        Flux.range(1, 1000).takeLast(10).subscribe(System.out::println);
        Flux.range(1, 1000).takeWhile(i -> i < 10).subscribe(System.out::println);
        Flux.range(1, 1000).takeUntil(i -> i == 10).subscribe(System.out::println);
    }

}
