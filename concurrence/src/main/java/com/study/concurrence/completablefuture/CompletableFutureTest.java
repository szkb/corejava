package com.study.concurrence.completablefuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/4/3 11:08
 */
public class CompletableFutureTest {

    @Test
    public void base01() throws Exception {
        /**
         * CompletableFuture的静态方法supplyAsync(Supplier<U> supplier)返回一个带有
         * ForkJoinPool 线程池的 CompletableFuture 对象.
         * CompletableFuture 对象可以调用get方法,这样会使线程阻塞.
         * Supplier<T> 接口是一个 () -> T 的函数
         */

        CompletableFuture future = CompletableFuture.supplyAsync(this::getRandomInt);
        System.out.println("1");
        System.out.println(future.get());
    }

    private int getRandomInt() {
//        System.out.println("2");
        return 1;
    }

    @Test
    public void base02() throws ExecutionException, InterruptedException {
        /**
         * CompletableFuture的静态方法supplyAsync(Supplier<U> supplier, Executor executor)
         * 返回一个带有自定义的线程池的CompletableFuture对象.
         */
        CompletableFuture future = CompletableFuture.supplyAsync(this::getRandomInt, Executors.newCachedThreadPool());
        System.out.println(future.get());
    }

    @Test
    public void base03() throws ExecutionException, InterruptedException {
        /**
         * CompletableFuture的静态方法 runAsync(Runnable runnable)返回一个带有
         * ForkJoinPool线程池的CompletableFuture对象.但是这个对象没有返回值
         */
        CompletableFuture future = CompletableFuture.runAsync(getRandomIntRunnable());
        Assert.assertEquals(null, future.get());
    }

    private Runnable getRandomIntRunnable() {
        return () -> {
            System.out.println("hello world");
        };
    }

    @Test
    public void base04() throws ExecutionException, InterruptedException {
        /**
         * CompletableFuture的静态方法 runAsync(Runnable runnable, Executor executor)
         * 返回一个带有自定义的线程池的CompletableFuture对象.但是这个对象没有返回值
         */
        CompletableFuture future = CompletableFuture.runAsync(getRandomIntRunnable(), Executors.newCachedThreadPool
        ());
        Assert.assertEquals(null, future.get());
    }

    @Test
    public void base06() throws ExecutionException, InterruptedException, TimeoutException {
        /**
         * get(long,TimeUnit) 方法阻塞并且等待返回结果,TimeUnit表示时间长度单位,最小是纳秒.
         * 当超时未返回信息的时候回抛出TimeoutException异常
         */
        CompletableFuture future = CompletableFuture.supplyAsync(this::getRandomInt);
        System.out.println(future.get(10, TimeUnit.MILLISECONDS));
    }

    @Test
    public void base07() throws ExecutionException, InterruptedException {
        /**
         * join 方法与 get 方法无基本差别
         */
        CompletableFuture future = CompletableFuture.supplyAsync(this::getRandomInt);
        System.out.println(future.join());
    }

    @Test
    public void base08() throws ExecutionException, InterruptedException {
        /**
         * getNow(obj) 方法立即返回结果,如果无结果就返回传入参数
         */
        CompletableFuture future = CompletableFuture.supplyAsync(this::getRandomInt);
        System.out.println(future.getNow("1bca"));
        System.out.println(future.get());
    }

    @Test
    public void base09() throws ExecutionException, InterruptedException {
        /**
         * complete 方法将future状态置为已完成,并且将参数注入,但如果这个future已经完成了,则
         * 不会产生任何变化
         */
        CompletableFuture future = CompletableFuture.supplyAsync(this::getRandomInt);
        future.complete("123");
        System.out.println(future.get());
        future.complete("345");
        System.out.println(future.get());
    }

    @Test
    public void base10() throws ExecutionException, InterruptedException {
        /**
         * completeExceptionally 方法将future状态置为已完成,并且将异常参数注入,
         * 并且在get的时候回获取这个异常
         * 但如果这个future已经完成了,则不会产生任何变化
         */
        CompletableFuture future = CompletableFuture.supplyAsync(this::getRandomInt);
        future.complete("123");
        System.out.println(future.get());
        future.complete("345");
        System.out.println(future.get());
        future.completeExceptionally(new Exception("abc"));
        System.out.println(future.get());
        future = CompletableFuture.supplyAsync(this::getRandomInt);
        future.completeExceptionally(new Exception("abc"));
        System.out.println(future.get());
    }

    @Test
    public void base20() throws ExecutionException, InterruptedException {
        /**
         * cancel 方法会取消 future 对象,并且置入一个 CancellationException
         */
        CompletableFuture future = CompletableFuture.supplyAsync(this::getRandomInt);
        System.out.println("done?"+future.isDone()+" cancel?"+future.isCancelled()+" exp?"+future.isCompletedExceptionally());
//        future.get();
        future.cancel(false);
        System.out.println("done?"+future.isDone()+" cancel?"+future.isCancelled()+" exp?"+future.isCompletedExceptionally());
        future.get();
    }

    @Test
    public void base11() throws ExecutionException, InterruptedException {
        /**
         * thenApplyAsync 方法会在前一个future *已完成* 的情况下开始执行方法中的lambda函数.
         * 并且返回一个新的future对象.
         * 该方法的传入一个 T -> U 的Function<T,U>, 并且返回 <U> 的CompletableFuture
         * 方法的参数表示是否需要传入一个线程池来开启新线程操作
         */
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(this::getRandomInt);
        System.out.println(System.currentTimeMillis());
        CompletableFuture<Integer> newFuture = future.thenApplyAsync(x -> {
            System.out.println(System.currentTimeMillis());
            return x * 100;
        });
        //获取两个future的结果
        System.out.println(future.get());
        System.out.println(newFuture.get());
    }

    @Test
    public void base12() throws ExecutionException, InterruptedException {
        /**
         * thenAcceptAsync 传入一个 Consumer 函数来完成.
         * 其它与 thenApplyAsync 相同
         * thenRunAsync 方法与此方法相同,但是传入是一个 Runnable
         */
        CompletableFuture future = CompletableFuture.supplyAsync(this::getRandomInt);
        CompletableFuture future1 = future.thenAcceptAsync(num -> {
            System.out.println(num);
        });
        future.get();
        System.out.println(future1.get());
    }

    @Test
    public void base13() throws ExecutionException, InterruptedException {
        /**
         * thenCombine 针对两个 future 进行操作.
         * 需要传入另一个 future 以及 一个 BiFunction<T,U,V> ,返回一个新的 future.
         */
        CompletableFuture<Integer> a = CompletableFuture.supplyAsync(this::getRandomInt);
        CompletableFuture<Integer> b = CompletableFuture.supplyAsync(() -> getRandomInt(3000));
        CompletableFuture c = a.thenCombine(b,(a1,b1) -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return  a1+b1;
        });
        System.out.println("a:"+a.get());
        System.out.println("b:"+b.get());
        System.out.println("c:"+c.get());
    }

    private Integer getRandomInt(Integer l) {
        return l;
    }

    @Test
    public void base14() throws ExecutionException, InterruptedException {
        /**
         * thenAcceptBoth 同时等待两个 future ,并且返回一个空的CompletableFuture,
         * Bi lambda 的两个参数分别接受的两个参数 第一个接受 this , 第二个接受第一个参数返回
         * runAfterBothAsync 方法和此方法相同,但是传入参数为 Runnable
         */
        CompletableFuture<Integer> a = CompletableFuture.supplyAsync(this::getRandomInt);
        CompletableFuture<Integer> b = CompletableFuture.supplyAsync(() -> getRandomInt(3000));
        a.thenAcceptBoth(b,(a1,b1) -> {
            System.out.println(a1);
            System.out.println(b1);
        });
        a.get();
        b.get();
    }

    @Test
    public void base15() throws ExecutionException, InterruptedException {
        /**
         * applyToEitherAsync 同时等待两个 future 同时完成 ,并且对第二个返回的 future 进行处理.
         * acceptEitherAsync 同时等待两个 future ,并且对第二个 future 的返回值进行消费.
         * runAfterEitherAsync 和 acceptEitherAsync 相同,并且传入 Runnable
         */
        CompletableFuture<Integer> a = CompletableFuture.supplyAsync(this::getRandomInt);
        CompletableFuture<Integer> b = CompletableFuture.supplyAsync(() -> getRandomInt(3000));
        CompletableFuture c = a.applyToEitherAsync(b,b1 -> {
            return b1*100;
        });
        a.get();
        b.get();
        System.out.println(c.get());
    }

    @Test
    public void base16() throws ExecutionException, InterruptedException {
        /**
         * whenComplete 接受 future 中抛出的异常和返回, 方法中可以抛出 RuntimeException .不可以抛出 Exception.
         * 在返回或者异常之后对返回值进行消费,或者返回正常结果
         * handleAsync 接受一个 function<返回值,异常,结果> 并在返回之后对 future 的相应进行处理
         */
        CompletableFuture future = CompletableFuture.supplyAsync(() -> {
            int a = new Random().nextInt(10);
            if(a > 5){
                throw new RuntimeException("too big");
            }
            return a;
        });
        future.whenComplete((res,ex) -> {
            System.out.println("result:"+res+", ex:"+ex);
        });
    }

    @Test
    public void base17() throws ExecutionException, InterruptedException {
        /**
         * exceptionally 会返回一个新的 CompletableFuture , 该方法会阻塞,
         * 当原有方法发生了异常,exceptionally 的 function 会执行.
         * 当原有方法正常完成,则会返回一个相同的结果
         */
        CompletableFuture future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            throw new RuntimeException("except");
        });
        CompletableFuture exfuture = future.exceptionally(ex -> {return new Exception(((RuntimeException) ex).getMessage());});
        System.out.println(exfuture.get());
    }

    @Test
    public void base21() throws ExecutionException, InterruptedException {
        /**
         * thenCompose 接受一个 Function 并且返回一个新的 CompletableFuture 对象.
         * 所收集到的对象是没有嵌套的 CompletableFuture 对象. 类似 flatMap 的效果
         */
        CompletableFuture future = CompletableFuture.supplyAsync(this::getRandomInt);
        CompletableFuture newFuture = future.thenCompose(num -> {
            return CompletableFuture.completedFuture(num);
        });
        System.out.println(newFuture.get());
    }

    @Test
    public void base18() throws ExecutionException, InterruptedException {
        /**
         * CompletableFuture.allOf 静态方法,传入多个独立的 future ,并且返回一个新的CompletableFuture
         * 当所有的 future 完成时,新的 future 同时完成,
         * 不能传入空值
         * 当某个方法出现了异常时,新 future 会在所有 future 完成的时候完成,并且包含一个异常.
         */
        CompletableFuture<Integer> a = CompletableFuture.supplyAsync(this::getRandomInt);
        CompletableFuture<Integer> b = CompletableFuture.supplyAsync(() -> getRandomInt(3000));
        CompletableFuture ex = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("runtime");
        });

        System.out.println("is a done?" +a.isDone()+". Is b done?"+b.isDone()+".");
        CompletableFuture future = CompletableFuture.allOf(a,b,ex);
        System.out.println("is a done?" +a.isDone()+". Is b done?"+b.isDone()+".");
        CompletableFuture exFuture = future.exceptionally( exp -> {
            return ((RuntimeException) exp).getMessage();
        });
        System.out.println("done?"+future.isDone()+" cancel?"+future.isCancelled()+" exp?"+future.isCompletedExceptionally());
        System.out.println("is a done?" +a.isDone()+". Is b done?"+b.isDone()+".");
        System.out.println(exFuture.get());
        System.out.println("done?"+future.isDone()+" cancel?"+future.isCancelled()+" exp?"+future.isCompletedExceptionally());
    }

    @Test
    public void base19() throws ExecutionException, InterruptedException {
        /**
         * CompletableFuture.anyOf 静态方法,传入多个独立的 future ,并且返回一个新的CompletableFuture
         * 当任何一个方法完成时,新的 future 完成,并且返回该值
         * 不能传入空值
         * 当某个方法出现了异常时,新 future 会立刻完成,并且携带一个异常
         */
        CompletableFuture<Integer> a = CompletableFuture.supplyAsync(this::getRandomInt);
        CompletableFuture<Integer> b = CompletableFuture.supplyAsync(() -> getRandomInt(3000));
        CompletableFuture ex = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("runtime");
        });

        System.out.println("is a done?" +a.isDone()+". Is b done?"+b.isDone()+".");
        CompletableFuture future = CompletableFuture.anyOf(a,b,ex);
        System.out.println("is a done?" +a.isDone()+". Is b done?"+b.isDone()+".");
        CompletableFuture exFuture = future.exceptionally( exp -> {
            return ((RuntimeException) exp).getMessage();
        });
        System.out.println("done?"+future.isDone()+" cancel?"+future.isCancelled()+" exp?"+future.isCompletedExceptionally());
        System.out.println("is a done?" +a.isDone()+". Is b done?"+b.isDone()+".");
        System.out.println(exFuture.get());
        System.out.println("done?"+future.isDone()+" cancel?"+future.isCancelled()+" exp?"+future.isCompletedExceptionally());
    }

    @Test
    public void base22() throws ExecutionException, InterruptedException {
        /**
         * completedFuture 方法是能够直接将值放入 future 对象,常用于测试
         * CompletableFuture可以嵌套
         */
        CompletableFuture future = CompletableFuture.completedFuture(1);
        CompletableFuture future1 = CompletableFuture.completedFuture(future);
        CompletableFuture future2 = CompletableFuture.completedFuture(future1);
        System.out.println(future2.get());
    }
}
