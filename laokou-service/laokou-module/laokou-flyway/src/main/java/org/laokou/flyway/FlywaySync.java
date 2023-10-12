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

package org.laokou.flyway;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.Location;

import java.util.Map;

/**
 * @author laokou
 */
public class FlywaySync {

	private static final String URL = "jdbc:mysql://192.168.30.133:3306/%s?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Shanghai&useSSL=false";

	private static final String USERNAME = "root";

	private static final String PASSWORD = "laokou123";

	public static void main(String[] args) {
		Map<String, String> tableMap = Map.of("kcloud_platform_alibaba", "base", "kcloud_platform_alibaba_flowable",
				"flowable", "kcloud_platform_alibaba_nacos", "nacos", "kcloud_platform_alibaba_tenant", "tenant",
				"kcloud_platform_alibaba_user", "user", "kcloud_platform_alibaba_login_log", "login-log",
				"kcloud_platform_alibaba_xxl_job", "xxl-job", "kcloud_platform_alibaba_seata", "seata");
		tableMap.forEach((k, v) -> {
			Flyway flyway = Flyway.configure()
				.dataSource(String.format(URL, k), USERNAME, PASSWORD)
				.locations(new Location(v))
				.defaultSchema(k)
				.load();
			flyway.migrate();
		});
	}

}
