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

package org.laokou.admin.command.message.query;

import com.baomidou.dynamic.datasource.annotation.DS;
import lombok.RequiredArgsConstructor;
import org.laokou.admin.dto.message.MessageUnreadCountGetQry;
import org.laokou.admin.gatewayimpl.database.MessageDetailMapper;
import org.laokou.common.i18n.dto.Result;
import org.laokou.common.security.utils.UserUtil;
import org.springframework.stereotype.Component;

import static org.laokou.admin.common.Constant.TENANT;

/**
 * @author laokou
 */
@Component
@RequiredArgsConstructor
public class MessageUnreadCountGetQryExe {

	private final MessageDetailMapper messageDetailMapper;

	@DS(TENANT)
	public Result<Integer> execute(MessageUnreadCountGetQry qry) {
		return Result.of(messageDetailMapper.getUnreadMessageCountByUserId(UserUtil.getUserId()));
	}

}
