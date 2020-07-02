package com.study.basicknowledge.rxjava.reactor;

import org.junit.Test;
import reactor.core.publisher.Flux;

/**
 * @author hangwu
 * @date 2020/7/1 16:04
 */
public class ZipWithTest {

    @Test
    public void test() {
        Flux.just("a", "b")
            .zipWith(Flux.just("c", "d"))
            .subscribe(System.out::println);
        Flux.just("a", "b")
            .zipWith(Flux.just("c", "d"), (s1, s2) -> String.format("%s-%s", s1, s2))
            .subscribe(System.out::println);
    }

}
