package com.study.basicknowledge.basicjava.classloader;

public class LoaderTest {
  
    public static void main(String[] args) {  
        try {  
            System.out.println(ClassLoader.getSystemClassLoader());  
            System.out.println(ClassLoader.getSystemClassLoader().getParent());  
            System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}/* Output: 
        sun.misc.Launcher$AppClassLoader@6d06d69c  
        sun.misc.Launcher$ExtClassLoader@70dea4e  
        null  
 *///:~
