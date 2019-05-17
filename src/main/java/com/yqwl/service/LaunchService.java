package com.yqwl.service;

import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.yqwl.Vo.LaunchVo;
import com.yqwl.pojo.Launch;

/**
 *
 * @ClassName: LaunchService
 * @description 投放房源接口
 *
 * @author linhongyu
 * @createDate 2019年4月10日
 */
public interface LaunchService {
	/**
	 * @Title: deleteByPrimaryKey
	 * @description 删除一天数据
	 * @param @param id
	 * @param @return
	 * @param @throws Exception    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年4月29日
	 */
	int deleteByPrimaryKey(Long id) throws Exception;
	/**
	 * @Title: insertSelective
	 * @description 新增一条投放房源数据
	 * @param @param record
	 * @param @return
	 * @param @throws Exception    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年4月29日
	 */
	int insertSelective(Launch record) throws Exception;
	/**
	 * @Title: selectLaun
	 * @description 查询后他所有投放房源信息
	 * @param @param recordVo
	 * @param @return
	 * @param @throws Exception    
	 * @return Map<String,Object>    
	 * @author linhongyu
	 * @createDate 2019年4月29日
	 */
	Map<String, Object> selectLaun(LaunchVo recordVo) throws Exception;
	/**
	 * @Title: updateStatus
	 * @description 修改该信息的处理状态
	 * @param @param records
	 * @param @return
	 * @param @throws Exception    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年4月29日
	 */
	int updateStatus(Launch records) throws Exception;
	/**
	 * @Title: updateLaunBroker
	 * @description 用于经纪人抢单
	 * @param @param broker_id
	 * @param @param id
	 * @param @return
	 * @param @throws Exception    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年4月29日
	 */
	int updateLaunBroker(@Param("broker_id")Long broker_id,@Param("id")Long id) throws Exception;
	/**
	 * @Title: selectMyLaun
	 * @description 用一句话描述这个方法的作用
	 * @param @param broker_id
	 * @param @param page
	 * @param @param limit
	 * @param @return
	 * @param @throws Exception    
	 * @return Map<String,Object>    
	 * @author linhongyu
	 * @createDate 2019年4月29日
	 */
	Map<String, Object> selectMyLaun(@Param("broker_id")Long broker_id,@Param("page") Integer page,@Param("limit") Integer limit) throws Exception;
}
