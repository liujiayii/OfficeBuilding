package com.yqwl.Vo;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.yqwl.pojo.Broker;
import com.yqwl.pojo.Function;
import com.yqwl.pojo.Role;

public class BrokerVo extends Broker {
	/**  字段的含义 */
	private static final long serialVersionUID = 3898491587662187693L;
	private List<Role> roles;
	private JSONArray functions;
	private Long cityId;
	
	public Long getCityId() {
		return cityId;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public JSONArray getFunctions() {
		return functions;
	}
	public void setFunctions(JSONArray functions) {
		this.functions = functions;
	}
	@Override
	public String toString() {
		return "BrokerVo [roles=" + roles + ", functions=" + functions + ", cityId=" + cityId + "]";
	}
	
}
