package com.study.basicknowledge;

import org.junit.Test;

/**
 * @author hangwu
 * @date 2022/12/5 13:47
 */
public class OuterTest {

    public static void main(String[] args) {
        //在外层循环处添加outer标签
        outer:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //设置outer的判断条件
                if (i == 1) {
                    break outer;
                }
                System.out.println("i=" + i + ", j=" + j);
            }
        }
    }

    @Test
    public void main() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //不要outer，仅仅用break
                if(i == 1) {
                    break;
                }
                System.out.println("i=" + i + ", j=" + j);
            }
        }
    }

    @Test
    public void test2() {
        someLabel:
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (i % 20 == 0) {
                    break someLabel;
                }
                System.out.println("i=" + i + ", j=" + j);
            }
        }
    }

}
