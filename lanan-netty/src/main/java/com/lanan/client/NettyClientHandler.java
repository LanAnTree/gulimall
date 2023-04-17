package com.lanan.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @author LanAn
 * @date 2022/7/25-18:16
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    /**
     * channel就绪就触发
     * @date 2022/7/25 18:17
     * @param ctx
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello, service", CharsetUtil.UTF_8));
    }

    /**
     * 接收服务器发送的信息
     * @date 2022/7/25 18:20
     * @param ctx
     * @param msg
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println(byteBuf.toString(CharsetUtil.UTF_8));
        System.out.println(ctx.channel().remoteAddress());
    }

    /**
     * 异常处理
     * @date 2022/7/25 18:23
     * @param ctx
     * @param cause
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
