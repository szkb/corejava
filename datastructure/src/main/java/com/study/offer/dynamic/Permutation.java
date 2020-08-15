package com.study.offer.dynamic;

import java.util.*;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/8/15 14:54
 */
public class Permutation {

    public String[] permutation(String s) {
        char[] arr = s.toCharArray();
        Set<String> ans = new HashSet<>();
        f(ans, 0, arr);
        return ans.toArray(new String[ans.size()]);

    }

    //与其说是递归，不如说是树形遍历
    void f(Set ans, int position, char[] arr) {
        if (position == arr.length) {
            ans.add(String.valueOf(arr));
        }
        for (int i = position; i < arr.length; i++) {
            // 对数组swap的过程就是排列的过程，
            // 在for循环中swap，每次swap后，就会有新的元素排在第一位
            swap(arr, position, i);
            f(ans, position + 1, arr);
            swap(arr, position, i);
        }
    }

    void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(permutation("abc")));
    }

}
