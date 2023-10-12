/*
 * Copyright (c) 2022 KCloud-Platform-Alibaba Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.laokou.im.module.websocket;

import io.netty.bootstrap.AbstractBootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ServerChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioChannelOption;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.DefaultThreadFactory;
import lombok.extern.slf4j.Slf4j;
import org.laokou.common.netty.config.AbstractServer;
import org.springframework.boot.autoconfigure.task.TaskExecutionProperties;

import static org.laokou.im.module.websocket.WebsocketHandler.USER_CACHE;

/**
 * @author laokou
 */
@Slf4j
public class WebSocketServer extends AbstractServer {

	public WebSocketServer(int port, String poolName, ChannelInitializer<?> channelInitializer,
			TaskExecutionProperties taskExecutionProperties) {
		super(port, poolName, channelInitializer, taskExecutionProperties);
	}

	@Override
	protected AbstractBootstrap<ServerBootstrap, ServerChannel> init() {
		// 核心线程数
		int coreSize = taskExecutionProperties.getPool().getCoreSize();
		// boss负责监听端口
		boss = new NioEventLoopGroup(1, new DefaultThreadFactory(poolName, Thread.MAX_PRIORITY));
		// work负责线程读写
		work = new NioEventLoopGroup(coreSize, new DefaultThreadFactory(poolName, Thread.MAX_PRIORITY));
		// 配置引导
		ServerBootstrap serverBootstrap = new ServerBootstrap();
		// 绑定线程组
		return serverBootstrap.group(boss, work)
			// 指定通道
			.channel(NioServerSocketChannel.class)
			// 开启TCP底层心跳，维持长连接
			.childOption(ChannelOption.SO_KEEPALIVE, true)
			// 请求队列最大长度（如果连接建立频繁，服务器处理创建新连接较慢，可以适当调整参数）
			.option(ChannelOption.SO_BACKLOG, 2048)
			// 重复使用端口
			.option(NioChannelOption.SO_REUSEADDR, true)
			// 延迟发送
			.option(ChannelOption.TCP_NODELAY, true)
			// websocket处理类
			.childHandler(channelInitializer);
	}

	@Override
	public void send(String clientId, Object obj) {
		Channel channel = USER_CACHE.getIfPresent(clientId);
		if (channel != null) {
			channel.writeAndFlush(obj);
		}
	}

}
