package com.study.mq.qmq;

import java.util.concurrent.CountDownLatch;
import org.junit.BeforeClass;
import org.junit.Test;
import qunar.tc.qmq.Message;
import qunar.tc.qmq.MessageSendStateListener;
import qunar.tc.qmq.producer.MessageProducerProvider;

/**
 * @author hangwu
 * @date 2022/12/13 13:31
 */
public class QMQExample {

    private static MessageProducerProvider producer;

    @BeforeClass
    public static void init() {
        producer = new MessageProducerProvider();
        producer.init();
    }

    @Test
    public void test_qmq_send_message() {
        Message message = producer.generateMessage("your subject");
        message.setProperty("key", "value");

        CountDownLatch latch = new CountDownLatch(1);
        producer.sendMessage(message, new MessageSendStateListener() {
            @Override
            public void onSuccess(Message m) {
                latch.countDown();
            }

            @Override
            public void onFailed(Message m) {
                latch.countDown();
            }
        });

        try {
            latch.await();
        } catch (Exception e) {
        }
    }
}
