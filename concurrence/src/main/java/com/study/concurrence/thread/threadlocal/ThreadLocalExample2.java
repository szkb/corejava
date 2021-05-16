package com.study.concurrence.thread.threadlocal;

/**
 * @author hangwu
 * @date 2021/5/13 15:36
 */
public class ThreadLocalExample2 {

    public static void main(String[] args) {
        Computer computer = new Computer("lianxiang", "5000");
//        Computer computer1 = computer;
        new Thread(() -> {
            ThreadLocal<Computer> computerThreadLocal1 = new ThreadLocal<>();
            computerThreadLocal1.set(computer);
            System.out.println(computerThreadLocal1.get());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ThreadLocal<Computer> computerThreadLocal = new ThreadLocal<>();
            computerThreadLocal.set(computer);
            System.out.println(computer);
            System.out.println(computerThreadLocal.get());
        }).start();
        computer.setName(null);
        System.out.println(computer);

    }

}
