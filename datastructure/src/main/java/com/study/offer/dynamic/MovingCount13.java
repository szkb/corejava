package com.study.offer.dynamic;

/**
 * @author hangwu
 * @date 2020/8/22 10:15
 */
public class MovingCount13 {

    public int movingCount(int m, int n, int k) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i + j) <= k) {
                    count++;
                }
            }
        }
        return count;
    }
}
