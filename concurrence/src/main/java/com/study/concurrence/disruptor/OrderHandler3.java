package com.study.concurrence.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * @author hangwu
 * @date 2020/4/12 14:24
 */
public class OrderHandler3 implements EventHandler<Order> {

    @Override
    public void onEvent(Order order, long l, boolean b) throws Exception {
        System.out.println(Thread.currentThread().getName() + " 消费者处理中:" + l);
        order.setInfo("info" + order.getId());
        order.setPrice(Math.random());
    }
}
