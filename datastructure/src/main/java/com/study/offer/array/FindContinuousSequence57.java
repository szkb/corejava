package com.study.offer.array;

import java.util.*;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/8/14 8:42
 */
public class FindContinuousSequence57 {

    public int[][] findContinuousSequence(int target) {
        int[] factor = new int[256];
        int k = 0;
        factor[k] = 2;
        for (int i = 3; i < Math.sqrt(target); i += 2) {
            if (target % i == 0) {
                factor[++k] = i;
            }
        }
        int[][] ans = new int[k][];

        for (int j = 0; j < k; j++) {
            if (j == 0) {
                ans[0][0] = target / 2;
                ans[0][1] = target / 2 + 1;
            } else {
                int index = 0;
                int middle = target / factor[j];
                int divide = (factor[j] - 1) / 2;
                for (int temp = middle - divide; temp < middle + temp; temp++) {
                    ans[j][index++] = temp;
                }
            }
        }
        return ans;
    }

    public int[][] findContinuousSequence2(int target) {
        int i = 1; // 滑动窗口的左边界
        int j = 1; // 滑动窗口的右边界
        int sum = 0; // 滑动窗口中数字的和
        List<int[]> res = new ArrayList<>();

        while (i <= target / 2) {
            if (sum < target) {
                // 右边界向右移动
                sum += j;
                j++;
            } else if (sum > target) {
                // 左边界向右移动
                sum -= i;
                i++;
            } else {
                // 记录结果
                int[] arr = new int[j-i];
                for (int k = i; k < j; k++) {
                    arr[k-i] = k;
                }
                res.add(arr);
                // 左边界向右移动
                sum -= i;
                i++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }

    @Test
    public void test() {
        System.out.println(Arrays.deepToString(findContinuousSequence2(15)));
    }
}
