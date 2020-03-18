package com.study.basicknowledge.instanceofstudy;

/**
 * @author hangwu
 * @date 2020/3/4 14:13
 */
public class Child extends Parent{

    public static void main(String[] args) {
        Parent child = new Child();

        Child3 child3 = (Child3) new Parent();
        if (child instanceof Parent) {
            System.out.println("yes");
        }

        Parent child2 = new Child2();
        ((Child2) child2).setAge("123");

        if (child2 instanceof Parent) {
            System.out.println("yes");
            System.out.println(((Child2) child2).getAge());
        }
    }

}
