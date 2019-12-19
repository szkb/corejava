//package com.study.mq.mqexample;
//
//import java.io.IOException;
//import java.util.concurrent.TimeoutException;
//
//public class Consumer {
//    public Consumer() {
//    }
//
//    public static void main(String[] args) throws IOException, TimeoutException {
//        ConnectionFactory factory = new ConnectionFactory();
//        factory.setUsername("guest");
//        factory.setPassword("guest");
//        factory.setHost("localhost");
//        Connection conn = factory.newConnection();
//        final Channel channel = conn.createChannel();
//        String exchangeName = "hello-exchange";
//        channel.exchangeDeclare(exchangeName, "direct", true);
//        String queueName = channel.queueDeclare().getQueue();
//        String routingKey = "hola";
//        channel.queueBind(queueName, exchangeName, routingKey);
//
//        while(true) {
//            boolean autoAck = false;
//            String consumerTag = "";
//            channel.basicConsume(queueName, autoAck, consumerTag, new DefaultConsumer(channel) {
//                public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body) throws IOException {
//                    String routingKey = envelope.getRoutingKey();
//                    String contentType = properties.getContentType();
//                    System.out.println("消费的路由键：" + routingKey);
//                    System.out.println("消费的内容类型：" + contentType);
//                    long deliveryTag = envelope.getDeliveryTag();
//                    channel.basicAck(deliveryTag, false);
//                    System.out.println("消费的消息体内容：");
//                    String bodyStr = new String(body, "UTF-8");
//                    System.out.println(bodyStr);
//                }
//            });
//        }
//    }
//}
