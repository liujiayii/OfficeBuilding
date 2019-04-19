package com.yqwl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yqwl.dao.ClientMapper;
import com.yqwl.pojo.Client;
import com.yqwl.service.ClientService;

/**
 *
 * @ClassName: ClientServiceImpl
 * @description 用一句话描述这个类的作用
 *
 * @author 姓名全拼
 * @createDate 2019年4月16日
 */
@Service("clientService")
public class ClientServiceImpl implements ClientService{

	@Resource
	private ClientMapper clientMapper;
	/* (non-Javadoc)
	 * @see com.yqwl.service.ClientService#insert(com.yqwl.pojo.Client)
	 */
	@Override
	public int insert(Client record) {
		// TODO Auto-generated method stub
		return clientMapper.insert(record);
	}
	/* (non-Javadoc)
	 * @see com.yqwl.service.ClientService#seleceFindId(java.lang.Long)
	 */
	@Override
	public Client seleceFindId(Long phones) {
		// TODO Auto-generated method stub
		return clientMapper.seleceFindId(phones);
	}

}
