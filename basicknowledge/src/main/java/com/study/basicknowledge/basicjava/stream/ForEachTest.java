package com.study.basicknowledge.basicjava.stream;

import com.study.basicknowledge.basicjava.annotation.User;
import com.study.basicknowledge.basicjava.interfaceTest.defaulttest.A;
import com.study.basicknowledge.basicjava.stream.StreamTest.Student;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/12/16 18:17
 */
public class ForEachTest {

    class Apple {
        private String name;
        private int price;

        public Apple(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Apple{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
        }
    }

    @Test
    public void test() {
        List<Student> ans = new ArrayList<>();
        ans.add(new Student(1, 2));
        ans.add(new Student(2, 2));

        ans.forEach(student -> {
            switch (student.getClassId()) {
                case 1:
                    System.out.println("hello");
                    break;
                case 2:
                    System.out.println("world");
                    break;
                default:
                    break;
            }
        });
    }

    @Test
    public void test1() {
        List<Apple> ans = new ArrayList<>();
        ans.add(new Apple("iphone", 1000));
        ans.add(new Apple("iphone", 2000));
        ans.add(new Apple("iphone2", 2000));
        ans.add(new Apple("iphone2", 3000));
        ans.add(new Apple("iphone3", 2000));
       ans.stream().collect(Collectors.groupingBy(Apple::getName,
            Collectors.minBy(Comparator.comparing(Apple::getPrice)))).values().stream().map(Optional::get)
        .sorted(Comparator.comparing(Apple::getPrice)).collect(Collectors.toList()).forEach(System.out::println);
    }

}
