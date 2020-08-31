package com.study.concurrence.completablefuture;

import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import lombok.Data;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/8/20 13:54
 */
public class CompletableFutureExample {

    @Data
    static class User {
        private String name;
    }

    @Test
    public void test() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            return 100;
        });
        CompletableFuture<String> f = future.thenApplyAsync(i -> i * 10).thenApply(i -> i.toString());

        System.out.println(f.get()); //"1000"
    }

    @Test
    public void test1() throws ExecutionException, InterruptedException {
        CompletableFuture<String> responseFuture = CompletableFuture.completedFuture("hello")
            .thenApply(this::convertToRequest)
            .thenCompose(this::filter)
            .thenApply(this::convertToResponse);

        System.out.println(responseFuture.get());

        SettableFuture<String> settableFuture = SettableFuture.create();
        responseFuture.thenAccept(settableFuture::set);

        System.out.println(settableFuture.get());

    }

    private String convertToResponse(User user) {
        return user.getName();
    }

    private CompletableFuture<User> filter(String item) {
        User user = new User();
        user.setName(item);
        return CompletableFuture.completedFuture(user);
    }

    private String convertToRequest(String item) {
        return item + "world";
    }

}
