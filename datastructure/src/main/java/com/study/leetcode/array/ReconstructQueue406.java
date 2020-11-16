package com.study.leetcode.array;

import java.util.*;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/11/16 9:36
 */
public class ReconstructQueue406 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (person1, person2) -> {
            if (person1[0] != person2[0]) {
                return person2[0] - person1[0];
            } else {
                return person1[1] - person2[1];
            }
        });
        List<int[]> ans = new ArrayList<>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }

    @Test
    public void test() {
        int[][] number = {{5, 0}, {7, 0}, {6, 1}, {7, 1}, {5, 2}, {4, 4}};
        System.out.println(Arrays.deepToString(reconstructQueue(number)));
    }
}
