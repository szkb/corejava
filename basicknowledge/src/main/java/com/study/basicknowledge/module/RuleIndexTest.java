package com.study.basicknowledge.module;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/9/27 14:15
 */
public class RuleIndexTest {

    static class User {
        private String name;
        private String age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
        }
    }
    private CascadeIndexer<User> ruleIndexer = new CascadeIndexer<>(StringUtils.EMPTY, ",", true);

    @Test
    public void test() {
        User user = new User();
        user.setName("kobe");
        user.setAge("27");

        User user1 = new User();
        user1.setName("Jordan");
        user1.setAge("27");
        ruleIndexer.add(user, "name", user.getName(), "age", user.getAge());
        ruleIndexer.add(user1, "name", user1.getName(), "age", user1.getAge());


        System.out.println(ruleIndexer.find("age", "27"));
    }

}
