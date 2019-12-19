//package com.study.mq.mqexample;
//
//public class Producer {
//    public Producer() {
//    }
//
//    public static void main(String[] args) throws IOException, TimeoutException {
//        ConnectionFactory factory = new ConnectionFactory();
//        factory.setUsername("guest");
//        factory.setPassword("guest");
//        factory.setHost("localhost");
//        Connection conn = factory.newConnection();
//        Channel channel = conn.createChannel();
//        String exchangeName = "hello-exchange";
//        channel.exchangeDeclare(exchangeName, "direct", true);
//        String routingKey = "hola";
//        byte[] messageBodyBytes = "quit".getBytes();
//        channel.basicPublish(exchangeName, routingKey, (BasicProperties)null, messageBodyBytes);
//        channel.close();
//        conn.close();
//    }
//}
