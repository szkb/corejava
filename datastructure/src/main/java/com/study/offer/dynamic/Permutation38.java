package com.study.offer.dynamic;

import java.util.*;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/8/15 14:54
 */
public class Permutation38 {

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

    List<String> res = new LinkedList<>();
    char[] c;

    public String[] permutation2(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    void dfs(int x) {
        if (x == c.length - 1) {
            res.add(String.valueOf(c)); // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])) {
                continue; // 重复，因此剪枝
            }
            set.add(c[i]);
            swap(i, x); // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1); // 开启固定第 x + 1 位字符
            swap(i, x); // 恢复交换
        }
    }

    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(permutation("abc")));
    }

    @Test
    public void test2() {
        System.out.println(Arrays.toString(permutation2("abb")));
    }


}
