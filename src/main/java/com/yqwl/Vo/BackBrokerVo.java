package com.yqwl.Vo;

import java.util.List;

import com.yqwl.pojo.Broker;
import com.yqwl.pojo.Group;
import com.yqwl.pojo.Role;
import com.yqwl.pojo.Shop;

public class BackBrokerVo extends Broker {
	private List<Role> roles;
	private Shop shop;
	private Group group;
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	@Override
	public String toString() {
		return "BackBrokerVo [roles=" + roles + ", shop=" + shop + ", group=" + group + "]";
	}
	
}
