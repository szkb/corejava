package com.study.offer.string;

import java.util.Arrays;

/**
 * @author hangwu
 * @date 2020/8/17 8:58
 */
public class ReverseLeftWords {

    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() == 0) {
            return s;
        }

        String prefix = s.substring(0, n);
        String suffix = s.substring(n);

        swap(prefix);
        swap(suffix);
        return swap(prefix + suffix);
    }

    private String swap(String s) {
        char[] temp = s.toCharArray();
        for (int i = 0; i < temp.length / 2; i++) {
            char c = temp[i];
            temp[i] = temp[temp.length - 1 - i];
            temp[temp.length - 1 - i] = c;
        }

        return new String(temp);
    }
}
