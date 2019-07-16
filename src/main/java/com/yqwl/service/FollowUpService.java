package com.yqwl.service;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yqwl.Vo.FollowUpVo;
import com.yqwl.pojo.FollowUp;
/**
 *
 * @ClassName: FollowUpService
 * @description 经纪人跟进表service层
 * @author linhongyu
 * @createDate 2019年6月9日
 */
public interface FollowUpService {
	/**
	 * @Title: insertSelective
	 * @description 新增一条跟进信息
	 * @param @param record
	 * @param @return
	 * @param @throws Exception    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年6月10日
	 */
	int insertSelective(FollowUp record) throws Exception;
	/**
	 * @Title: selectFollow
	 * @description 通过经纪人id查询跟进信息
	 * @param @param broker_id
	 * @param @return
	 * @param @throws Exception    
	 * @return FollowUp    
	 * @author linhongyu
	 * @createDate 2019年6月10日
	 */
	FollowUp selectFollow(Long broker_id) throws Exception;
	/**
	 * @Title: updateByPrimaryKeySelective
	 * @description 修改完善跟进信息
	 * @param @param record
	 * @param @return    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年6月10日
	 */
	int updateByPrimaryKeySelective(FollowUp record) throws Exception;
	/**
	 * @Title: selectByPrimaryKey
	 * @description 通过主键id查询一条跟进数据
	 * @param @param id
	 * @param @return    
	 * @return FollowUp    
	 * @author linhongyu
	 * @createDate 2019年6月10日
	 */
	FollowUp selectByPrimaryKey(Long id) throws Exception;
	/**
     * @Title: selectHomeId
     * @description 查询该房源的跟进信息
     * @param @param home_id
     * @param @return    
     * @return FollowUpVo    
     * @author linhongyu
     * @createDate 2019年6月11日
     */
    Map<String, Object> selectHomeId(Long home_id,Integer page,Integer limit) throws Exception;
    /**
     * @Title: selectByPrimaryCount
     * @description 查询经纪人房源跟进统计
     * @param @param shopId
     * @param @param startTime
     * @param @param endTime
     * @param @return    
     * @return List<Map<String,Object>>    
     * @author linhongyu
     * @createDate 2019年7月10日
     */
    public List<Map<String, Object>> selectByPrimaryCount(Long shopId,Date startTime,Date endTime) throws Exception;
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
    public List<Map<String, Object>> selectByUserCount(Long shopId,Date startTime,Date endTime) throws Exception;
}
