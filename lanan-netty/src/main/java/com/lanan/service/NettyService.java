package com.lanan.service;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;


/**
 * @author LanAn
 * @date 2022/7/25-17:35
 */
public class NettyService {
    public static void main(String[] args) throws Exception {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            // 服务端启动对象，配置参数
            ServerBootstrap serverBootstrap = new ServerBootstrap();

            // 设置线程组
            serverBootstrap.group(bossGroup, workerGroup)
                    // 使用NioServerSocketChannel作为通道
                    .channel(NioServerSocketChannel.class)
                    // 设置线程等待数
                    .option(ChannelOption.SO_BACKLOG, 128)
                    // 保持开启状态
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    // workerGroup 中worker EventLoop对于NioServerSocketChannel设置handler
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        // 设置handler
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            // 自定义handler
                            socketChannel.pipeline().addLast(new NettyServiceHandler());
                        }
                    });

            // 开启服务
            ChannelFuture bind = serverBootstrap.bind(6688).sync();

            // 采用异步模型 对关闭channel进行监听
            bind.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
