package com.study.offer.array;

import java.util.Arrays;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/8/13 9:25
 */
public class MinNumber45 {

    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }
        return sb.toString();
    }

    @Test
    public void test() {
        String[] a = new String[]{"2", "30", "1"};
        Arrays.sort(a, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));

        System.out.println(Arrays.toString(a));

        System.out.println("12".compareTo("2"));
    }
}
