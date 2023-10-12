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

/**
 * @author laokou
 */
@Data
@TableName("boot_sys_tenant")
@Schema(name = "TenantDO", description = "租户")
public class TenantDO extends BaseDO {

	@Serial
	private static final long serialVersionUID = -6290324458980136421L;

	@Schema(name = "name", description = "租户名称")
	private String name;

	@Schema(name = "sourceId", description = "数据源ID")
	private Long sourceId;

	@Schema(name = "packageId", description = "套餐ID")
	private Long packageId;

}
