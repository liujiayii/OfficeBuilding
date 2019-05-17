package com.yqwl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yqwl.Vo.ClientVo;
import com.yqwl.dao.ClientMapper;
import com.yqwl.pojo.Client;
import com.yqwl.service.ClientService;

/**
 *
 * @ClassName: ClientServiceImpl
 * @description Client表的service接口实现层
 *
 * @author linhongyu
 * @createDate 2019年4月16日
 */
@Service("clientService")
@Transactional(rollbackFor = { Exception.class })
public class ClientServiceImpl implements ClientService{

	@Resource
	private ClientMapper clientMapper;
	/**
	 * @Title: insert
	 * @description 新增一条用户登录信息
	 * @param @param record
	 * @param @return
	 * @param @throws Exception    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年4月29日
	 */
	@Override
	public int insert(Client record) throws Exception{
		return clientMapper.insert(record);
	}
	/**
	 * @Title: seleceFindId
	 * @description 通过手机号查询用户
	 * @param @param phones
	 * @param @return
	 * @param @throws Exception    
	 * @return Client    
	 * @author linhongyu
	 * @createDate 2019年4月29日
	 */
	@Override
	public Client seleceFindId(Long phones) throws Exception{
		return clientMapper.seleceFindId(phones);
	}
	/**
	 * @Title: selectClient
	 * @description 查询客户列表并分页条数
	 * @param @param page
	 * @param @param limit
	 * @param @return    
	 * @return List<Client>    
	 * @author linhongyu
	 * @createDate 2019年5月5日
	 */
	@Override
	public Map<String, Object> selectClient(Integer page, Integer limit) {
		List<ClientVo> clientVos=clientMapper.selectClient(page, limit);
		Integer count=clientMapper.selectCount();
		Map<String, Object> map = new HashMap<>();
		map.put("data", clientVos);
		map.put("count", count);
		return map;
	}

}
