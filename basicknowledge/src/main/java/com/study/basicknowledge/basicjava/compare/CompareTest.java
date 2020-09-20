package com.study.basicknowledge.basicjava.compare;

import java.util.*;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/9/18 17:02
 */
public class CompareTest {

    class Student {

        private int age;

        private String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
        }
    }

    @Test
    public void test() {

        List<Student> studentList = new ArrayList<>();

        Student student = new Student();
        student.setAge(29);

        Student student2 = new Student();
        student2.setAge(28);

        studentList.add(student);
        studentList.add(student2);

        studentList.stream().min(Comparator.comparing(Student::getAge))
            .ifPresent(item -> item.setName("hello"));

        System.out.println(studentList);
    }
}
