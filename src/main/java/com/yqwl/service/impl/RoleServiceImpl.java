package com.yqwl.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.common.utils.Pager;
import com.yqwl.common.web.BizException;
import com.yqwl.dao.BrokerRoleMapper;
import com.yqwl.dao.FuncRoleMapper;
import com.yqwl.dao.RoleMapper;
import com.yqwl.pojo.BrokerRole;
import com.yqwl.pojo.FuncRole;
import com.yqwl.pojo.Role;
import com.yqwl.service.RoleService;

@Service("roleService")
@Transactional(rollbackFor = { Exception.class })
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private FuncRoleMapper funcRoleMapper;
	@Autowired
	private BrokerRoleMapper brokerRoleMapper;
	/**
	 * 添加角色
	 */
	@Override
	public Integer insertRole(Role role) throws Exception {
		return roleMapper.insertSelective(role);
	}
	/**
	 * 修改角色
	 */
	@Override
	public Integer UpdateRole(Long id,Long... functionIds) throws Exception {
		//删除角色所有权限
		funcRoleMapper.delByRoleId(id);
		int count = 0;
		for (Long long1 : functionIds) {
			FuncRole funcRole = new FuncRole();
			funcRole.setFunction_id(long1);
			funcRole.setRole_id(id);
			funcRoleMapper.insertSelective(funcRole);
			count++;
		}
		return count;
	}
	@Override
	public List<Role> listAllRole() throws Exception {
		return roleMapper.listAllRole();
	}
	@Override
	public PageInfo<Role> pageAllRole(Pager pager) throws Exception {
		PageHelper.startPage(pager);
		List<Role> list = roleMapper.listAllRole();
		return new PageInfo<Role>(list);
	}
	@Override
	public Integer DeleteRole(Long id) throws Exception {
		List<BrokerRole> list = brokerRoleMapper.listByRoleId(id);
		if (list.size()>0) throw new BizException(FastJsonUtil.getResponseJson("2000", "该角色已使用不能删除"));
		funcRoleMapper.delByRoleId(id);
		return roleMapper.deleteByPrimaryKey(id);
	}
}
