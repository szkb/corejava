package com.study.leetcode.array;

/**
 * @author hangwu
 * @date 2020/11/4 9:39
 */
public class Insert57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] temp = new int[1][2];
        if (intervals == null || intervals.length == 0) {
            temp[0] = newInterval;
            return temp;
        }

        int start = 0;
        int end  = 0;
        int i = 0;
        boolean insert = true;
        int[][] number = new int[1][2];

        while (i < intervals.length && newInterval[1] > intervals[i][1]) {
            i++;
        }

        int j = i;

        if (newInterval[1] >= intervals[i][0]) {
            end = i;
            number[0][1] = intervals[i][1];
            insert = false;
        } else {
            end = i -1;
            number[0][1] = newInterval[1];
        }

        while (j >= 0 && newInterval[0] < intervals[j][0]) {
            j--;
        }

        if (newInterval[0] <= intervals[j][1]) {
            start = j;
            number[0][0] = intervals[j][0];
            insert = false;
        } else {
            start = j + 1;
            number[0][0] = newInterval[0];
        }

        int size = insert ? intervals.length + 1 : intervals.length - (end - start);
        int[][] ans = new int[size][2];

        for (int k = 0; k < start; k++) {
            ans[k] = intervals[k];
        }
        ans[start++] = number[0];

        for (int k = end + 1; k < intervals.length; k++) {
            ans[start++] = intervals[k];
        }

        return ans;
    }
}
