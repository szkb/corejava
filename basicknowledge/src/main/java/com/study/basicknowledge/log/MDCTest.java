//package com.study.basicknowledge.log;
//
//import io.reactivex.Single;
//import io.reactivex.SingleEmitter;
//import io.reactivex.SingleOnSubscribe;
//import io.reactivex.functions.Consumer;
//import java.util.HashMap;
//import java.util.Map;
//import org.junit.Test;
//import org.slf4j.MDC;
//import org.springframework.lang.NonNull;
//
///**
// * @author hangwu
// * @date 2020/1/14 14:21
// */
//public class MDCTest {
//
//    @Test
//    public void test() throws InterruptedException {
//        MDC.setContextMap(getMap());
//        Map<String, String> tags = MDC.getCopyOfContextMap();
//        System.out.println(Thread.currentThread().getName() + ":" + MDC.getCopyOfContextMap());
//        new Thread(() ->{
//            MDC.setContextMap(tags);
//            System.out.println(Thread.currentThread().getName() + ":" + MDC.getCopyOfContextMap());
//        }).start();
//    }
//
//    private Map<String, String> getMap() {
//        Map<String, String> tags = new HashMap<>();
//        tags.put("height", "175");
//        tags.put("weight", "75");
//        return tags;
//    }
//
//    @Test
//    public void test1() {
//        Single.create(new SingleOnSubscribe<String>() {
//
//            @Override
//            public void subscribe(@NonNull SingleEmitter<String> e) throws Exception {
//
//                e.onSuccess("test");
//            }
//        }).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(@NonNull String s) {
//                System.out.println(s);
//            }
//        }, new Consumer<Throwable>() {
//            @Override
//            public void accept(@NonNull Throwable throwable) {
//                throwable.printStackTrace();
//            }
//        });
//    }
//
//}
