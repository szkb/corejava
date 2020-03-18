package com.study.basicknowledge.rxjava;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author hangwu
 * @date 2020/3/18 13:58
 */
public class Program {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        CompletableFuture<Integer> resultFuture = new CompletableFuture<>();
        mockCompleteResult(resultFuture);
        resultFuture.thenApply(Program::step1).thenAcceptAsync(Program::step2);
        Integer doneResult = resultFuture.get();
        printStep("step Done", doneResult);
        long end = System.currentTimeMillis();
        System.out.println("used time: " + TimeUnit.MILLISECONDS.toSeconds(end - start));
    }

    private static Integer step1(Integer result) {
        System.out.println(result);
        printStep("step1", 6);
        return result * 10;
    }

    private static void step2(Integer result) {
        System.out.println(result);
        printStep("step2", 5);
    }

    private static void printStep(String name, int sleepSeconds) {
        try {
            System.out
                .println(name + " Thread id " + Thread.currentThread().getId() + " sleep seconds " + sleepSeconds);
            Thread.sleep(sleepSeconds * 1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void mockCompleteResult(CompletableFuture<Integer> resultFuture) throws Exception {
        printStep("mock rpc", 2);
        resultFuture.complete(5);
    }
}
