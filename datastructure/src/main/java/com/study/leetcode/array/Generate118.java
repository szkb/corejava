package com.study.leetcode.array;

import java.util.*;

/**
 * @author hangwu
 * @date 2020/12/6 9:22
 */
public class Generate118 {

    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> row1 = Arrays.asList(1);
        ans.add(row1);
        if (numRows == 1) {
            return ans;
        }

        List<Integer> row2 = Arrays.asList(1, 1);
        ans.add(row2);
        if (numRows == 2) {
            return ans;
        }

        for (int i = 3; i <= numRows; i++) {
            Integer[] temp = new Integer[i];
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    temp[j] = 1;
                } else {
                    temp[j] = ans.get(i - 2).get(j - 1) + ans.get(i - 2).get(j);
                }
            }
            ans.add(Arrays.asList(temp));
        }
        return ans;
    }
}
