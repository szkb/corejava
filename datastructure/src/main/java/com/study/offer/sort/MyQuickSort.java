package com.study.offer.sort;

import java.util.Arrays;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/10/2 11:07
 */
public class MyQuickSort {

    public void quickSort(int left, int right, int[] number) {
        if (number.length <= 0) {
            return;
        }

        if (left >= right) {
            return;
        }

        int position = position(left, right, number);
        quickSort(left, position - 1, number);
        quickSort(position + 1, right, number);
    }

    private int position(int left, int right, int[] number) {
        int i = left;
        int j = right;
        int temp = number[left];

        while (i < j) {
            while (i < j && number[j] > temp) {
                j--;
            }
            if (i >= j) {
                break;
            }

            // 或者直接替代，不用每次交换
            number[i++] = number[j];

//            change(i, j, number);
//            i++;
            while (i < j && number[i] < temp) {
                i++;
            }
            if (i >= j) {
                break;
            }
            number[j--] = number[i];
//            change(i, j, number);
//            j--;
        }
        number[i] = temp;
//        System.out.println(Arrays.toString(number));
        return i;
    }

    private void change(int i, int j, int[] number) {
        int temp = number[i];
        number[i] = number[j];
        number[j] = temp;
    }


    @Test
    public void test() {
        int[] ans = {3, 7, 8, 9, 2, 1, 0, 74, 56};
        quickSort(0, 8, ans);
        System.out.println(Arrays.toString(ans));
    }

}
