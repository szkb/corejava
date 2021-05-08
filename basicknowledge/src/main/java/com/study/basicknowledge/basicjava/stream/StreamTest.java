package com.study.basicknowledge.basicjava.stream;

import com.study.basicknowledge.basicjava.limit.Teacher;
import java.util.*;
import java.util.stream.Collectors;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/9/20 21:39
 */
public class StreamTest {

    static class Student {

        int classId;
        int scores;

        public Student(int classId, int scores) {
            this.classId = classId;
            this.scores = scores;
        }

        public int getClassId() {
            return classId;
        }

        public void setClassId(int classId) {
            this.classId = classId;
        }

        public int getScores() {
            return scores;
        }

        public void setScores(int scores) {
            this.scores = scores;
        }

        @Override
        public String toString() {
            return "Student{" +
                "classId=" + classId +
                ", scores=" + scores +
                '}';
        }
    }

    @Test
    public void test() {
        Student student = new Student(1, 100);
        Student student1 = new Student(1, 90);
        Student student2 = new Student(2, 90);
        Student student3 = new Student(2, 95);
        Student student4 = new Student(3, 85);
        Student student5 = new Student(3, 80);

        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        Map<Integer, List<Student>> studentMap =
            students.stream().collect(Collectors.groupingBy(Student::getClassId));

        List<Student> ans = new ArrayList<>();
        studentMap.forEach((key, value) -> {
            value.stream().min(Comparator.comparing(Student::getScores)).ifPresent(ans::add);
        });

        System.out.println(ans);

    }

    @Test
    public void test2() {
        Student student = new Student(1, 100);
        Student student1 = new Student(1, 90);
        Student student2 = new Student(2, 90);
        Student student3 = new Student(2, 95);
        Student student4 = new Student(3, 85);
        Student student5 = new Student(3, 80);

        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        Map<Integer, List<Student>> studentMap =
            students.stream().collect(Collectors.groupingBy(Student::getClassId));

        List<Student> ans = new ArrayList<>();
        studentMap.forEach((key, value) -> {
            value.stream().peek(item -> item.setScores(10000));
        });

        System.out.println(studentMap);

    }

    @Test
    public void test3() {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        ans.add(2);
        ans.add(3);

        String actualResult = ans.stream().filter(item -> item == 0).findFirst().map(String::valueOf)
            .orElse("1");

        System.out.println(actualResult);
    }

    @Test
    public void test4() {
        Teacher teacher = new Teacher();
    }

}
