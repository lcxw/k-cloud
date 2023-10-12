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

package org.laokou.admin.command.user;

import lombok.RequiredArgsConstructor;
import org.laokou.admin.domain.gateway.UserGateway;
import org.laokou.admin.domain.user.User;
import org.laokou.admin.dto.user.UserPasswordResetCmd;
import org.laokou.common.i18n.dto.Result;
import org.laokou.common.security.utils.UserUtil;
import org.springframework.stereotype.Component;

/**
 * @author laokou
 */
@Component
@RequiredArgsConstructor
public class UserPasswordResetCmdExe {

	private final UserGateway userGateway;

	public Result<Boolean> execute(UserPasswordResetCmd cmd) {
		return Result.of(userGateway.resetPassword(toUser(cmd)));
	}

	private User toUser(UserPasswordResetCmd cmd) {
		User user = new User(cmd.getId(), cmd.getPassword());
		user.setEditor(UserUtil.getUserId());
		return user;
	}

}
