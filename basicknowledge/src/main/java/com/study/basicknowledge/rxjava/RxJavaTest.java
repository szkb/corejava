package com.study.basicknowledge.rxjava;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/1/14 14:57
 */
public class RxJavaTest {

    @Test
    public void test() {
        Single.create(new SingleOnSubscribe<String>() {

            @Override
            public void subscribe(@NonNull SingleEmitter<String> e) throws Exception {

                e.onSuccess("test");
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                System.out.println(s);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                throwable.printStackTrace();
            }
        });
    }

    @Test
    public void test2() {
        final ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());

        ListenableFuture<String> future = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hello";
            }
        });
        Single.create(new RxJavaSingleHelper<>(future));
    }


}
