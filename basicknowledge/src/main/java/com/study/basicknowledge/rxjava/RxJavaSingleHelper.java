package com.study.basicknowledge.rxjava;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import lombok.extern.slf4j.Slf4j;



/**
 * 单请求处理
 *
 * @param <T>
 * @author xfyuan
 * @date 2019/6/24
 */
@Slf4j
public class RxJavaSingleHelper<T> implements SingleOnSubscribe<T> {

    private final ListenableFuture<T> future;

    public RxJavaSingleHelper(ListenableFuture<T> future) {
        this.future = future;
    }

    @Override
    public void subscribe(SingleEmitter<T> emitter) throws Exception {
        try {
            emitter.setCancellable(() -> {
                try {
                    future.cancel(true);
                } catch (Throwable t) {
                    // just in case
                }
            });
            future.addListener(() -> {
                try {
                    T result = Futures.getDone(future);
                    emitter.onSuccess(result);
                } catch (Exception ex) {
                    onException(emitter, ex);
                }
            }, MoreExecutors.directExecutor());
        } catch (Exception ex) {
            onException(emitter, ex);
        }
    }

    private void onException(SingleEmitter<T> emitter, Throwable t) {
        /*
        observer取消订阅之后会调用ListenableFuture.cancel，然后执行onFailure回调
        此时emitter已经在之前observer取消订阅时dispose过了，如果再次调用emitter.onError功能会导致报错
        所以先判断一下emitter.isDisposed()，如果isDisposed则不做任何处理
        */
        if (emitter.isDisposed()) {
            return;
        }
        emitter.onError(t);
    }

}
