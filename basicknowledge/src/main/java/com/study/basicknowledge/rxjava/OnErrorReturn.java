package com.study.basicknowledge.rxjava;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.Callable;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/6/29 16:49
 */
public class OnErrorReturn {

    @Test
    public void test() {
        // 打印 100  随后会立即回调onComplete
        Disposable disposable = Observable
            .fromCallable(() -> {
                return 1/ 0; //返回null,即出现错误
            })
            .onErrorReturn(throwable -> {
                //出现错误时，用一个默认的数据项将其替代,这里根据不同的错误返回不同的数据项
                return 100;
            }).subscribe(System.out::println);

    }

    @Test
    public void test2() {
        // 打印 1、2、3  随后会立即回调onComplete
        Disposable disposable = Observable
            .fromCallable((Callable<Integer>) () -> {
                return null; //返回null,即出现错误
            })
            .onErrorResumeNext(throwable -> {
                //出现错误时开始发射新的Observable的数据序列
                return Observable.just(1, 2, 3);
            }).subscribe(System.out::println);
    }

    @Test
    public void test3() {
        Observable.just(divide(1)).onErrorReturn(throwable -> {
            return 100;
        }).subscribe(System.out::println);
    }

    private int divide(int i) {
        return i / 0;
    }

}
