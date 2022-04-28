package com.study.dubbo.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @author hangwu
 * @date 2022/4/27 15:12
 */
public class ByteBufTests {

    public static void main(String[] args) {
        ByteBuf directBuf = Unpooled.directBuffer(100);
        ((ByteBuf) directBuf).writeBytes("direct buffer".getBytes());
        System.out.println("可写字节容量："+directBuf.writableBytes());
        System.out.println("初始化可读字节："+directBuf.readableBytes());
        System.out.println("初始化可丢弃字节："+directBuf.readerIndex()+"\n");
        directBuf.readBytes(2);
        System.out.println("读取两个字节"+"\n");
        System.out.println("读取后可写字节容量："+directBuf.writableBytes());
        System.out.println("读取后可读字节："+directBuf.readableBytes());
        System.out.println("读取后可丢弃字节："+directBuf.readerIndex()+"\n");
        directBuf.discardReadBytes();
        System.out.println("执行discardReadBytes后可写字节容量："+directBuf.writableBytes());
        System.out.println("执行discardReadBytes后可读字节："+directBuf.readableBytes());
        System.out.println("执行discardReadBytes后可丢弃字节："+directBuf.readerIndex());
    }
}
