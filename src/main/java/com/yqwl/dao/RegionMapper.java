package com.yqwl.dao;

import java.util.List;

import com.yqwl.pojo.Region;

public interface RegionMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_region
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer area_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_region
	 * @mbggenerated
	 */
	int insert(Region record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_region
	 * @mbggenerated
	 */
	int insertSelective(Region record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_region
	 * @mbggenerated
	 */
	Region selectByPrimaryKey(Integer area_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_region
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(Region record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_region
	 * @mbggenerated
	 */
	int updateByPrimaryKey(Region record);

	List<Region> listRegionByPid(String pid);
}