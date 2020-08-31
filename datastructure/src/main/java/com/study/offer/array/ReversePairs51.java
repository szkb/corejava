package com.study.offer.array;

/**
 * @author hangwu
 * @date 2020/8/16 10:15
 */
public class ReversePairs51 {

    public static void reversePairs(int[] nums) {
        merge(nums, 0, nums.length - 1);
    }

    static int merge(int[] arr, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = (start + end) / 2;
        int count = merge(arr, start, mid) + merge(arr, mid + 1, end);

        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            count += arr[i] <= arr[j] ? j - (mid + 1) : 0;
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            count += j - (mid + 1);
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];
        }
        System.arraycopy(temp, 0, arr, start, end - start + 1);
        return count;
    }

}
