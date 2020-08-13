package com.study.offer.array;

/**
 * @author hangwu
 * @date 2020/8/11 8:40
 */
public class Exchange {

    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            if (nums[i] % 2 == 0 && nums[j] % 2 == 0) {
                j--;
            } else if (nums[i] % 2 != 0 && nums[j] % 2 != 0) {
                i++;
            } else if (nums[i] % 2 == 0 && nums[j] % 2 != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;

                i++;
                j--;
            } else {
                i++;
                j--;
            }
        }

        return nums;
    }
}
