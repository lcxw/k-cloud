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
package org.laokou.admin.gatewayimpl.database.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.laokou.common.mybatisplus.database.dataobject.BaseDO;

import java.io.Serial;
import java.time.LocalDateTime;

/**
 * @author laokou
 */
@Data
@TableName("boot_sys_audit_log")
@Schema(name = "AuditLogDO", description = "审批日志")
public class AuditLogDO extends BaseDO {

	@Serial
	private static final long serialVersionUID = 6137554824134778292L;

	@Schema(name = "businessId", description = "业务ID")
	private Long businessId;

	@Schema(name = "auditName", description = "审批名称")
	private String auditName;

	@Schema(name = "auditDate", description = "审批时间")
	private LocalDateTime auditDate;

	@Schema(name = "auditStatus", description = "审批状态")
	private Integer auditStatus;

	@Schema(name = "comment", description = "审批意见")
	private String comment;

}
