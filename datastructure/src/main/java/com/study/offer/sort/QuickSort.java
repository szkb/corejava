package com.study.offer.sort;

import java.util.Arrays;
import org.junit.Test;

/**
 * @author hangwu
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] n = {4, 6, 5, 3};
        quicksort(n);
        System.out.print("快排结果：");
        for (int m : n) {
            System.out.print(m + " ");
        }
    }

    public static void quicksort(int[] n) {
        sort(n, 0, n.length - 1);
    }

    public static void sort(int[] n, int l, int r) {
        if (l >= r) {
            return;
        }
        // 一趟快排，并返回交换后基数的下标
        int index = partition(n, l, r);
        // 递归排序基数左边的数组
        sort(n, l, index - 1);
        // 递归排序基数右边的数组
        sort(n, index + 1, r);
    }

    public static int partition(int[] n, int l, int r) {
        // p为基数，即待排序数组的第一个数
        int p = n[l];
        int i = l;
        int j = r;
        while (i < j) {
            // 从右往左找第一个小于基数的数
            while (n[j] >= p && i < j) {
                j--;
            }
            // 从左往右找第一个大于基数的数
            while (n[i] <= p && i < j) {
                i++;
            }
            // 找到后交换两个数
            swap(n, i, j);
        }
        // 使划分好的数分布在基数两侧
        swap(n, l, i);
        return i;
    }

    private static void swap(int[] n, int i, int j) {
        int temp = n[i];
        n[i] = n[j];
        n[j] = temp;
    }

    @Test
    public void test() {
        int[] ans = {3, 7, 8, 9, 2, 1, 0, 74, 56};
        quicksort(ans);
        System.out.println(Arrays.toString(ans));
    }

}
