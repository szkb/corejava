package com.study;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hangwu
 * @date 2020/10/18 22:23
 */
public class Test1019 {

    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = 0;
        Map<Integer, Integer> number = new HashMap<>();
        for (int j : A) {
            if (number.containsKey(j)) {
                number.put(j, number.get(j) + 1);
            } else {
                number.put(j, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : number.entrySet()) {
            if (entry.getKey().equals(entry.getValue())) {
                if (entry.getKey() > max) {
                    max = entry.getKey();
                }
            }
        }

        return max;
    }

}
