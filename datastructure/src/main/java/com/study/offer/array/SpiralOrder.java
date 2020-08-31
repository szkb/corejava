package com.study.offer.array;

import java.util.Arrays;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/8/22 10:44
 */
public class SpiralOrder {

    public int[] spiralOrder(int[][] matrix) {
        int i = 0;
        int tempj = 0;

        int[][] ans = new int[matrix.length][matrix[0].length];

        for (tempj = 0; tempj < matrix[0].length; tempj++) {
            ans[i][tempj] = matrix[i][tempj];
        }
        tempj--;
        i++;
        for (; i < matrix.length; i++) {
            ans[i][tempj] = matrix[i][tempj];
        }
        i--;
        for (; tempj >= 0; tempj--) {
            ans[i][tempj] = matrix[i][tempj];
        }

        return null;
    }

    public int[] spiralOrder2(int[][] matrix) {
        int iabove = 0;
        int ibelow = matrix.length;

        int jleft = 0;
        int jright = matrix[0].length;

        int[] ans = new int[matrix.length * matrix[0].length];
        int k = 0;

        int tempi = 0;
        int tempj = 0;
        while (iabove < ibelow && jleft < jright) {
            for (; tempj < jright; tempj++) {
                ans[k++] = matrix[tempi][tempj];
            }
            iabove++;
            tempi++;
            tempj--;
            if (tempi >= ibelow) {
                return ans;
            }
            for (; tempi < ibelow; tempi++) {
                ans[k++] = matrix[tempi][tempj];
            }
            jright--;
            tempj--;
            tempi--;
            for (; tempj >= jleft; tempj--) {
                ans[k++] = matrix[tempi][tempj];
            }
            jleft++;
            tempj++;
            tempi--;

            for (; tempi >= iabove; tempi--) {
                ans[k++] = matrix[tempi][tempj];
            }
            ibelow--;
            tempi++;
            tempj++;
        }

        return ans;
    }

    @Test
    public void test() {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

        System.out.println(Arrays.toString(spiralOrder2(matrix)));
    }

}
