package com.yqwl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yqwl.dao.BrokerMapper;
import com.yqwl.pojo.Broker;
import com.yqwl.service.BrokerService;

/**
 *
 * @ClassName: BrokerServiceImpl
 * @description 用一句话描述这个类的作用
 *
 * @author 姓名全拼
 * @createDate 2019年4月11日
 */
@Service("brokerService")
public class BrokerServiceImpl implements BrokerService{

	@Resource
	private BrokerMapper brokerMapper;

	/* (non-Javadoc)
	 * @see com.yqwl.service.BrokerService#selectByPrimaryKey(java.lang.Long)
	 */
	@Override
	public Broker selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return brokerMapper.selectByPrimaryKey(id);
	}
	

}
