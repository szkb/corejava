package com.study.offer.array;

/**
 * @author hangwu
 * @date 2020/8/21 8:40
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {

        // 投票数量
        int votes = 0;
        // 众数
        int x = 0;

        for (int num : nums) {
            if (votes == 0) {
                x = num;
            }
            votes += (num == x ? 1 : -1);
        }

        return x;
    }
}
