package com.yqwl.Vo;

import java.util.List;

import com.yqwl.pojo.User;
import com.yqwl.pojo.UserFollowUp;
import com.yqwl.pojo.UserPhone;

public class UserVo extends User {
	private List<UserFollowUp> list;
	private List<UserPhone> phones;
	public List<UserFollowUp> getList() {
		return list;
	}

	public void setList(List<UserFollowUp> list) {
		this.list = list;
	}

	public List<UserPhone> getPhones() {
		return phones;
	}

	public void setPhones(List<UserPhone> phones) {
		this.phones = phones;
	}

	@Override
	public String toString() {
		return "UserVo [list=" + list + ", phones=" + phones + "]";
	}
	
}
