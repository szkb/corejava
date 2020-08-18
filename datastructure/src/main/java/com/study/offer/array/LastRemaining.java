package com.study.offer.array;

/**
 * @author hangwu
 * @date 2020/8/17 8:33
 */
public class LastRemaining {

    public int lastRemaining(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
}
