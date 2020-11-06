package com.study.leetcode.array;

import java.util.*;

/**
 * @author hangwu
 * @date 2020/10/31 15:47
 */
public class RandomizedCollection381 {

    List<Integer> content = new ArrayList<>();

    /** Initialize your data structure here. */
    public RandomizedCollection381() {

    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (content.contains(val)) {
            content.add(val);
            return true;
        }
        content.add(val);
        return false;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        return content.remove(Integer.valueOf(val));
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        Random random = new Random();
        return content.get(random.nextInt(content.size()));
    }
}
