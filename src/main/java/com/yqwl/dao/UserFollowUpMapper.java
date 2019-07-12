package com.yqwl.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yqwl.pojo.UserFollowUp;

public interface UserFollowUpMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_follow_up
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_follow_up
	 * @mbggenerated
	 */
	int insert(UserFollowUp record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_follow_up
	 * @mbggenerated
	 */
	int insertSelective(UserFollowUp record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_follow_up
	 * @mbggenerated
	 */
	UserFollowUp selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_follow_up
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(UserFollowUp record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_follow_up
	 * @mbggenerated
	 */
	int updateByPrimaryKey(UserFollowUp record);

	List<UserFollowUp> listByUserId(Long id);

	UserFollowUp getByUserIdOrNew(Long userId);
	/**
	 * @Title: selectUserFollowCount
	 * @description 查询经纪人客源跟进条数
	 * @param @param broker_id
	 * @param @param startTime
	 * @param @param endTime
	 * @param @return    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年7月11日
	 */
	int selectUserFollowCount(@Param("broker_id")Long broker_id,@Param("startTime")Date startTime,@Param("endTime")Date endTime);
}