package com.study.offer.array;

/**
 * @author hangwu
 * @date 2020/8/16 11:21
 */
public class SumNums {

    public int sumNums(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumNums(n - 1);
    }
}
