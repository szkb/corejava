package com.study.concurrence.concurrencytoolkit.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    private static final int THREAD_COUNT = 30;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore s = new Semaphore(10);
    
    public static void main(String[] args) {
        for(int i=0; i<THREAD_COUNT; i++){
            threadPool.execute(new MyThread(i, s));
        }
        threadPool.shutdown();
    }
    
}
class MyThread implements Runnable{
    int c = 0;
    Semaphore s;
    public MyThread(int c, Semaphore s) {
        this.c = c;
        this.s = s;
    }
    @Override
    public void run() {
        try {
            System.out.println(c + " begin:");
            s.acquire();
            System.out.println("saveDate=" + c);
            Thread.sleep(3000);
            s.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/*
0 begin:
1 begin:
saveDate=0
saveDate=1
2 begin:
saveDate=2
8 begin:
6 begin:
7 begin:
saveDate=7
5 begin:
saveDate=5
3 begin:
4 begin:
saveDate=3
11 begin:
saveDate=11
9 begin:
saveDate=8
saveDate=6
12 begin:
10 begin:
saveDate=4
16 begin:
20 begin:
14 begin:
19 begin:
15 begin:
13 begin:
25 begin:
29 begin:
27 begin:
23 begin:
17 begin:
21 begin:
28 begin:
24 begin:
22 begin:
18 begin:
26 begin:
//下面是3s之后
saveDate=9
saveDate=12
saveDate=10
saveDate=16
saveDate=20
saveDate=14
saveDate=19
saveDate=15
saveDate=13
saveDate=25
//下面是6s之后
saveDate=29
saveDate=27
saveDate=23
saveDate=17
saveDate=21
saveDate=28
saveDate=24
saveDate=22
saveDate=18
saveDate=26
*/