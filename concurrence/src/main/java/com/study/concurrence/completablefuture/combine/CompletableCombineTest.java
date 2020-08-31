package com.study.concurrence.completablefuture.combine;

import java.util.concurrent.CompletableFuture;

public class CompletableCombineTest {

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        CompletableFuture<Integer> oddNumber = CompletableFuture.supplyAsync(new OddCombine());
        CompletableFuture<Integer> evenNumber = CompletableFuture.supplyAsync(new EvenCombine());
        CompletableFuture<Integer> resultFuture = oddNumber.thenCombine(evenNumber, Integer::sum);
        System.out.println(resultFuture.get());
        System.out.println("0.开始了：" + (System.currentTimeMillis() - startTime) + "毫秒");
    }
}
