package com.study.basicknowledge.basicjava.stream.reduce;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hangwu
 * @date 2020/11/14 13:30
 */
public class ReduceBenchMark {

    public static class User {
        private String name;
        private Integer age;
        private BigDecimal money;
        private Map<String, String> tag = new HashMap<>();


        public Map<String, String> getTag() {
            return tag;
        }

        public void setTag(Map<String, String> tag) {
            this.tag = tag;
        }

        public User() {

        }

        public User(String name, Integer age, BigDecimal money) {
            this.name = name;
            this.age = age;
            this.money = money;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public BigDecimal getMoney() {
            return money;
        }

        public void setMoney(BigDecimal money) {
            this.money = money;
        }

        @Override
        public String toString() {
            return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", money=" + money +
                ", tag=" + tag +
                '}';
        }
    }
}
