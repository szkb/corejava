package com.study.offer.exam;

import java.util.*;

/**
 * @author hangwu
 * @date 2020/8/25 9:31
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] temp = s.split(",");
        Map<String, Integer> ans = new HashMap<>();

        for (String s1 : temp) {
            if (!ans.containsKey(s1)) {
                ans.put(s1, 1);
            } else {
                ans.put(s1, ans.get(s1) + 1);
            }
        }

        ans.forEach((k, v) -> {
            if (v >= 2) {
                System.out.print(k);
                System.out.print(" ");
            }
        });
    }
}
