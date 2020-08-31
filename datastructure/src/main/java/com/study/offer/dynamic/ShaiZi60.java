package com.study.offer.dynamic;

import java.util.Arrays;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/8/18 9:40
 */
public class ShaiZi60 {

    public double[] twoSum(int n) {
        double[] pre = {1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d};
        for (int i = 2; i <= n; i++) {
            // 总和的类别
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < pre.length; j++) {
                for (int x = 0; x < 6; x++) {
                    // 这里的/6举3个骰子的例子即可
                    tmp[j + x] += pre[j] / 6;
                }
            }
            pre = tmp;
        }
        return pre;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(twoSum(3)));
    }

}
