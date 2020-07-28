package com.study.dubbo.netty.action;

import io.netty.channel.*;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * 初始化一个通道，主要用于设置各种Handler
 */
public class TestChannelnitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
         /**
         * Handler就相当于Servlet中的过滤器, 请求和响应都会走Handler
         * HttpServerCodec: http的编解码器，用于Http请求和相应
         */
        pipeline.addLast("httpServerCodec", new HttpServerCodec());
        pipeline.addLast("testHttpServerHandler", (ChannelHandler) new TestHttpServerHandler());
    }
}