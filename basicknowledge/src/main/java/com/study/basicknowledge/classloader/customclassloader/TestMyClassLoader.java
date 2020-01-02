package com.study.basicknowledge.classloader.customclassloader;

public class TestMyClassLoader {

    public static void main(String[] args) throws Exception {
        MyClassLoader mcl = new MyClassLoader(ClassLoader.getSystemClassLoader().getParent());
        Class<?> c1 = Class.forName("com.study.basicknowledge.classloader.customclassloader.Person", true, mcl);
        Object obj = c1.newInstance();
        System.out.println(obj);
        System.out.println(obj.getClass().getClassLoader());

        Class<?> c2 = Class.forName("com.study.basicknowledge.classloader.customclassloader.Person");
        Object obj2 = c2.newInstance();
        System.out.println(obj2.getClass().getClassLoader());
        System.out.println(obj.equals(obj2));
    }
}