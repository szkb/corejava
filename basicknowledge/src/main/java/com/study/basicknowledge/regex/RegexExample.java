package com.study.basicknowledge.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/4/8 11:46
 */
public class RegexExample {
    Pattern pattern = Pattern.compile("(?<=url\\()[^)]+");

    @Test
    public void test() {
        String content = "local('OpenSans-Light'),url(http://fonts.gstatic"
            + ".com/s/opensans/v13/DXI1ORHCpsQm3Vp6mXoaTa-j2U0lmluP9RWlSytm3ho.woff2) format('woff2');"
            + "unicode-range:U+0460-052F,U+20B4,U+2DE0-2DFF,U+A640-A69F;}@font-face{font-family:'Open Sans';"
            + "font-style:normal;font-weight:300;src:local('Open Sans Light'),local('OpenSans-Light'),url"
            + "(http://fonts.gstatic.com/s/opensans/v13/DXI1ORHCpsQm3Vp6mXoaTZX5f-9o1vgP2EXwfjgl7AY.woff2) format"
            + "('woff2');unicode-range:U+0400-045F,U+0490-0491,U+04B0-04B1,U+2116;}@font-face{font-family:'Open "
            + "Sans';font-style:normal;font-weight:300;src:local('Open Sans Light'),local('OpenSans-Light'),url"
            + "(http://fonts.gstatic.com/s/opensans/v13/DXI1ORHCpsQm3Vp6mXoaTRWV49_lSm1NYrwo-zkhivY.woff2) format"
            + "('woff2');unicode-range:U+1F00-1FFF;}@font-face{font-family:'Open Sans';font-style:normal;"
            + "font-weight:300;src:local('Open Sans Light'),local('OpenSans-Light'),url(http://fonts.gstatic"
            + ".com/s/opensans/v13/DXI1ORHCpsQm3Vp6mXoaTaaRobkAwv3vxw3jMhVENGA.woff2) format('woff2');";

        Matcher sceneMatcher = pattern.matcher(content);
        System.out.println(sceneMatcher.find());
        System.out.println(sceneMatcher.group());
        System.out.println(sceneMatcher.groupCount());
    }

    @Test
    public void test2() {
        List<Integer> number = new ArrayList<>();
        number.add(1);
        number.add(2);
        number.add(3);

        List<Integer> numberFilter = new ArrayList<>();
        numberFilter.add(1);
        numberFilter.add(2);

        number.removeAll(numberFilter);
        System.out.println(number);
    }

}
