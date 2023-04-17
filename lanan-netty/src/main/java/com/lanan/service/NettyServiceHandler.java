package com.lanan.service;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @author LanAn
 * @date 2022/7/25-17:55
 */
public class NettyServiceHandler extends ChannelInboundHandlerAdapter {

    /**
     * 读操作handler
     * @date 2022/7/25 18:01
     * @param ctx 包含channel、pipeline
     * @param msg 客户端消息
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        // 客户端消息
        System.out.println(byteBuf.toString(CharsetUtil.UTF_8));
        // 客户端地址
        System.out.println(ctx.channel().remoteAddress());
    }

    /**
     * 读取完毕执行 将数据通过channel写入到缓存 返回给客户端
     * @date 2022/7/25 18:03
     * @param ctx
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello,client", CharsetUtil.UTF_8));
    }

    /**
     * 异常处理
     * @date 2022/7/25 18:08
     * @param ctx
     * @param cause
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
