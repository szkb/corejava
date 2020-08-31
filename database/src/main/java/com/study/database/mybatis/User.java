package com.study.database.mybatis;

/**
 * @author gacl users表所对应的实体类
 */
public class User {
    //实体类的属性和表的字段名称一一对应
    private int id;
    private String user_name;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + user_name + ", age=" + age + "]";
    }
}