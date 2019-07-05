package com.yqwl.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yqwl.Vo.InformVo;
import com.yqwl.pojo.Inform;

/**
 *
 * @ClassName: InformsService
 * @description 撤单表的Service层接口
 * @author linhongyu
 * @createDate 2019年6月10日
 */
public interface InformService {
	
	/**
	 * @Title: selectByInform
	 * @description 通过经纪人id查询是否有被通知撤单的数据
	 * @param @param broker_id
	 * @param @return    
	 * @return List<Inform>    
	 * @author linhongyu
	 * @createDate 2019年6月10日
	 */
	List<InformVo> selectByInform(Long broker_id) throws Exception;
	/**
     * @Title: deleteKey
     * @description 取消撤单
     * @param @param broker_id
     * @param @param home_id
     * @param @return    
     * @return int    
     * @author linhongyu
     * @createDate 2019年7月4日
     */
	int deleteInform(@Param("broker_id")Long broker_id,@Param("home_id")Long home_id) throws Exception;
}
