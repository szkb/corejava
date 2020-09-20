package com.study.offer.array;

import java.util.Arrays;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/9/17 9:58
 */
public class Delete27 {

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                count++;
                for (int j = i + 1; j < nums.length; j++) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
                if (nums[i + 1] == val) {
                    i--;
                }
            }
        }
        return nums.length - count + 1;
    }

    public int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public int removeElement3(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    @Test
    public void test() {
        int[] ans = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement(ans, 2));
    }

}
