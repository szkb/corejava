package com.study.concurrence.concurrencytoolkit.exchange;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerTest {
    /*
    * Exchanger允许在并发任务之间交换数据。具体来说，则是允许两个线程之间定义同步点，当两个线程都到达同步点时，交换数据
    * 结构。因此第一个线程的数据结构进入到第二个数据结构中，第二个线程的数据结构进入第一个线程中。
    *
    * */

    private static final Exchanger<String> exgr = new Exchanger<String>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String a = "银行流水A";
                try {
                    String b = exgr.exchange(a);
                    System.out.println("a中数据交换完毕.a=" + a + ";b=" + b);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String b = "银行流水B";
                try {
                    Thread.sleep(3000);
                    String a = exgr.exchange(b);//传递b数据并获得a的数据
                    System.out.println("b中数据交换完毕.a=" + a + ";b=" + b);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
/*
b中数据交换完毕.a=银行流水A;b=银行流水B
a中数据交换完毕.a=银行流水A;b=银行流水B
*/