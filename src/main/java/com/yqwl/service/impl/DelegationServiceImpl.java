package com.yqwl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yqwl.Vo.DelegationVo;
import com.yqwl.dao.DelegationMapper;
import com.yqwl.pojo.Delegation;
import com.yqwl.service.DelegationService;

/**
 *
 * @ClassName: DelegationServiceImpl
 * @description 委托找房的实现层
 *
 * @author linhongyu
 * @createDate 2019年4月10日
 */
@Service("delegationService")
@Transactional(rollbackFor = { Exception.class })
public class DelegationServiceImpl implements DelegationService{

	@Resource
	private DelegationMapper delegationMapper;

	/**
	 * @Title: updateFindID
	 * @description 修改委托找房当前状态
	 * @param @param record
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月10日
	 */
	@Override
	public int updateFindID(Delegation record) throws Exception{
		return delegationMapper.updateFindID(record);
	}
	/**
	 * @Title: insertSelective
	 * @description 新增一条委托找房信息
	 * @param @param record
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月10日
	 */
	@Override
	public int insertSelective(Delegation record) throws Exception{
		return delegationMapper.insertSelective(record);
	}
	/**
	 * @Title: selectDeleAll
	 * @description 后台查询委托看房数据
	 * @param @param recorrdVo
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月20日
	 */
	@Override
	public List<DelegationVo> selectDeleAll(DelegationVo recorrdVo) throws Exception{
		return delegationMapper.selectDeleAll(recorrdVo);
	}
	/**
	 * @Title: selectDeleAll
	 * @description 后台查询委托看房数据条数
	 * @param @param recorrdVo
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月20日
	 */
	@Override
	public Integer selectCont(DelegationVo recorrdVo) throws Exception{
		return delegationMapper.selectCont(recorrdVo);
	}
	/**
	 * @Title: updateDeleBroker
	 * @description 对委托找房进行抢单
	 * @param @param broker_id
	 * @param @param id
	 * @param @param session
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月24日
	 */
	@Override
	public int updateDeleBroker(Long broker_id, Long id) throws Exception{
		return delegationMapper.updateDeleBroker(broker_id, id);
	}
	/**
	 * @Title: selectDeleCount
	 * @description 经纪人查询自己的需要处理的委托信息
	 * @param @param broker_id
	 * @param @param page
	 * @param @param limit
	 * @param @return    
	 * @return List<DelegationVo>    
	 * @author linhongyu
	 * @createDate 2019年4月25日
	 */
	@Override
	public Map<String, Object> selectDeleCount(Long broker_id,Integer page, Integer limit) throws Exception{
		List<DelegationVo> delegationVos=delegationMapper.selectDeleCount(broker_id, page, limit);
		Integer count=delegationMapper.selectCountDel(broker_id);
		Map<String, Object> map = new HashMap<>();
		map.put("date", delegationVos);
		map.put("count", count);
		return map;
	}
}
