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

package org.laokou.im.common.listener;

import jakarta.annotation.PreDestroy;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.laokou.common.nacos.utils.ConfigUtil;
import org.laokou.common.nacos.utils.ServiceUtil;
import org.laokou.im.config.WebsocketProperties;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

/**
 * @author laokou
 */
@Data
@Component
@RequiredArgsConstructor
public class DiscoveryListener implements ApplicationListener<ApplicationReadyEvent> {

	private final ServiceUtil serviceUtil;

	private final ConfigUtil configUtil;

	private final WebsocketProperties websocketProperties;

	@Override
	@SneakyThrows
	public void onApplicationEvent(ApplicationReadyEvent event) {
		String ip = InetAddress.getLocalHost().getHostAddress();
		String group = configUtil.getGroup();
		int port = websocketProperties.getPort();
		String appName = websocketProperties.getAppName();
		serviceUtil.registerInstance(appName, group, ip, port);
	}

	@SneakyThrows
	@PreDestroy
	public void close() {
		String ip = InetAddress.getLocalHost().getHostAddress();
		String group = configUtil.getGroup();
		int port = websocketProperties.getPort();
		String appName = websocketProperties.getAppName();
		serviceUtil.deregisterInstance(appName, group, ip, port);
	}

}
