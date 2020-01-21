package com.study.basicknowledge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;
import org.springframework.util.CollectionUtils;

/**
 * @author hangwu
 * @date 2019/12/23 14:18
 */
public class Test {

    private static volatile boolean test1 = false;

    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        AtomicBoolean test = new AtomicBoolean(false);

        integerList.forEach(item -> {
            if (item == 2) {
                test.set(true);
                test1 = true;
            }

        });

        test.set(false);
        System.out.println(test);
        System.out.println(test1);
    }


    @org.junit.Test
    public void workaroundSingleThread() {
        int[] holder = new int[]{2};
        Runnable runnable = () -> System.out.println(IntStream
            .of(1, 2, 3)
            .map(val -> val + holder[0])
            .sum());

//        new Thread(runnable).start();

        // simulating some processing
//        try {
//            Thread.sleep(3 * 1000L);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        holder[0] = 0;
    }

    @org.junit.Test
    public void test2() {
        Student student = new Student();
        student.setUniversity(new University());

        if (CollectionUtils.isEmpty(student.getUniversity().getName())
            || student.getUniversity().getName().get(0) == null) {
            System.out.println("hello");
        }
    }
}

class Student {

    private String name;
    private int age;

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

    private University university;

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}

class University {

    private List<String> name;

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }
}
