package com.study.basicknowledge.callback;

/**
 * @author hangwu
 * @date 2020/7/2 11:40
 */
public class BookingAsyncResult {

    private AsyncCallback<String> callback;

    public BookingAsyncResult(AsyncCallback<String> callback) {
        this.callback = callback;
    }
}
