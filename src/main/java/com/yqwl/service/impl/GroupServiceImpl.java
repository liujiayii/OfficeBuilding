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
import com.yqwl.dao.BrokerMapper;
import com.yqwl.dao.GroupMapper;
import com.yqwl.pojo.Broker;
import com.yqwl.pojo.Group;
import com.yqwl.service.GroupService;
@Service("groupService")
@Transactional(rollbackFor = { Exception.class })
public class GroupServiceImpl implements GroupService {
	@Autowired
	private GroupMapper groupMapper;
	@Autowired
	private BrokerMapper brokerMapper;
	@Override
	public Integer insert(Group group) throws Exception {
		return groupMapper.insertSelective(group);
	}

	@Override
	public Integer update(Group group) throws Exception {
		return groupMapper.updateByPrimaryKeySelective(group);
	}

	@Override
	public Group getByid(Long id) throws Exception {
		return groupMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<Group> ListAll(Pager pager) throws Exception {
		PageHelper.startPage(pager);
		List<Group> list = groupMapper.ListAll();
		return new PageInfo<Group>(list);
	}

	@Override
	public List<Group> getByShopId(Long shopId) throws Exception {
		return groupMapper.getByShopId(shopId);
	}

	@Override
	public Integer delete(Long id) throws Exception {
		List<Broker> list = brokerMapper.getBrokerByGroupId(id);
		if (list.size()>0) throw new BizException(FastJsonUtil.getResponseJson("2000", "小组成员未清空")); 
		return groupMapper.deleteByPrimaryKey(id);
	}
	
}
