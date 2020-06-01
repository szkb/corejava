package com.study.basicknowledge.proxytest;

/**
 * @author hangwu
 */
public class Bird3 implements Flyable {
    private Bird bird;

    public Bird3(Bird bird) {
        this.bird = bird;
    }

    @Override
    public void fly() {
        long start = System.currentTimeMillis();

        bird.fly();

        long end = System.currentTimeMillis();
        System.out.println("Fly time = " + (end - start));
    }
}
