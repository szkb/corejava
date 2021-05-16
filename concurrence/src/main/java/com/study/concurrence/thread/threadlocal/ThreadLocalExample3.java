package com.study.concurrence.thread.threadlocal;

/**
 * @author hangwu
 * @date 2021/5/13 16:01
 */
public class ThreadLocalExample3 {
    public static final Object object = new Object();

    public static void main(String[] args) {
        Computer computer = new Computer("lianxiang", "5000");
//        Computer computer1 = computer;

        new Thread(() -> {
            synchronized (object) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getComputer(computer));
            }
        }).start();

        synchronized (object) {
            if (computer.getName() != null) {
                computer.setName(null);
                System.out.println("****");
                System.out.println(computer);
            }
        }
        System.out.println(computer);

    }

    private static Computer getComputer(Computer computer) {
        return computer;
    }

}
