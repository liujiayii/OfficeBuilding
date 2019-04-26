package com.yqwl.Vo;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.yqwl.pojo.FuncRole;

public class FuncRoleVo {
	private JSONArray functions;
	private List<FuncRole> funcRoles;
	public JSONArray getFunctions() {
		return functions;
	}
	public void setFunctions(JSONArray functions) {
		this.functions = functions;
	}
	public List<FuncRole> getFuncRoles() {
		return funcRoles;
	}
	public void setFuncRoles(List<FuncRole> funcRoles) {
		this.funcRoles = funcRoles;
	}
	@Override
	public String toString() {
		return "FuncRoleVo [functions=" + functions + ", funcRoles=" + funcRoles + "]";
	} 
	
}
