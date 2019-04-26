package com.yqwl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.yqwl.Vo.FuncRoleVo;
import com.yqwl.common.utils.ListUtils;
import com.yqwl.dao.FuncRoleMapper;
import com.yqwl.dao.FunctionMapper;
import com.yqwl.pojo.Function;
import com.yqwl.service.FunctionService;

@Service("functionService")
@Transactional(rollbackFor = { Exception.class })
public class FcuntionServiceImpl implements FunctionService {
	@Autowired
	private FunctionMapper functionMapper;
	@Autowired
	private FuncRoleMapper funcRoleMapper;
	/**
	 * 查询所有权限和角色的所有权限
	 */
	@Override
	public FuncRoleVo listAllFunction(Long roleId) throws Exception {
		FuncRoleVo funcRoleVo = new FuncRoleVo();
		List<Function> list = functionMapper.listAll();
		//把List转换成Tree型数据
		funcRoleVo.setFunctions(ListUtils.listToTree(JSONArray.parseArray(JSON.toJSONString(list)), "id", "pid", "children"));
		if (roleId!=null) {
			funcRoleVo.setFuncRoles(funcRoleMapper.listByRoleId(roleId));
		}
		return funcRoleVo;
	}
	
}
