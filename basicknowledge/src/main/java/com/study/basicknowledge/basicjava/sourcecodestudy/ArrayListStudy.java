package com.study.basicknowledge.basicjava.sourcecodestudy;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/3/14 13:13
 */
public class ArrayListStudy {

    @Test
    public void test() {
        Integer[] A = new Integer[]{1, 2, 3};
        Integer[] B = new Integer[4];

        List<Integer> temp = new ArrayList<>(3);
        for (int i = 0; i < 10; i++) {
            temp.add(1);
        }

//        List<Integer> test = new ArrayList<>(temp);

//        System.out.println(test);

//        Integer[] ts = Arrays.copyOf(A, 5, Integer[].class);
//        System.out.println(Arrays.toString(ts));
//        System.out.println(Integer[].class);
//        System.out.println(A.getClass().getComponentType());

//        System.arraycopy(A, 0, B, 0, 3);
//        System.out.println(Arrays.toString(B));
//        ((ArrayList<Integer>) temp).trimToSize();
//        System.out.println(temp.size());
//        ((ArrayList<Integer>) temp).ensureCapacity(10);
//        System.out.println(temp);
//        System.out.println(temp.size());

        for (int i = 0; i < 10; i++) {
            test2();
        }
    }

    @Test
    public void test2() {
        final int N = 100000000;
        Object obj = new Object();

        //没用调用ensureCapacity()方法初始化ArrayList对象
        ArrayList list = new ArrayList(N);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i <= N; i++) {
            list.add(obj);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("没有调用ensureCapacity()方法所用时间：" + (endTime - startTime) + "ms");

        //调用ensureCapacity()方法初始化ArrayList对象
        list = new ArrayList();
        startTime = System.currentTimeMillis();
        list.ensureCapacity(N);//预先设置list的大小
        for (int i = 0; i <= N; i++) {
            list.add(obj);
        }
        endTime = System.currentTimeMillis();
        System.out.println("调用ensureCapacity()方法所用时间：" + (endTime - startTime) + "ms");
    }

    @Test
    public void test3() {
        ArrayList<Integer> temp = new ArrayList<>(3);
        temp.add(1);

        ArrayList<Integer> test = (ArrayList<Integer>) temp.clone();
        ArrayList<Integer> test2 = temp;
        temp.set(0, 100);
        System.out.println(temp);
        System.out.println(test);
        System.out.println(test2);
    }

    @Test
    public void test4() {
        ArrayList<Integer> temp = new ArrayList<>(3);
        Integer[] A = new Integer[3];
        temp.add(1);
        temp.toArray(A);
    }

    @Test
    public void test5() {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(2);

        ArrayList<Integer> number = new ArrayList<>(3);
//        temp.add(1, number);
//        temp.addAll(number)

    }

    @Test
    public void test6() {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(2);

        ArrayList<Integer> test = new ArrayList<>();
        test.add(1);

        temp.removeAll(test);
        System.out.println(temp);
    }

    @Test
    public void test7() {
        System.out.println(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
    }

}
