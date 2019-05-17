package com.yqwl.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yqwl.pojo.Entrustsee;

/**
 *
 * @ClassName: EntrustseeService
 * @description 预约功能Service接口
 *
 * @author linhongyu
 * @createDate 2019年4月10日
 */
public interface EntrustseeService {
	/**
	 * @Title: insert
	 * @description 用一句话描述这个方法的作用
	 * @param @param record
	 * @param @return
	 * @param @throws Exception    
	 * @return int    
	 * @author 
	 * @createDate 2019年4月25日
	 */
	int insert(Entrustsee record) throws Exception;
	/**
	 * @Title: updateType
	 * @description 修改预约看房状态
	 * @param @param seetype
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月10日
	 */
	int updateType(Entrustsee record) throws Exception;
	/**
	 * @Title: selectAllEN
	 * @description 后台查询所有预约看房
	 * @param @param record
	 * @param @param page
	 * @param @param limit
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月10日
	 */
	Map<String, Object> selectAllEN(Long broker_id,Integer page,Integer limit) throws Exception;
	/**
	 * @Title: updateBoerk
	 * @description 抢单成功
	 * @param @param broker_id
	 * @param @param id
	 * @param @param session
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月24日
	 */
	int updateBoerk(@Param("broker_id")Long broker_id,@Param("id")Long id) throws Exception;
	/**
	 *
	 * @Title: selectBroker
	 * @description 查询经纪人预约数据
	 * @param @param broker_id    
	 * @return void    
	 * @author linhongyu
	 * @createDate 2019年4月24日
	 */
	Map<String, Object> selectBroker(@Param("broker_id")Long broker_id,@Param("page") Integer page,@Param("limit") Integer limit) throws Exception;
}
