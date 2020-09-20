package com.study.basicknowledge.basicjava.referencestudy;

class SuperClass {

    static {
        System.out.println("superclass init");
    }

    public static int value = 123;
}

class SubClass extends SuperClass {

    static {
        System.out.println("subclass init");
    }
}

public class PassiveReference {

    public static void main(String[] args) {
        System.out.println(SubClass.value);// 被动应用1  
        SubClass[] sca = new SubClass[10];// 被动引用2  
    }
}  
