package com.study.offer.array;

import org.junit.Test;
import org.springframework.util.StringUtils;

/**
 * @author hangwu
 * @date 2020/8/3 22:27
 */
public class ReplaceBlankTest {

    @Test
    public void test() {
        System.out.println(replaceBlank("we  are happy"));
    }

    private String replaceBlank(String originString) {
        if (StringUtils.isEmpty(originString)) {
            return "";
        }

        return originString.replace(" ", "%20");
    }
}
