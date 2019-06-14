package com.yqwl.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yqwl.Vo.UserVo;
import com.yqwl.common.utils.Pager;
import com.yqwl.pojo.User;
import com.yqwl.pojo.UserFollowUp;
import com.yqwl.pojo.UserPhone;

public interface UserService {

	Integer insert(User user, List<String> phone) throws Exception;

	Integer update(User user) throws Exception;

	UserVo getByid(Long id) throws Exception;

	PageInfo<User> listAll(Pager pager) throws Exception;

	Integer insertUserFollowUp(UserFollowUp userFollowUp) throws Exception;

	Integer updateUserPhone(UserPhone userPhone) throws Exception;



}
