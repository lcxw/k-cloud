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

package org.laokou.admin.command.packages;

import lombok.RequiredArgsConstructor;
import org.laokou.admin.domain.gateway.PackageGateway;
import org.laokou.admin.domain.packages.Package;
import org.laokou.admin.domain.user.User;
import org.laokou.admin.dto.packages.PackageInsertCmd;
import org.laokou.common.core.utils.ConvertUtil;
import org.laokou.common.i18n.dto.Result;
import org.laokou.common.security.utils.UserUtil;
import org.springframework.stereotype.Component;

/**
 * @author laokou
 */
@Component
@RequiredArgsConstructor
public class PackageInsertCmdExe {

	private final PackageGateway packageGateway;

	public Result<Boolean> execute(PackageInsertCmd cmd) {
		Package pack = ConvertUtil.sourceToTarget(cmd.getPackageCO(), Package.class);
		return Result.of(packageGateway.insert(pack, toUser()));
	}

	private User toUser() {
		return ConvertUtil.sourceToTarget(UserUtil.user(), User.class);
	}

}
