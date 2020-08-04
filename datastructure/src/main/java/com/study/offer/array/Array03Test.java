package com.study.offer.array;

import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/8/3 21:55
 */
public class Array03Test {

    @Test
    public void test() {

    }

    private boolean find(int number, int[][] array) {
        if (array == null || array[0] == null) {
            return false;
        }

        if (array.length == 0 || array[0].length == 0) {
            return false;
        }

        int x = 0;
        int y = array[0].length - 1;

        while (x < array.length && y >= 0) {
            if (array[x][y] == number) {
                return true;
            } else if (array[x][y] > number) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }
}
