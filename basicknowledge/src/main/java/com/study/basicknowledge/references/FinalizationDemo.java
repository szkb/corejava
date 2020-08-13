package com.study.basicknowledge.references;

public class FinalizationDemo {

    public static void main(String[] args) {
        Cake c1 = new Cake(1);
        Cake c2 = new Cake(2);
        Cake c3 = new Cake(3);
        System.gc(); //调用Java垃圾收集器
    }
}

class Cake extends Object {

    private int id;

    public Cake(int id) {
        this.id = id;
        System.out.println("Cake Object " + id + "is created");
    }

    @Override
    protected void finalize() throws java.lang.Throwable {
        super.finalize();  //finalize的调用方法
        System.out.println("Cake Object " + id + "is disposed");
    }
}
