package com.study.basicknowledge.proxytest;

/**
 * @author hangwu
 */
public class BirdLogProxy implements Flyable {

    private Flyable flyable;

    public BirdLogProxy(Flyable flyable) {
        this.flyable = flyable;
    }

    @Override
    public void fly() {
        System.out.println("Bird fly start...");

        flyable.fly();

        System.out.println("Bird fly end...");
    }

    public static void main(String[] args) {
        Bird bird = new Bird();
        BirdLogProxy p1 = new BirdLogProxy(bird);
        p1.fly();
    }
}
