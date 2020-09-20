package com.study.basicknowledge.basicjava.function;

/**
 * @author hangwu
 * @date 2020/4/3 11:19
 */
public class Student {

    private String name = "KOBE";

    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
