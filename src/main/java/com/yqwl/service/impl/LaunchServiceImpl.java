package com.yqwl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yqwl.dao.LaunchMapper;
import com.yqwl.pojo.Launch;
import com.yqwl.service.LaunchService;

/**
 *
 * @ClassName: LaunchServiceImpl
 * @description 用一句话描述这个类的作用
 *
 * @author 姓名全拼
 * @createDate 2019年4月10日
 */
@Service("launchService")
public class LaunchServiceImpl implements LaunchService{

	@Resource
	private LaunchMapper launchMapper;
	

	/* (non-Javadoc)
	 * @see com.yqwl.service.LaunchService#deleteByPrimaryKey(java.lang.Long)
	 */
	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return launchMapper.deleteByPrimaryKey(id);
	}


	/* (non-Javadoc)
	 * @see com.yqwl.service.LaunchService#insertSelective(com.yqwl.pojo.Launch)
	 */
	@Override
	public int insertSelective(Launch record) {
		// TODO Auto-generated method stub
		return launchMapper.insertSelective(record);
	}



}
