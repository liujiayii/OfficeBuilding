package com.yqwl.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yqwl.Vo.DelegationVo;
import com.yqwl.pojo.Delegation;

/**
 *
 * @ClassName: DelegationService
 * @description 委托找房表实现接口
 *
 * @author linhongyu
 * @createDate 2019年4月10日
 */
public interface DelegationService {
	
	/**
	 * @Title: insertSelective
	 * @description 新增一条委托找房信息
	 * @param @param record
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月10日
	 */
	int insertSelective(Delegation record) throws Exception;
	/**
	 * @Title: updateFindID
	 * @description 修改委托找房当前状态
	 * @param @param record
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月10日
	 */
	int updateFindID(Delegation record) throws Exception;
	/**
	 * @Title: selectDeleAll
	 * @description 后台查询委托看房数据
	 * @param @param recorrdVo
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月20日
	 */
	List<DelegationVo> selectDeleAll(DelegationVo recorrdVo) throws Exception;
	/**
	 * @Title: selectDeleAll
	 * @description 后台查询委托看房数据条数
	 * @param @param recorrdVo
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月20日
	 */
	Integer selectCont(DelegationVo recorrdVo) throws Exception;
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
	int updateDeleBroker(@Param("broker_id")Long broker_id,@Param("id")Long id) throws Exception;
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
	Map<String, Object> selectDeleCount(@Param("broker_id")Long broker_id,@Param("page") Integer page,@Param("limit") Integer limit) throws Exception;
}
