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
package org.laokou.common.i18n.common;

import lombok.Data;
import org.laokou.common.i18n.utils.MessageUtil;

import java.io.Serial;

/**
 * @author laokou
 */
@Data
public class GlobalException extends RuntimeException {

	@Serial
	private static final long serialVersionUID = 4102669900127613541L;

	private int code;

	private String msg;

	public GlobalException(int code) {
		this.code = code;
		this.msg = MessageUtil.getMessage(code);
	}

	public GlobalException(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public GlobalException(String msg) {
		super(msg);
		this.code = StatusCode.INTERNAL_SERVER_ERROR;
		this.msg = msg;
	}

}
