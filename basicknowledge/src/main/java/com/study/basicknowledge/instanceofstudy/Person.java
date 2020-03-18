package com.study.basicknowledge.instanceofstudy;

class Person {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "I'm a person.";
    }

    public void eat() {
    }

    public void speak() {
    }

}

class Boy extends Person {

    public String toString() {
        return "I'm a boy";
    }

    public void speak() {
    }

    public void fight() {
    }
}

class Girl extends Person {

    public String toString() {
        return "I'm a girl";
    }

    public void speak() {
    }

    public void sing() {
    }
}