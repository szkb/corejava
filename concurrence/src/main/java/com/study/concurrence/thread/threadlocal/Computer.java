package com.study.concurrence.thread.threadlocal;

public class Computer {

    private String name;
    private String price;

    public Computer(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Computer{" +
            "name='" + name + '\'' +
            ", price='" + price + '\'' +
            '}';
    }
}