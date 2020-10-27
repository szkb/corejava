package com.study;

import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/10/18 22:11
 */
public class Test1018 {

    public int solution(int N) {
        // write your code in Java SE 8
        int position = 0;
        if (N >= 0) {
            String s = String.valueOf(N);
            char[] c = s.toCharArray();
            for (int i = 0; i < c.length; i++) {
                if (c[i] - '0' < 5) {
                    position = i;
                    break;
                }
            }

            return Integer.parseInt(s.substring(0, position) + 5 + s.substring(position));
        }

        N = - N;
        String s = String.valueOf(N);
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] - '0' > 5) {
                position = i;
                break;
            }
        }

        return Integer.parseInt("-" + s.substring(0, position) + 5 + s.substring(position));
    }

    @Test
    public void test() {
        solution(-999);
    }
}
