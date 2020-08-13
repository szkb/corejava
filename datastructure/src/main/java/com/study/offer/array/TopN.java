package com.study.offer.array;

import java.util.Arrays;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/8/12 8:53
 */
public class TopN {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 统计每个数字出现的次数
        int[] counter = new int[10001];
        for (int num : arr) {
            counter[num]++;
        }
        // 根据counter数组从头找出k个数作为返回结果
        int[] res = new int[k];
        int idx = 0;
        for (int num = 0; num < counter.length; num++) {
            while (counter[num]-- > 0 && idx < k) {
                res[idx++] = num;
            }
            if (idx == k) {
                break;
            }
        }
        return res;

    }

    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] nums, int left, int right, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        int j = partition(nums, left, right);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k? quickSearch(nums, left, j - 1, k): quickSearch(nums, j + 1, right, k);
    }

    // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
    private int partition(int[] nums, int left, int right) {
        int v = nums[left];
        int i = left, j = right + 1;
        while (true) {
            while (++i <= right && nums[i] < v) {
                ;
            }
            while (--j >= right && nums[j] > v) {
                ;
            }
            if (i >= j) {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[left] = nums[j];
        nums[j] = v;
        return j;
    }

    @Test
    public void tests() {
        int[] arr = new int[]{4};
        int k = 1;
        System.out.println(Arrays.toString(getLeastNumbers(arr, k)));
    }

}
