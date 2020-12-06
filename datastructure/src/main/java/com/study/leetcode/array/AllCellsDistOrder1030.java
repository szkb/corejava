package com.study.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hangwu
 * @date 2020/11/17 9:24
 */
public class AllCellsDistOrder1030 {

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        if (!(r0 >= 0 && r0 < R && c0 >=0 && c0 < C)) {
            return null;
        }
        int[][] ans = new int[R * C][2];
        int k = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ans[k++] = new int[]{i, j};
            }
        }
        Arrays.sort(ans,
            Comparator.comparingInt(o -> Math.abs(o[0] - r0) + Math.abs(o[1] - c0)));
        return ans;
    }
}
