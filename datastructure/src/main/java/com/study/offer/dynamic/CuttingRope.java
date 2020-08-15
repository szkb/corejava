package com.study.offer.dynamic;

import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/8/15 14:20
 */
public class CuttingRope {

    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3, b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        }
        if (b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        }
        return (int) Math.pow(3, a) * 2;
    }

    public int cuttingRope2(int n) {
        if (n == 2 || n == 3) {
            return n - 1;
        }
        int res = 1;
        while (n > 4) {
            //如果n大于4，我们不停的让他减去3
            n = n - 3;
            //计算每段的乘积
            res = res * 3;
        }
        return n * res;
    }

    @Test
    public void test() {
        System.out.println(cuttingRope2(7));
    }
}
