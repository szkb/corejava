package com.study.offer.array;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Optional;

/**
 * @author hangwu
 * @date 2020/8/11 9:37
 */
public class FirstUniqChar {

    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }

        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            map.merge(temp, 1, Integer::sum);
        }

        Optional<Entry<Character, Integer>> ans =
            map.entrySet().stream().filter(characterIntegerEntry -> characterIntegerEntry.getValue() == 1)
                .findFirst();

        return ans.isPresent() ? ans.get().getKey() : ' ';
    }

    public char firstUniqChar2(String s) {
        int[] count = new int[256];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            count[c]++;
        }
        for (char c : chars) {
            if (count[c] == 1) {
                return c;
            }
        }
        return ' ';
    }
}
