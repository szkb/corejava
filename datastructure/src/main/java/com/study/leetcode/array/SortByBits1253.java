package com.study.leetcode.array;

import java.util.*;
import java.util.Map.Entry;

/**
 * @author hangwu
 * @date 2020/11/6 9:36
 */
public class SortByBits1253 {

    class Bits {
        private Integer number;
        private Integer count;

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }
    }

    public int[] sortByBits(int[] arr) {
        Map<Integer, Integer> bitsNumber = getBitsNumber(arr);

        return bitsNumber.entrySet().stream().sorted((o1, o2) -> {

            if (!o1.getValue().equals(o2.getValue())) {
                return o1.getValue().compareTo(o2.getValue());
            }

            return o1.getKey().compareTo(o2.getKey());
        }).mapToInt(Entry::getKey).toArray();
    }

    private Map<Integer, Integer> getBitsNumber(int[] arr) {
        Map<Integer, Integer> bitsNumber = new HashMap<>(arr.length);
        for (int number : arr) {
            int count = getCount(number);
            bitsNumber.put(number, count);
        }
        return bitsNumber;
    }

    private int getCount(int number) {
        int count = 0;
        while (number != 0) {
            if (number % 2 == 1) {
                count++;
            }
            number = number / 2;
        }
        return count;
    }
}
