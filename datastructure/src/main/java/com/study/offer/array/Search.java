package com.study.offer.array;

/**
 * @author hangwu
 * @date 2020/8/17 9:14
 */
public class Search {

    int cnt = 0;

    public int search(int[] nums, int target) {
        // 初始化low = 0, high = nums.length - 1
        helper(nums, target, 0, nums.length - 1);
        return cnt;
    }

    // 根据算法设计分3种情况
    public void helper(int[] nums, int target, int low, int high) {
        if (low <= high) {
            int mid = (high + low) / 2;
            if (nums[mid] == target) {
                cnt++;      // 计数一次
                helper(nums, target, low, mid - 1);
                helper(nums, target, mid + 1, high);
            } else if (nums[mid] > target) {
                helper(nums, target, low, mid - 1);
            } else {
                helper(nums, target, mid + 1, high);
            }
        }
    }
}
