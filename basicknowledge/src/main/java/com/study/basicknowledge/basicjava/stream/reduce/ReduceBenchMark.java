package com.study.basicknowledge.basicjava.stream.reduce;

/**
 * @author hangwu
 * @date 2020/11/14 13:30
 */
public class ReduceBenchMark {

    public static class User {
        private String name;
        private Integer age;

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
