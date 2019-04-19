package com.yqwl.service;

import com.yqwl.pojo.Delegation;

/**
 *
 * @ClassName: DelegationService
 * @description 用一句话描述这个类的作用
 *
 * @author 姓名全拼
 * @createDate 2019年4月10日
 */
public interface DelegationService {
	
	int insert(Delegation record);
	int insertSelective(Delegation record);
	int updateFindID(Delegation record);
}
