package com.yqwl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yqwl.dao.DelegationMapper;
import com.yqwl.pojo.Delegation;
import com.yqwl.service.DelegationService;

/**
 *
 * @ClassName: DelegationServiceImpl
 * @description 用一句话描述这个类的作用
 *
 * @author 姓名全拼
 * @createDate 2019年4月10日
 */
@Service("delegationService")
public class DelegationServiceImpl implements DelegationService{

	@Resource
	private DelegationMapper delegationMapper;

	/* (non-Javadoc)
	 * @see com.yqwl.service.DelegationService#insert(com.yqwl.pojo.Delegation)
	 */
	@Override
	public int insert(Delegation record) {
		// TODO Auto-generated method stub
		return delegationMapper.insert(record);
	}

	/* (non-Javadoc)
	 * @see com.yqwl.service.DelegationService#updateFindID(com.yqwl.pojo.Delegation)
	 */
	@Override
	public int updateFindID(Delegation record) {
		// TODO Auto-generated method stub
		return delegationMapper.updateFindID(record);
	}

	/* (non-Javadoc)
	 * @see com.yqwl.service.DelegationService#insertSelective(com.yqwl.pojo.Delegation)
	 */
	@Override
	public int insertSelective(Delegation record) {
		// TODO Auto-generated method stub
		return delegationMapper.insertSelective(record);
	}
}
