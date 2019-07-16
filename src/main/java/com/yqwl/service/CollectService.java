package com.yqwl.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yqwl.Vo.CollectVo;
import com.yqwl.pojo.Collect;

/**
 *
 * @ClassName: CollectService
 * @description 用一句话描述这个类的作用
 * @author linhongyu
 * @createDate 2019年6月12日
 */
public interface CollectService {
	/**
	 * @Title: insertSelective
	 * @description 经纪人收藏房源
	 * @param @param record
	 * @param @return    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年6月12日
	 */
	int insertSelective(Collect record) throws Exception;
	/**
	 * @Title: deleteByPrimaryKey
	 * @description 经纪人取消收藏
	 * @param @param id
	 * @param @return    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年6月12日
	 */
	int deleteByPrimaryKey(Long id) throws Exception;
	/**
     * @Title: selectListCo
     * @description 查询经纪人收藏房源信息
     * @param @param broker_id
     * @param @return    
     * @return List<CollectVo>    
     * @author linhongyu
	 * @param limit 
	 * @param page 
     * @createDate 2019年6月13日
     */
    Map<String, Object> selectListCo(@Param("broker_id") Long broker_id, @Param("page")Integer page, @Param("limit")Integer limit) throws Exception;
    /**
     * @Title: selectTwo
     * @description 判断房源是否已收藏
     * @param @param broker_id
     * @param @param home_id
     * @param @return    
     * @return Collect    
     * @author linhongyu
     * @createDate 2019年6月13日
     */
    Collect selectTwo(Collect record) throws Exception;
}
