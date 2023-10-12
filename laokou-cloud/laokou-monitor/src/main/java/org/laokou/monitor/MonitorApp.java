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
package org.laokou.monitor;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author laokou
 */
@SpringBootApplication
@EnableAdminServer
@EnableEncryptableProperties
@EnableDiscoveryClient
public class MonitorApp {

	public static void main(String[] args) {
		// System.setProperty(TlsSystemConfig.TLS_ENABLE, String.valueOf(TRUE));
		// System.setProperty(TlsSystemConfig.CLIENT_AUTH, String.valueOf(TRUE));
		// System.setProperty(TlsSystemConfig.CLIENT_TRUST_CERT, "tls/nacos.cer");
		new SpringApplicationBuilder(MonitorApp.class).web(WebApplicationType.REACTIVE).run(args);
	}

}
