package com.yqwl.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yqwl.Vo.HousesNewAnalysisVo;
import com.yqwl.Vo.UserListVo;
import com.yqwl.Vo.UserVo;
import com.yqwl.common.utils.BeanUtil;
import com.yqwl.common.utils.MapUtil;
import com.yqwl.common.utils.NumberUtil;
import com.yqwl.common.utils.Pager;
import com.yqwl.common.utils.StringUtils;
import com.yqwl.dao.BrokerMapper;
import com.yqwl.dao.GroupMapper;
import com.yqwl.dao.UserFollowUpMapper;
import com.yqwl.dao.UserMapper;
import com.yqwl.dao.UserPhoneMapper;
import com.yqwl.pojo.Broker;
import com.yqwl.pojo.Group;
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
	@Autowired
	private GroupMapper groupMapper;
	@Autowired
	private BrokerMapper brokerMapper;
	
	@Override
	public Integer insert(User user, String... phone) throws Exception{
		user.setTime(new Date());
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
		BeanUtil.copyProperties(userVo,user);
		userVo.setList(list);
		userVo.setPhones(userPhoneMapper.listByUserId(id));
		return userVo;
				
	}

	@Override
	public PageInfo<UserVo> listAll(Pager pager) throws Exception {
		// 获取参数
		Map<String, Object> conditions = MapUtil.formSerializeToMap(pager.getFilter());
		Integer category = NumberUtil.dealInteger(StringUtils.getFirstString(conditions.get("category")));
		String name = StringUtils.getFirstString(conditions.get("name"));
		PageHelper.startPage(pager);
		List<UserVo> list = userMapper.listAll(name,category);
		return new PageInfo<UserVo>(list);
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

	/**
	 * @Title: selectListShop
	 * @description 通过区县id查询分店id
	 * @param @param region_id
	 * @param @return    
	 * @return List<User>    
	 * @author linhongyu
	 * @createDate 2019年6月13日
	 */
	@Override
	public List<User> selectListShop(Long region_id) throws Exception{
		return userMapper.selectListShop(region_id);
	}

	/**
	 * @Title: selectAllSome
	 * @description 通过经纪人id查询客源
	 * @param @param shopId
	 * @param @param startTime
	 * @param @param endTime
	 * @param @return    
	 * @return List<Map<String,Object>>    
	 * @author linhongyu
	 * @createDate 2019年6月17日
	 */
	@Override
	public List<Map<String, Object>> selectAllSome(Long shopId, Date startTime, Date endTime) throws Exception{
		List<Map<String, Object>>list = new ArrayList<Map<String,Object>>();
		/** 查询该店铺下所有小组 */
		List<Group> groupList = groupMapper.getByShopId(shopId);
		/** 循环遍历每个小组下的经纪人 */
		for (Group group : groupList) {
			Map<String, Object> map1 = new HashMap<>();
			List<Map<String, Object>> list2 = new ArrayList<Map<String,Object>>();
			List<Broker> brokerList = brokerMapper.getBrokerByGroupId(group.getId());
			/** 计算每个小组下的成员对应不同课源状态的数量 */
			for (Broker broker : brokerList) {
				Map<String, Object> map2 = new HashMap<>();
				UserListVo  userListVo = new UserListVo();
				userListVo.setSumome(userMapper.selectAllSome(broker.getId(), 1, startTime, endTime));//意向客户
				userListVo.setSumtwo(userMapper.selectAllSome(broker.getId(), 2, startTime, endTime));//已成交客户
				map2.put("name", broker.getReal_name());
				map2.put("userListVo", userListVo);
				list2.add(map2);
			}
			map1.put("groupName", group.getName());
			map1.put("list", list2);
			list.add(map1);
		}
		return list;
	}

	@Override
	public Integer insertUserPhone(UserPhone userPhone) throws Exception {
		return userPhoneMapper.insertSelective(userPhone);
	}

	@Override
	public List<User> findAll() throws Exception {
		return userMapper.findAll();
	}

	@Override
	public PageInfo<UserVo> listAllByShop(Pager pager, Long brokerId) throws Exception {
		// 获取参数
		Map<String, Object> conditions = MapUtil.formSerializeToMap(pager.getFilter());
		Integer category = NumberUtil.dealInteger(StringUtils.getFirstString(conditions.get("category")));
		String name = StringUtils.getFirstString(conditions.get("name"));
		Long shopId = brokerMapper.getBrokerByShopId(brokerId);
		PageHelper.startPage(pager);
		List<UserVo> list = userMapper.listAllByShop(name,category,shopId);
		return new PageInfo<UserVo>(list);
	}

	@Override
	public PageInfo<User> listAllByBrokerId(Pager pager, Long brokerId) throws Exception {
		// 获取参数
		Map<String, Object> conditions = MapUtil.formSerializeToMap(pager.getFilter());
		Integer category = NumberUtil.dealInteger(StringUtils.getFirstString(conditions.get("category")));
		String name = StringUtils.getFirstString(conditions.get("name"));
		PageHelper.startPage(pager);
		List<User> list = userMapper.listAllByBrokerId(name,category,brokerId);
		return new PageInfo<User>(list);
	}
	
}
