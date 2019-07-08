package com.yqwl.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yqwl.Vo.SucceedDealVo;
import com.yqwl.pojo.SucceedDeal;

public interface SucceedDealMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_succeed_deal
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_succeed_deal
	 * @mbggenerated
	 */
	int insert(SucceedDeal record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_succeed_deal
	 * @mbggenerated
	 */
	int insertSelective(SucceedDeal record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_succeed_deal
	 * @mbggenerated
	 */
	SucceedDeal selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_succeed_deal
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(SucceedDeal record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_succeed_deal
	 * @mbggenerated
	 */
	int updateByPrimaryKey(SucceedDeal record);

	List<SucceedDealVo> listAll(@Param("shopId")Long shopId,@Param("groupId") Long groupId,@Param("brokerId") Long brokerId,@Param("startTime") Date startTime,@Param("endTime") Date endTime,@Param("pack") String pack);

	/**
	 * @Title: selectByPrimaryCount
	 * @description 通过经纪人id查询成交单数
	 * @param @param id
	 * @param @param startTime
	 * @param @param endTime
	 * @param @return    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年6月17日
	 */
	int selectByPrimaryCount(@Param("id")Long id , @Param("startTime")Date startTime, @Param("endTime")Date endTime);
	/**
	 * @Title: selectByPrimarySum
	 * @description 通过经纪人id查询成交佣金
	 * @param @param id
	 * @param @param startTime
	 * @param @param endTime
	 * @param @return    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年6月17日
	 */
	int selectByPrimarySum(@Param("id")Long id , @Param("startTime")Date startTime, @Param("endTime")Date endTime);
}