package com.yqwl.service;

import java.util.List;

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

	Integer insertBroker(Broker broker, Long... roleIds) throws Exception;

	Integer updateBroker(Broker broker, Long... roleIds) throws Exception;

	List<Broker> listAll() throws Exception;

	Broker getById(Long id) throws Exception;
}
