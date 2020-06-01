package com.study.basicknowledge.proxytest;

import java.util.Random;

/**
 * @author hangwu
 */
public class Bird implements Flyable {

    @Override
    public void fly() {
        System.out.println("Bird is flying...");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
