package com.yqwl.service;

import com.yqwl.pojo.Role;

public interface RoleService {
	Integer insertRole(Role role, Long... functionIds)throws Exception;

	Integer UpdateRole(Role role,Long... functionIds)throws Exception;

}
