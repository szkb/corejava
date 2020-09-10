package com.study.concurrence.completablefuture.compose;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/8/20 17:02
 */
public class ComposeTest {

    @Test
    public void test() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            return 100;
        });
        CompletableFuture<String> f =  future.thenCompose( i -> {
            return CompletableFuture.supplyAsync(() -> {
                return (i * 10) + "hello";
            });
        });
        System.out.println(f.get()); //1000
    }

}
