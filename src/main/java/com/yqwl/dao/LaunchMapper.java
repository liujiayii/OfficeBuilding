package com.yqwl.dao;

import com.yqwl.pojo.Launch;

public interface LaunchMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_launch
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_launch
	 * @mbggenerated
	 */
	int insert(Launch record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_launch
	 * @mbggenerated
	 */
	int insertSelective(Launch record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_launch
	 * @mbggenerated
	 */
	Launch selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_launch
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(Launch record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_launch
	 * @mbggenerated
	 */
	int updateByPrimaryKeyWithBLOBs(Launch record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_launch
	 * @mbggenerated
	 */
	int updateByPrimaryKey(Launch record);
}