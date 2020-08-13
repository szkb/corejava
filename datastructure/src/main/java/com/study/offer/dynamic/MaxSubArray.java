package com.study.offer.dynamic;

import java.util.Arrays;

/**
 * @author hangwu
 * @date 2020/8/11 8:54
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 每个数字组合前面的数字可获取的最大值
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum[i - 1] > 0) {
                sum[i] = sum[i - 1] + nums[i];
            } else {
                sum[i] = nums[i];
            }
        }

        Arrays.sort(sum);
        return sum[sum.length - 1];
    }

    public int maxSubArray2(int[] nums) {
        int max = nums[0];
        int former = 0;//用于记录dp[i-1]的值，对于dp[0]而言，其前面的dp[-1]=0
        int cur = nums[0];//用于记录dp[i]的值
        for (int num : nums) {
            cur = num;
            if (former > 0) {
                cur += former;
            }
            if (cur > max) {
                max = cur;
            }
            former = cur;
        }
        return max;
    }
}
