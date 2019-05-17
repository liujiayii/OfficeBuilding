package com.yqwl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yqwl.Vo.EntrustseeVo;
import com.yqwl.dao.BrokerMapper;
import com.yqwl.dao.EntrustseeMapper;
import com.yqwl.pojo.Entrustsee;
import com.yqwl.service.EntrustseeService;

/**
 *
 * @ClassName: EntrustseeServiceImpl
 * @description 用一句话描述这个类的作用
 *
 * @author 姓名全拼
 * @createDate 2019年4月10日
 */
@Service("entrustseeService")
@Transactional(rollbackFor = { Exception.class })
public class EntrustseeServiceImpl implements EntrustseeService{
	@Resource
	private EntrustseeMapper entrustseeMapper;
	@Autowired
	private BrokerMapper brokerMapper;
	/**
	 * @Title: insert
	 * @description 添加一条预约看房数据
	 * @param @param record
	 * @param @return    
	 * @return String    
	 * @author 姓名全拼
	 * @createDate 2019年4月10日
	 */
	@Override
	public int insert(Entrustsee record) throws Exception{
		return entrustseeMapper.insert(record);
	}
	/**
	 * @Title: updateType
	 * @description 修改预约看房状态
	 * @param @param seetype
	 * @param @return    
	 * @return String    
	 * @author 姓名全拼
	 * @createDate 2019年4月10日
	 */
	@Override
	public int updateType(Entrustsee record) throws Exception{
		return entrustseeMapper.updateType(record);
	}
	/**
	 * @Title: selectAllEN
	 * @description 后台查询所有预约看房
	 * @param @param record
	 * @param @param page
	 * @param @param limit
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月10日
	 */
	@Override
	public Map<String, Object> selectAllEN(Long broker_id,Integer page,Integer limit) throws Exception{
		Map<String, Object> map = new HashMap<>();
		Long cityId = brokerMapper.getBrokerByCityId(brokerMapper.selectByPrimaryKey(broker_id).getGroup_id());
		int flag = 0;
		int count = 0;
		List<Entrustsee> list = entrustseeMapper.listByCityId(cityId,page,limit);
		count = entrustseeMapper.listByCityIdCount(cityId,page,limit);
		flag = limit - list.size();
		list.addAll(entrustseeMapper.listByCityIdAndBuilding(cityId,page,flag));
		count = count + entrustseeMapper.listByCityIdAndBuildingCount(cityId,page,limit);
		map.put("data", list);
		map.put("count", count);
		return map;
	}
	/**
	 * @Title: updateBoerk
	 * @description 抢单成功
	 * @param @param broker_id
	 * @param @param id
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月10日
	 */
	@Override
	public int updateBoerk(Long broker_id, Long id) throws Exception{
		return entrustseeMapper.updateBoerk(broker_id, id);
	}
	/**
	 * @Title: selectBroker
	 * @description 经纪人查询预约数据
	 * @param @param broker_id
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月10日
	 */
	@Override
	public Map<String, Object> selectBroker(Long broker_id,Integer page,Integer limit) throws Exception{
		Map<String, Object> map = new HashMap<>();
		List<EntrustseeVo> entrustsees=entrustseeMapper.selectBroker(broker_id,page,limit);
		Integer count=entrustseeMapper.selectCounts(broker_id);
		map.put("date", entrustsees);
		map.put("count", count);
		return map;
	}
}
