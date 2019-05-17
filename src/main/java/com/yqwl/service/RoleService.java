package com.yqwl.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yqwl.common.utils.Pager;
import com.yqwl.pojo.Role;

public interface RoleService {
	Integer insertRole(Role role) throws Exception;

	Integer UpdateRole(Long role, Long... functionIds) throws Exception;

	List<Role> listAllRole() throws Exception;

	PageInfo<Role> pageAllRole(Pager pager) throws Exception;

	Integer DeleteRole(Long id) throws Exception;

}
