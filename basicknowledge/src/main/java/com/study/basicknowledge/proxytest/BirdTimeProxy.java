package com.study.basicknowledge.proxytest;

/**
 * @author hangwu
 */
public class BirdTimeProxy implements Flyable {

    private Bird bird;

    public BirdTimeProxy(Bird bird) {
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
