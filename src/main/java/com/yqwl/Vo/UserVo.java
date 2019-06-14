package com.yqwl.Vo;

import java.util.List;

import com.yqwl.pojo.User;
import com.yqwl.pojo.UserFollowUp;

public class UserVo extends User {
	private List<UserFollowUp> list;

	public List<UserFollowUp> getList() {
		return list;
	}

	public void setList(List<UserFollowUp> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "UserVp [list=" + list + "]";
	}
	
}
