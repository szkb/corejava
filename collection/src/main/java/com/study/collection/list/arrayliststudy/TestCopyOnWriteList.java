package com.study.collection.list.arrayliststudy;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestCopyOnWriteList {

    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        list.add("item1");
        list.add("item2");
        list.add("item3");

        Thread thread = new Thread() {
            @Override
            public void run() {
                list.set(1, "modify-item1");
//                list.remove("item2");
            }
        };
        //main线程先获得迭代器
        Iterator<String> itr = list.iterator();
        thread.start();//启动thread线程
        thread.join();//这里让main线程等待thread线程执行完，然后再遍历看看输出的结果是不是修改后的结果
        while (itr.hasNext()) {
            System.out.println(Thread.currentThread().getName() + "线程中的list的元素:" + itr.next());
        }
    }
}