package com.study.basicknowledge.sourcecodestudy;

import java.util.ArrayList;

public class testClone {
    public static void main(String[] args) {
            ArrayList<Student> list=new ArrayList<Student>();
            //添加两个元素
            Student stJack=new Student("Jack", 13);
            Student stTom=new Student("Tom", 15);
            list.add(stJack);
            list.add(stTom);
            //深克隆
            ArrayList<Student> listCopy=new ArrayList<Student>();
            for (Student student : list) {
                listCopy.add(student.clone());
            }
            //移除且不修改
            listCopy.get(0).setAge(20);
            System.out.println(list);
            System.out.println(listCopy);
    }
}

class Student{
    private String name;
    private int age;
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
    public Student(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }
    @Override
    protected Student clone(){
        Student stuent = new Student(this.name,this.age); 
        return stuent; 
    }
       
}