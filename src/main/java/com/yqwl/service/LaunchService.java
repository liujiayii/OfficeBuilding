package com.yqwl.service;

import com.yqwl.pojo.Launch;

/**
 *
 * @ClassName: LaunchService
 * @description 用一句话描述这个类的作用
 *
 * @author 姓名全拼
 * @createDate 2019年4月10日
 */
public interface LaunchService {

	int deleteByPrimaryKey(Long id);
	int insertSelective(Launch record);
}
