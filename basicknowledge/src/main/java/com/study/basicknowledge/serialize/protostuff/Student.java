package com.study.basicknowledge.serialize.protostuff;

import io.protostuff.Tag;

/**
 * Created by zhangzh on 2017/2/20.
 */
public class Student {

//    @Tag(1)
    private String name;
//    @Tag(2)
    private String studentNo;
//    @Tag(3)
    private int age;
//    @Tag(4)
    private School school;

    // 关于@Tag,要么所有属性都有@Tag注解,要么都没有,不能一个类中只有部分属性有@Tag注解

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
            "name='" + name + '\'' +
            ", studentNo='" + studentNo + '\'' +
            ", age=" + age +
            ", school='" + school + '\'' +
            '}';
    }
}