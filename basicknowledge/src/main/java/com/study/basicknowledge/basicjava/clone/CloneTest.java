package com.study.basicknowledge.basicjava.clone;

import lombok.Data;

/**
 * @author hangwu
 * @date 2021/11/11 14:16
 */
public class CloneTest {

    @Data
    static class Child implements Cloneable{
        public String name;
        public int age;

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    @Data
    static class Father implements Cloneable {
        public String name;
        public int age;
        public Child child;

        @Override
        protected Object clone() throws CloneNotSupportedException {
            Father cloneFather = (Father) super.clone();
            cloneFather.child = (Child) this.child.clone();
            return cloneFather;
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Father father = new Father();
        father.setName("hello");

        Child child = new Child();
        child.setName("world");
        father.setChild(child);

        Father ans = (Father) father.clone();
        System.out.println(ans.getChild());
        father.getChild().setName("hello world");
        System.out.println(ans.getChild());
    }

}
