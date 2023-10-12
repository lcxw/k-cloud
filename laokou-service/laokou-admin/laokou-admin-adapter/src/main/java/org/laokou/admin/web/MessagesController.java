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
package org.laokou.admin.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.laokou.admin.api.MessagesServiceI;
import org.laokou.admin.dto.message.*;
import org.laokou.admin.dto.message.clientobject.MessageCO;
import org.laokou.admin.domain.annotation.OperateLog;
import org.laokou.common.data.cache.annotation.DataCache;
import org.laokou.common.i18n.dto.Datas;
import org.laokou.common.i18n.dto.Result;
import org.laokou.common.idempotent.annotation.Idempotent;
import org.laokou.common.trace.annotation.TraceLog;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author laokou
 */
@RestController
@RequiredArgsConstructor
@Tag(name = "MessagesController", description = "消息管理")
@RequestMapping("v1/messages")
public class MessagesController {

	private final MessagesServiceI messagesServiceI;

	@Idempotent
	@TraceLog
	@PostMapping
	@Operation(summary = "消息管理", description = "新增消息")
	@OperateLog(module = "消息管理", operation = "新增消息")
	@PreAuthorize("hasAuthority('messages:insert')")
	public Result<Boolean> insert(@RequestBody MessageInsertCmd cmd) {
		return messagesServiceI.insert(cmd);
	}

	@TraceLog
	@PostMapping("list")
	@Operation(summary = "消息管理", description = "查询消息列表")
	@PreAuthorize("hasAuthority('messages:list')")
	public Result<Datas<MessageCO>> list(@RequestBody MessageListQry qry) {
		return messagesServiceI.list(qry);
	}

	@TraceLog
	@PostMapping("{detailId}")
	@Operation(summary = "消息管理", description = "查看消息")
	@OperateLog(module = "消息管理", operation = "查看消息")
	public Result<MessageCO> read(@PathVariable("detailId") Long detailId) {
		return messagesServiceI.read(new MessageReadCmd(detailId));
	}

	@TraceLog
	@GetMapping("{id}")
	@Operation(summary = "消息管理", description = "查看消息")
	@PreAuthorize("hasAuthority('messages:detail')")
	@DataCache(name = "messages", key = "#id")
	public Result<MessageCO> getById(@PathVariable("id") Long id) {
		return messagesServiceI.getById(new MessageGetQry(id));
	}

	@TraceLog
	@PostMapping("unread-list")
	@Operation(summary = "消息管理", description = "未读消息列表")
	public Result<Datas<MessageCO>> unreadList(@RequestBody MessageUnreadListQry qry) {
		return messagesServiceI.unreadList(qry);
	}

	@TraceLog
	@GetMapping("unread-count")
	@Operation(summary = "消息管理", description = "未读消息数量")
	public Result<Integer> unreadCount() {
		return messagesServiceI.unreadCount(new MessageUnreadCountGetQry());
	}

}
