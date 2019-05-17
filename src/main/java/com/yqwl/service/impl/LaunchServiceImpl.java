package com.yqwl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yqwl.Vo.LaunchVo;
import com.yqwl.dao.LaunchMapper;
import com.yqwl.pojo.Launch;
import com.yqwl.service.LaunchService;

/**
 *
 * @ClassName: LaunchServiceImpl
 * @description 投放房源表的业务实现层
 *
 * @author linhongyu
 * @createDate 2019年4月10日
 */
@Service("launchService")
@Transactional(rollbackFor = { Exception.class })
public class LaunchServiceImpl implements LaunchService{

	@Resource
	private LaunchMapper launchMapper;
	
	/**
	 * @Title: deleteByPrimaryKey
	 * @description 通过id删除一条数据
	 * @param @param id
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月10日
	 */
	@Override
	public int deleteByPrimaryKey(Long id) throws Exception{
		return launchMapper.deleteByPrimaryKey(id);
	}

	/**
	 * @Title: insertSelective
	 * @description 添加一条投放房源信息
	 * @param @param record
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月10日
	 */
	@Override
	public int insertSelective(Launch record) throws Exception{
		return launchMapper.insertSelective(record);
	}

	/**
	 * @Title: selectLaun
	 * @description 查询所有投放房源数据
	 * @param @param recordVo
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月21日
	 */
	@Override
	public Map<String, Object> selectLaun(LaunchVo recordVo) throws Exception{
		Map<String, Object> map = new HashMap<>();
		List<LaunchVo> launchVos=launchMapper.selectLaun(recordVo);
		Integer count=launchMapper.selectCountL(recordVo);
		map.put("date", launchVos);
		map.put("count", count);
		return map;
	}
	/**
	 * @Title: updateStatus
	 * @description 修改投放房源处理状态
	 * @param @param records
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月22日
	 */
	@Override
	public int updateStatus(Launch records) throws Exception {
		return launchMapper.updateStatus(records);
	}
	/**
	 * @Title: updateLaunBroker
	 * @description 处理对投放房源的抢单处理
	 * @param @param broker_id
	 * @param @param id
	 * @param @param session
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月24日
	 */
	@Override
	public int updateLaunBroker(Long broker_id,Long id) throws Exception{
		return launchMapper.updateLaunBroker(broker_id,id);
	}
	/**
	 * @Title: selectMyLaun
	 * @description 查询经纪人名下对投放房源信息
	 * @param @param broker_id
	 * @param @param session
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月24日
	 */
	@Override
	public Map<String, Object> selectMyLaun(Long broker_id,@Param("page") Integer page,@Param("limit") Integer limit) throws Exception{
		List<LaunchVo> launchs=launchMapper.selectMyLaun(broker_id,page,limit);
		Integer count=launchMapper.selectMyCount(broker_id);
		Map<String, Object> map = new HashMap<>();
		map.put("date", launchs);
		map.put("count", count);
		return map;
	}



}
