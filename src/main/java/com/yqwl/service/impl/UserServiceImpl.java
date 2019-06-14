package com.yqwl.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yqwl.Vo.UserVo;
import com.yqwl.common.utils.BeanUtil;
import com.yqwl.common.utils.MapUtil;
import com.yqwl.common.utils.NumberUtil;
import com.yqwl.common.utils.Pager;
import com.yqwl.common.utils.StringUtils;
import com.yqwl.dao.UserFollowUpMapper;
import com.yqwl.dao.UserMapper;
import com.yqwl.dao.UserPhoneMapper;
import com.yqwl.pojo.User;
import com.yqwl.pojo.UserFollowUp;
import com.yqwl.pojo.UserPhone;
import com.yqwl.service.UserService;

@Service("userService")
@Transactional(rollbackFor = { Exception.class })
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserFollowUpMapper userFollowUpMapper;
	@Autowired
	private UserPhoneMapper userPhoneMapper;
	
	@Override
	public Integer insert(User user, List<String> phone) throws Exception{
		int i = userMapper.insertSelective(user);
		for (String string : phone) {
			UserPhone userPhone = new UserPhone();
			userPhone.setPhone(string);
			userPhone.setUser_id(user.getId());
			userPhoneMapper.insertSelective(userPhone);
		}
		return i;
	}

	@Override
	public Integer update(User user) throws Exception {
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public UserVo getByid(Long id) throws Exception {
		UserVo userVo = new UserVo();
		User user = userMapper.selectByPrimaryKey(id);
		List<UserFollowUp> list = userFollowUpMapper.listByUserId(id);
		BeanUtil.copyProperties(user, userVo);
		userVo.setList(list);
		return userVo;
				
	}

	@Override
	public PageInfo<User> listAll(Pager pager) throws Exception {
		// 获取参数
		Map<String, Object> conditions = MapUtil.formSerializeToMap(pager.getFilter());
		Integer category = NumberUtil.dealInteger(StringUtils.getFirstString(conditions.get("category")));
		String nameOrPhone = StringUtils.getFirstString(conditions.get("nameOrPhone"));
		PageHelper.startPage(pager);
		List<User> list = userMapper.listAll(nameOrPhone,category);
		return new PageInfo<User>(list);
	}

	@Override
	public Integer insertUserFollowUp(UserFollowUp userFollowUp) throws Exception {
		userFollowUp.setTime(new Date());
		return userFollowUpMapper.insertSelective(userFollowUp);
	}

	@Override
	public Integer updateUserPhone(UserPhone userPhone) throws Exception {
		return userPhoneMapper.updateByPrimaryKeySelective(userPhone);
	}
	
}
