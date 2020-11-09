package com.study.leetcode.array;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * @author hangwu
 * @date 2020/11/9 9:04
 */
public class KClosest973 {

    public int[][] kClosest(int[][] points, int K) {
        Map<Integer, Integer> number = new HashMap<>(points.length);
        for (int i = 0; i < points.length; i++) {
            number.put(i, getDistance(i, points));
        }

        List<Integer> keys = number.entrySet().stream().sorted(Entry.comparingByValue()).map(Entry::getKey)
            .collect(Collectors.toList());

        int[][] ans = new int[K][2];
        for (int i = 0; i < K; i++) {
            ans[i] = points[keys.get(i)];
        }

        return ans;
    }

    private int getDistance(int i, int[][] points) {
        return (int) (Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
    }
}
