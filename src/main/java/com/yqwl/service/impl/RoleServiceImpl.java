package com.yqwl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yqwl.dao.FuncRoleMapper;
import com.yqwl.dao.RoleMapper;
import com.yqwl.pojo.FuncRole;
import com.yqwl.pojo.Function;
import com.yqwl.pojo.Role;
import com.yqwl.service.RoleService;

@Service("roleService")
@Transactional(rollbackFor = { Exception.class })
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private FuncRoleMapper funcRoleMapper;
	/**
	 * 修改角色
	 */
	@Override
	public Integer insertRole(Role role, Long... functionIds) throws Exception {
		roleMapper.insertSelective(role);
		Integer count = 0;
		for (Long functionId : functionIds) {
			FuncRole funcRole = new FuncRole();
			funcRole.setFunction_id(functionId);
			funcRole.setRole_id(role.getId());
			funcRoleMapper.insertSelective(funcRole);
			count++;
		}
		return count;
	}
	/**
	 * 修改角色
	 */
	@Override
	public Integer UpdateRole(Role role,Long... functionIds) throws Exception {
		roleMapper.updateByPrimaryKeySelective(role);
		//删除角色所有权限
		funcRoleMapper.delByRoleId(role.getId());
		int count = 0;
		for (Long long1 : functionIds) {
			FuncRole funcRole = new FuncRole();
			funcRole.setFunction_id(long1);
			funcRole.setRole_id(role.getId());
			funcRoleMapper.insertSelective(funcRole);
			count++;
		}
		return count;
	}
}
