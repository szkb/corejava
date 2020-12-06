package com.study.basicknowledge.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/4/8 11:46
 */
public class RegexExample {

    private String temp;

    private static final Pattern pattern1 = Pattern.compile("[^A-Za-z]");

    private static final Pattern pattern2 = Pattern.compile("\\s+");

    @Test
    public void test3() {
        String temp = "local('OpenSans-Light'),url(http://fonts.gstatic"
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

//        temp = "Hoonah-Angoon";
//        temp = "Matanuska-Susitna";
//        temp = "Prince of Wales--Hyder Census Area";
        long start = System.currentTimeMillis();
        Matcher cityMatcher = pattern1.matcher(temp);
        String temp1 = cityMatcher.replaceAll(" ");

        Matcher ansMatcher = pattern2.matcher(temp1);
        String ans = ansMatcher.replaceAll(" ");
//        System.out.println(ans);
        System.out.println("方法一：" + (System.currentTimeMillis() - start));

        long start2 = System.currentTimeMillis();
        String result = temp.replaceAll("[^A-Za-z]", " ").replaceAll("\\s+", " ");
//        System.out.println(result);
        System.out.println("方法二：" + (System.currentTimeMillis() - start2));
    }

    @Test
    public void test4() {
        for (int i = 0; i < 1000; i++) {
            test3();
        }
    }

    @Test
    public void test5() {
        String city = "";
        if (city == null) {
            System.out.println("hello world");
        }
    }

    @Test
    public void test6() {
        temp = "hello world";
        System.out.println(temp);
        System.out.println("***********");
    }

    @Test
    public void test7() {
        test6();
        System.out.println(this.temp);
//        test8();
    }

    @Test
    public void test8() {
        System.out.println(temp);
    }

//    @Benchmark
//    public void matcherFromPreCompiledPatternResetMatches(Blackhole bh) {
//        for (String value : values) {
//            bh.consume(matcherFromPreCompiledPattern.reset(value).matches());
//        }
//    }
//
//    @Benchmark
//    public void preCompiledPatternMatcherMatches(Blackhole bh) {
//        for (String value : values) {
//            bh.consume(preCompiledPattern.matcher(value).matches());
//        }
//    }
//
//    @Benchmark
//    public void patternCompileMatcherMatches(Blackhole bh) {
//        for (String value : values) {
//            bh.consume(Pattern.compile(PATTERN).matcher(value).matches());
//        }
//    }
//
//    @Benchmark
//    public void patternMatches(Blackhole bh) {
//        for (String value : values) {
//            bh.consume(Pattern.matches(PATTERN, value));
//        }
//    }
//
//    @Benchmark
//    public void stringMatchs(Blackhole bh) {
//        Instant start = Instant.now();
//        for (String value : values) {
//            bh.consume(value.matches(PATTERN));
//        }
//    }

}
