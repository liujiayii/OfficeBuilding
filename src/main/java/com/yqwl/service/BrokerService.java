package com.yqwl.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yqwl.Vo.BackBrokerVo;
import com.yqwl.Vo.BrokerVo;
import com.yqwl.common.utils.Pager;
import com.yqwl.pojo.Broker;

/**
 *
 * @ClassName: BrokerService
 * @description 经纪人表的service实现接口
 *
 * @author linhongyu
 * @createDate 2019年4月11日
 */
public interface BrokerService {
	/**
	 * @Title: selectByPrimaryKey
	 * @description 通过id查询经纪人
	 * @param @param id
	 * @param @return
	 * @param @throws Exception    
	 * @return Broker    
	 * @author linhongyu
	 * @createDate 2019年4月29日
	 */
	Broker selectByPrimaryKey(Long id) throws Exception;

	BrokerVo login(String userName, String password) throws Exception;

	Integer insertBroker(Broker broker, Long... roleIds) throws Exception;

	Integer updateBroker(Broker broker, Long... roleIds) throws Exception;
	/**
	 * @Title: listAll
	 * @description 查询所有经纪人信息
	 * @param @return
	 * @param @throws Exception    
	 * @return List<Broker>    
	 * @author linhongyu
	 * @createDate 2019年4月29日
	 */
	List<Broker> listAll() throws Exception;
	BackBrokerVo getById(Long id) throws Exception;

	PageInfo<Broker> ListBackBroker(Pager pager) throws Exception;

	List<Broker> getByGroupId(Long groupId) throws Exception;

	List<Broker> listAllByStatus(Integer status,Integer cityId) throws Exception;

	Integer resourceTransfer(Long brokerId, Long houseTarget, Long userTarget) throws Exception;
}
