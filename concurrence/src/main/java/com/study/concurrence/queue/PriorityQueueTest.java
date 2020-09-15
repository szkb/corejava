package com.study.concurrence.queue;

import java.util.*;
import org.junit.Test;

public class PriorityQueueTest {

    public static void main(String[] args) {
        Queue<Integer> queue1 = new PriorityQueue<>();
        queue1.add(2);
        queue1.add(1);
        queue1.add(3);

        while (!queue1.isEmpty()) {
            Integer i = queue1.poll();
            System.out.println(i);
        }

        Comparator<Student> comparator = Comparator.comparingInt(o -> o.id);

        Queue<Student> queue2 = new PriorityQueue<>(comparator);
        queue2.add(new Student(2, "B"));
        queue2.add(new Student(1, "A"));
        queue2.add(new Student(3, "C"));

        while (!queue2.isEmpty()) {
            Student s = queue2.poll();
            System.out.println(s.toString());
        }
    }

    public static class Student {

        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String toString() {
            return id + "-" + name;
        }
    }

    @Test
    public void test() {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(2);
        queue.add(1);
        queue.add(3);

        while (!queue.isEmpty()) {
            Integer i = queue.poll();
            System.out.println(i);
        }
    }
}