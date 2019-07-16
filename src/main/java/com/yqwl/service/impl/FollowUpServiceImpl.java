package com.yqwl.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.yqwl.Vo.FollowUpVo;
import com.yqwl.dao.BrokerMapper;
import com.yqwl.dao.FollowUpMapper;
import com.yqwl.dao.GroupMapper;
import com.yqwl.dao.UserFollowUpMapper;
import com.yqwl.pojo.Broker;
import com.yqwl.pojo.FollowUp;
import com.yqwl.pojo.Group;
import com.yqwl.service.FollowUpService;

/**
 *
 * @ClassName: FollowUpServiceImpl
 * @description 经纪人跟进表service实现层
 * @author linhongyu
 * @createDate 2019年6月9日
 */
@Service("followUpService")
@Transactional(rollbackFor = { Exception.class })
public class FollowUpServiceImpl implements FollowUpService{
	
	@Autowired
	private FollowUpMapper followUpMapper;
	@Autowired
	private GroupMapper groupMapper;
	@Autowired
	private BrokerMapper brokerMapper;
	@Autowired
	private UserFollowUpMapper userFollowUpMapper;
	/**
	 * @Title: insertSelective
	 * @description 修改委托找房当前状态
	 * @param @param record
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年6月9日
	 */
	@Override
	public int insertSelective(FollowUp record) throws Exception{
		return followUpMapper.insertSelective(record);
	}
	
	/**
	 * @Title: selectFollow
	 * @description 查询当前经纪人是否有未跟进房源
	 * @param @param broker_id
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年6月9日
	 */
	@Override
	public FollowUp selectFollow(Long broker_id) throws Exception{
		return followUpMapper.selectFollow(broker_id);
	}

	/**
	 * @Title: updateByPrimaryKeySelective
	 * @description 修改跟进状态和是否通知撤单
	 * @param @param broker_id
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年6月10日
	 */
	@Override
	public int updateByPrimaryKeySelective(FollowUp record) {
		return followUpMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * @Title: selectByPrimaryKey
	 * @description 通过主键id查询一条跟进数据
	 * @param @param id
	 * @param @return    
	 * @return FollowUp    
	 * @author linhongyu
	 * @createDate 2019年6月10日
	 */
	@Override
	public FollowUp selectByPrimaryKey(Long id) {
		return followUpMapper.selectByPrimaryKey(id);
	}

	/**
     * @Title: selectHomeId
     * @description 查询该房源的跟进信息
     * @param @param home_id
     * @param @return    
     * @return FollowUpVo    
     * @author linhongyu
     * @createDate 2019年6月11日
     */
	@Override
	public Map<String, Object> selectHomeId(Long home_id,Integer page,Integer limit) {
		Map<String, Object> map = new HashMap<>();
		Integer count=followUpMapper.selectFollowsCount(home_id);
		List<FollowUpVo> followUpVos=followUpMapper.selectHomeId(home_id,page,limit);
		map.put("date", followUpVos);
		map.put("count", count);
		return map;
	}

	/**
	 * @Title: selectByPrimaryCount
	 * @description 查询房源跟进统计
	 * @param @param shopId
	 * @param @param startTime
	 * @param @param endTime
	 * @param @return    
	 * @return List<Map<String,Object>>    
	 * @author linhongyu
	 * @createDate 2019年7月10日
	 */
	@Override
	public List<Map<String, Object>> selectByPrimaryCount(Long shopId, Date startTime, Date endTime) throws Exception{
	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	/** 查询该店铺下所有小组 */
	List<Group> groupList = groupMapper.getByShopId(shopId);
	/** 循环遍历每个小组下的经纪人 */
	for (Group group : groupList) {
		Map<String, Object> map1 = new HashMap<>();
		List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
		List<Broker> brokerList = brokerMapper.getBrokerByGroupId(group.getId());
		/** 计算每个小组下的成员对应房源跟进数量统计 */
		for (Broker broker : brokerList) {
			Map<String, Object> map2 = new HashMap<>();
			Long broker_id=broker.getId();
			int homenum= followUpMapper.selectFollowCount(broker_id,startTime,endTime);
			map2.put("name", broker.getReal_name());
			map2.put("homenum", homenum);
			list2.add(map2);
		}
		map1.put("groupName", group.getName());
		map1.put("list", list2);
		list.add(map1);
	}
	return list;
}

	/**
     * @Title: selectByUserCount
     * @description 查询经纪人客源跟进统计
     * @param @param shopId
     * @param @param startTime
     * @param @param endTime
     * @param @return    
     * @return List<Map<String,Object>>    
     * @author linhongyu
     * @createDate 2019年7月11日
     */
	@Override
	public List<Map<String, Object>> selectByUserCount(Long shopId, Date startTime, Date endTime) throws Exception{
	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	/** 查询该店铺下所有小组 */
	List<Group> groupList = groupMapper.getByShopId(shopId);
	/** 循环遍历每个小组下的经纪人 */
	for (Group group : groupList) {
		Map<String, Object> map1 = new HashMap<>();
		List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
		List<Broker> brokerList = brokerMapper.getBrokerByGroupId(group.getId());
		/** 计算每个小组下的成员对应客源跟进数量统计 */
		for (Broker broker : brokerList) {
			Map<String, Object> map2 = new HashMap<>();
			Long broker_id=broker.getId();
			int usernum= userFollowUpMapper.selectUserFollowCount(broker_id, startTime, endTime);
			map2.put("name", broker.getReal_name());
			map2.put("usernum", usernum);
			list2.add(map2);
		}
		map1.put("groupName", group.getName());
		map1.put("list", list2);
		list.add(map1);
	}
	return list;
}

	
	
}
