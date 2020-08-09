package com.study.offer.string;

import org.junit.Test;
import org.springframework.util.StringUtils;

/**
 * @author hangwu
 * @date 2020/8/9 9:46
 */
public class ReverseWord {

    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        if (StringUtils.isEmpty(s)) {
            return null;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                int temp = i;
                do {
                    i--;
                } while (s.charAt(i) == ' ');
                for (int j = temp + 1; j < s.length() && s.charAt(j) != ' '; j++) {
                    stringBuilder.append(s.charAt(j));
                }
                stringBuilder.append(" ");
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                break;
            }
            stringBuilder.append(s.charAt(i));
        }

        return stringBuilder.toString().trim();
    }

    public String reverseWords2(String s) {
        s = s.trim(); // 删除首尾空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--; // 搜索首个空格
            }
            res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
            while (i >= 0 && s.charAt(i) == ' ') {
                i--; // 跳过单词间空格
            }
            j = i; // j 指向下个单词的尾字符
        }
        return res.toString().trim(); // 转化为字符串并返回
    }

    public String reverseWords3(String s) {
        String[] strs = s.trim().split(" "); // 删除首尾空格，分割字符串
        StringBuilder res = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) { // 倒序遍历单词列表
            if (strs[i].equals(" ")) {
                continue; // 遇到空单词则跳过
            }
            res.append(strs[i] + " "); // 将单词拼接至 StringBuilder
        }
        return res.toString().trim(); // 转化为字符串，删除尾部空格，并返回
    }

    @Test
    public void test() {
        String s = "a good   example";
        System.out.println(reverseWords(s));
    }
}
