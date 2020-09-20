package com.study.concurrence.lock;

public class VolatileTest {

    private int a = 0;

    private int getA() {
        return a;
    }

    private void setA(int a) {
        this.a = a;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            VolatileTest volatileTest = new VolatileTest();
            Thread thread1 = new Thread(() -> {
                volatileTest.setA(10);
            });
            thread1.start();

            Thread thread2 = new Thread(() -> {
                System.out.print(volatileTest.getA() + " ");
            });
            thread2.start();
        }
    }
}
