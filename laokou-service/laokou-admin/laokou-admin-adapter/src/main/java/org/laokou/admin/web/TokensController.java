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
import org.laokou.admin.api.TokensServiceI;
import org.laokou.admin.dto.token.TokenGetQry;
import org.laokou.admin.dto.token.clientobject.TokenCO;
import org.laokou.common.i18n.dto.Result;
import org.laokou.common.trace.annotation.TraceLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laokou
 */
@RestController
@Tag(name = "TokensController", description = "令牌管理")
@RequiredArgsConstructor
@RequestMapping("v1/tokens")
public class TokensController {

	private final TokensServiceI tokensServiceI;

	@TraceLog
	@GetMapping
	@Operation(summary = "令牌管理", description = "生成令牌")
	public Result<TokenCO> generate() {
		return tokensServiceI.generate(new TokenGetQry());
	}

}
