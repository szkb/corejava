package com.study.concurrence.disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.EventHandlerGroup;
import com.lmax.disruptor.dsl.ProducerType;
import java.util.concurrent.Executors;
import org.junit.Test;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        //创建订单工厂
        OrderFactory orderFactory = new OrderFactory();

        //ringbuffer的大小
        int RINGBUFFER_SIZE = 8;

        //创建disruptor
        Disruptor<Order> disruptor = new Disruptor<Order>(orderFactory, RINGBUFFER_SIZE,
            Executors.defaultThreadFactory());

        //设置事件处理器 即消费者
        disruptor.handleEventsWith(new OrderHandler());

        disruptor.start();

        RingBuffer<Order> ringBuffer = disruptor.getRingBuffer();

        //-------------生产数据
        for (int i = 0; i < 3; i++) {

            long sequence = ringBuffer.next();

            Order order = ringBuffer.get(sequence);

            order.setId(i);

            ringBuffer.publish(sequence);
            System.out.println(Thread.currentThread().getName() + " 生产者发布一条数据:" + sequence + " 订单ID：" + i);
        }

        Thread.sleep(1000);

        disruptor.shutdown();
    }

    @Test
    public void tests() throws InterruptedException {

        //创建订单工厂
        OrderFactory orderFactory = new OrderFactory();

        //ringbuffer的大小
        int RINGBUFFER_SIZE = 8;

        //创建disruptor
        Disruptor<Order> disruptor = new Disruptor<Order>(orderFactory, RINGBUFFER_SIZE,
            Executors.defaultThreadFactory());

        //设置事件处理器 即消费者
        EventHandlerGroup<Order> eventHandlerGroup = disruptor
            .handleEventsWith(new OrderHandler(), new OrderHandler2());
        eventHandlerGroup.then(new OrderHandler3());
        disruptor.start();

        RingBuffer<Order> ringBuffer = disruptor.getRingBuffer();

        //-------------生产数据
        for (int i = 0; i < 3; i++) {

            long sequence = ringBuffer.next();

            Order order = ringBuffer.get(sequence);

            order.setId(i);

            ringBuffer.publish(sequence);
            System.out.println(Thread.currentThread().getName() + " 生产者发布一条数据:" + sequence + " 订单ID：" + i);
        }

        Thread.sleep(1000);
        disruptor.shutdown();

    }

    @Test
    public void test2() throws InterruptedException {

        //创建订单工厂
        OrderFactory orderFactory = new OrderFactory();

        BlockingWaitStrategy strategy = new BlockingWaitStrategy();

        //ringbuffer的大小
        int RINGBUFFER_SIZE = 8;

        //创建disruptor
        Disruptor<Order> disruptor = new Disruptor<Order>(orderFactory, RINGBUFFER_SIZE,
            Executors.defaultThreadFactory(), ProducerType.MULTI, strategy);

        //设置事件处理器 即消费者
        EventHandlerGroup<Order> eventHandlerGroup = disruptor
            .handleEventsWith(new OrderHandler(), new OrderHandler2());
        eventHandlerGroup.then(new OrderHandler3());
        disruptor.start();

        RingBuffer<Order> ringBuffer = disruptor.getRingBuffer();
        RingBuffer<Order> ringBuffer1 = disruptor.getRingBuffer();
        RingBuffer<Order> ringBuffer2 = disruptor.getRingBuffer();
        RingBuffer<Order> ringBuffer3 = disruptor.getRingBuffer();
        RingBuffer<Order> ringBuffer4 = disruptor.getRingBuffer();

        //-------------生产数据
        for (int i = 0; i < 3; i++) {

            long sequence = ringBuffer.next();

            Order order = ringBuffer.get(sequence);

            order.setId(i);

            ringBuffer.publish(sequence);
            System.out.println(Thread.currentThread().getName() + " 生产者发布一条数据:" + sequence + " 订单ID：" + i);
        }
        //-------------生产数据
        for (int i = 0; i < 3; i++) {

            long sequence = ringBuffer1.next();

            Order order = ringBuffer1.get(sequence);

            order.setId(i);

            ringBuffer1.publish(sequence);
            System.out.println(Thread.currentThread().getName() + " 生产者发布一条数据:" + sequence + " 订单ID：" + i);
        }
        //-------------生产数据
        for (int i = 0; i < 3; i++) {

            long sequence = ringBuffer2.next();

            Order order = ringBuffer2.get(sequence);

            order.setId(i);

            ringBuffer2.publish(sequence);
            System.out.println(Thread.currentThread().getName() + " 生产者发布一条数据:" + sequence + " 订单ID：" + i);
        }
        //-------------生产数据
        for (int i = 0; i < 3; i++) {

            long sequence = ringBuffer3.next();

            Order order = ringBuffer3.get(sequence);

            order.setId(i);

            ringBuffer3.publish(sequence);
            System.out.println(Thread.currentThread().getName() + " 生产者发布一条数据:" + sequence + " 订单ID：" + i);
        }

        Thread.sleep(1000);
        disruptor.shutdown();

    }

}