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
@TableName("boot_sys_dict")
@Schema(name = "DictDO", description = "字典")
public class DictDO extends BaseDO {

	@Serial
	private static final long serialVersionUID = 956432385619473630L;

	@Schema(name = "label", description = "名称")
	private String label;

	@Schema(name = "type", description = "类型")
	private String type;

	@Schema(name = "value", description = "值")
	private String value;

	@Schema(name = "remark", description = "备注")
	private String remark;

	@Schema(name = "sort", description = "排序")
	private Integer sort;

}
