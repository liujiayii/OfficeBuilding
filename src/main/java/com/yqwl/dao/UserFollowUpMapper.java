package com.yqwl.dao;

import java.util.List;

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
}