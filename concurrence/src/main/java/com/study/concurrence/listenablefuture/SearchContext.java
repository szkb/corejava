package com.study.concurrence.listenablefuture;

/**
 * @author hangwu
 * @date 2021/8/17 17:16
 */
public class SearchContext {

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
        return "SearchContext{" +
            "name='" + name + '\'' +
            ", age='" + age + '\'' +
            '}';
    }
}
