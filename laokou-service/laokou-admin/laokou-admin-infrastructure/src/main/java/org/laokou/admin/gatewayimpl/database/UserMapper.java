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

package org.laokou.admin.gatewayimpl.database;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.laokou.admin.gatewayimpl.database.dataobject.UserDO;
import org.laokou.common.i18n.dto.PageQuery;
import org.laokou.common.mybatisplus.database.BatchMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.laokou.common.i18n.dto.PageQuery.PAGE_QUERY;
import static org.laokou.common.mybatisplus.database.dataobject.BaseDO.TENANT_ID;

/**
 * @author laokou
 */
@Repository
@Mapper
public interface UserMapper extends BatchMapper<UserDO> {

	/**
	 * 修改用户
	 * @param userDO 用户
	 * @return int
	 */
	Integer updateUser(@Param("userDO") UserDO userDO, @Param("tableName") String tableName);

	/**
	 * 根据租户ID查询下拉列表
	 * @param tenantId
	 * @return
	 */
	List<UserDO> getOptionListByTenantId(@Param(TENANT_ID) Long tenantId);

	/**
	 * 查询用户列表
	 * @param tables
	 * @param user
	 * @param pageQuery
	 * @return
	 */
	List<UserDO> getUserListFilter(@Param("tables") List<String> tables, @Param("user") UserDO user,
			@Param(PAGE_QUERY) PageQuery pageQuery);

	Integer getUserListTotalFilter(@Param("tables") List<String> tables, @Param("user") UserDO user,
			@Param(PAGE_QUERY) PageQuery pageQuery);

	int getUserCount(@Param("tables") List<String> tables, @Param("user") UserDO user);

}
