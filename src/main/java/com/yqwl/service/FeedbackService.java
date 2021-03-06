package com.yqwl.service;

import java.util.List;
import java.util.Map;

import com.yqwl.Vo.FeedbackVo;
import com.yqwl.pojo.Feedback;

/**
 *
 * @ClassName: FeedbackService
 * @description FeedbackService层
 * @author linhongyu
 * @createDate 2019年6月12日
 */
public interface FeedbackService {
	/**
	 * @Title: insertSelective
	 * @description 新增一条带看反馈信息
	 * @param @param record
	 * @param @return    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年6月12日
	 */
	int insertSelective(Feedback record) throws Exception;
	 /**
     * @Title: selectListKey
     * @description 查询该房源的反馈信息
     * @param @param home_id
     * @param @return    
     * @return List<Feedback>    
     * @author linhongyu
	 * @param limit 
	 * @param page 
     * @createDate 2019年6月12日
     */
    List<FeedbackVo> selectListKey(Long hone_id) throws Exception;
    
    Map<String, Object> selectListFeed(Long hone_id, Integer page, Integer limit) throws Exception;
}
