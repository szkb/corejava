package com.study.basicknowledge.referencestudy;

class ConstClass {
    static {  
        System.out.println("ConstClass init");  
    }  
    public static final String HELLOWORLD = "hello world";  
}  
  
public class FinalNotInit {
    public static void main(String[] args) {  
        System.out.println(ConstClass.HELLOWORLD);// 调用类常量  
    }  
}  
