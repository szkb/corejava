package com.study.concurrence.thread.creation;

/**
 * @author hangwu
 */
public class FirstThreadTest extends Thread {

    int i = 0;

    //重写run方法，run方法的方法体就是现场执行体
    @Override
    public void run() {
        for (; i < 5; i++) {
            System.out.println(getName() + "  " + i);

        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "  : " + i);
            if (i == 2) {
                new FirstThreadTest().start();
                new FirstThreadTest().start();
            }
        }
    }

}