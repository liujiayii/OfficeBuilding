package com.yqwl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yqwl.Vo.FeedbackVo;
import com.yqwl.dao.FeedbackMapper;
import com.yqwl.pojo.Feedback;
import com.yqwl.service.FeedbackService;

/**
 *
 * @ClassName: FeedbackServiceImpl
 * @description FeedbackServiceImpl实现层
 * @author linhongyu
 * @createDate 2019年6月12日
 */
@Service("feedbackService")
@Transactional(rollbackFor = { Exception.class })
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	private FeedbackMapper feedbackMapper;
	/**
	 * @Title: insertSelective
	 * @description 新增一条带看反馈信息
	 * @param @param record
	 * @param @return    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年6月12日
	 */
	@Override
	public int insertSelective(Feedback record) {
		return feedbackMapper.insertSelective(record);
	}
	 /**
     * @Title: selectListKey
     * @description 查询该房源的反馈信息
     * @param @param home_id
     * @param @return    
     * @return List<Feedback>    
     * @author linhongyu
     * @createDate 2019年6月12日
     */
	@Override
	public List<FeedbackVo> selectListKey(Long hone_id) throws Exception{
		return feedbackMapper.selectListKey(hone_id);
	}
	@Override
	public Map<String, Object> selectListFeed(Long hone_id, Integer page, Integer limit) throws Exception {
		Map<String, Object> map = new HashMap<>();
		Integer count=feedbackMapper.selectFeedCount(hone_id);
		List<FeedbackVo> feedbackVos=feedbackMapper.selectListFeed(hone_id, page, limit);
		map.put("date", feedbackVos);
		map.put("count", count);
		return map;
	}
	

}
