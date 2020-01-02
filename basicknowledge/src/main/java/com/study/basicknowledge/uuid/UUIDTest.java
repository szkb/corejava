package com.study.basicknowledge.uuid;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2019/12/30 17:05
 */
class Student {
    private String name;
    private int age;
    private List<String> tokenNumberList;

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
        return "Student{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", tokenNumberList=" + tokenNumberList +
            '}';
    }

    public List<String> getTokenNumberList() {
        return tokenNumberList;
    }

    public void setTokenNumberList(List<String> tokenNumberList) {
        this.tokenNumberList = tokenNumberList;
    }
}

public class UUIDTest {

    @Test
    public void test() {
        System.out.println(UUID.randomUUID().toString());
    }

    @Test
    public void test1() {
        Student student = new Student();
//        student.setName(null);
        student.setAge(26);
        student.setTokenNumberList(new ArrayList<>(0));
//        student.setTokenNumberList(null);

        String jsonString = JSON.toJSONString(student);
        System.out.println(jsonString);

        Student student1 = JSON.parseObject(jsonString, Student.class);
        System.out.println(student1);

    }

    @Test
    public void test2() {
        List<String> temp = new ArrayList<>(0);
        String jsonString = JSON.toJSONString(temp);
        System.out.println(jsonString);

        List<String> temp1 = null;
        String jsonString1 = JSON.toJSONString(temp1);
        System.out.println(jsonString1);

    }
}
