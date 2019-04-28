package com.yqwl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yqwl.common.utils.Pager;
import com.yqwl.dao.GroupMapper;
import com.yqwl.pojo.Group;
import com.yqwl.service.GroupService;
@Service("groupService")
@Transactional(rollbackFor = { Exception.class })
public class GroupServiceImpl implements GroupService {
	@Autowired
	private GroupMapper groupMapper;

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
	
}
