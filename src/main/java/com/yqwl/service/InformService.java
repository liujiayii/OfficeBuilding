package com.yqwl.service;

import java.util.List;

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
	List<Inform> selectByInform(Long broker_id);
}
