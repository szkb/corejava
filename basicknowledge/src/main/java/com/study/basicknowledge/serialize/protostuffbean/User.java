package com.study.basicknowledge.serialize.protostuffbean;

import io.protostuff.Tag;

class User {

    @Tag(1)
    private String name;

    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "User{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
    }
}

class Group {

    @Tag(1)
    private String id;

    @Tag(2)
    private String name;

    @Tag(3)
    private User user;

//    public Group(String id, String name, User user) {
//        this.id = id;
//        this.name = name;
//        this.user = user;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Group{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", user=" + user +
            '}';
    }
}