package com.study.offer.sort;

import org.junit.Test;

/**
 * @author hangwu
 * @date 2022/12/1 14:43
 */
public class ExampleTest {

    private static int minRunLength(int n) {
        assert n >= 0;
        int r = 0;      // Becomes 1 if any 1 bits are shifted off
        while (n >= 32) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    @Test
    public void test() {
        System.out.println(minRunLength(64));
    }

}
