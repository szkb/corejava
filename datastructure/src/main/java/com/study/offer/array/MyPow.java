package com.study.offer.array;

import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/8/16 9:37
 */
public class MyPow {

    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(myPow(2.0, -2147483648));
    }
}
