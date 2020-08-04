package com.study.concurrence.thread.creation;

/**
 * @author hangwu
 */
public class RunnableThreadTest implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 2) {
                RunnableThreadTest rtt = new RunnableThreadTest();
                new Thread(rtt, "新线程1").start();
                new Thread(rtt, "新线程2").start();
            }
        }
    }

}