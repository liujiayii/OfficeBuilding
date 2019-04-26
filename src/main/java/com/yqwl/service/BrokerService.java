package com.yqwl.service;

import com.yqwl.Vo.BrokerVo;
import com.yqwl.pojo.Broker;

/**
 *
 * @ClassName: BrokerService
 * @description 用一句话描述这个类的作用
 *
 * @author 姓名全拼
 * @createDate 2019年4月11日
 */
public interface BrokerService {

	Broker selectByPrimaryKey(Long id);

	BrokerVo login(String userName, String password) throws Exception;
}
