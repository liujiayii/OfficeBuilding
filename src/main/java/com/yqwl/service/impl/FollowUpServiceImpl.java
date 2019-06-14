package com.yqwl.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yqwl.Vo.FollowUpVo;
import com.yqwl.dao.FollowUpMapper;
import com.yqwl.pojo.FollowUp;
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
	public List<FollowUpVo> selectHomeId(Long home_id) {
		return followUpMapper.selectHomeId(home_id);
	}
	
	
}
