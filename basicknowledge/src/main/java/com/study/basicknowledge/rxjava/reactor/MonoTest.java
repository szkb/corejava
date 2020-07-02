package com.study.basicknowledge.rxjava.reactor;

import java.util.Optional;
import org.junit.Test;
import reactor.core.publisher.Mono;

/**
 * @author hangwu
 * @date 2020/7/1 16:01
 */
public class MonoTest {

    @Test
    public void test() {
        Mono.fromSupplier(() -> "Hello").subscribe(System.out::println);
        Mono.justOrEmpty(Optional.of("Hello")).subscribe(System.out::println);
        Mono.create(sink -> sink.success("Hello")).subscribe(System.out::println);
    }

}
