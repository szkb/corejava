package com.study.offer.sort;

import java.util.Arrays;
import java.util.List;

/**
 * Test TimSort
 * @author jiangmufeng
 * @date 2020-02-25 14:24
 **/
public class Main {
    public static void main(String[] args) {

        sort(1, 1, 1, 1, 1, 2, 1, 1, 1);
        sort(3, 2, 3, 2, 1, 31);
        sort(2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3);

        // exception
        sort(1, 2, 3, 2, 2, 3, 2, 3, 2, 2, 3, 2, 3, 3, 2, 2, 2, 2, 2, 2, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);

    }

    private static void sort(Integer... ints) {
        List<Integer> list = Arrays.asList(ints);
        list.sort((o1, o2) -> {
            if (o1 < o2) {
                return -1;
            } else {
                return 1;
            }
        });
        System.out.println(list);
    }
}