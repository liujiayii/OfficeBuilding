package com.yqwl.dao;

import java.util.List;

import com.yqwl.pojo.DivideInto;

public interface DivideIntoMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_divide_into
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_divide_into
	 * @mbggenerated
	 */
	int insert(DivideInto record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_divide_into
	 * @mbggenerated
	 */
	int insertSelective(DivideInto record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_divide_into
	 * @mbggenerated
	 */
	DivideInto selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_divide_into
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(DivideInto record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_divide_into
	 * @mbggenerated
	 */
	int updateByPrimaryKey(DivideInto record);

	List<DivideInto> listDivideIntoByCondition();

	/**
	 *
	 * @Title: selectStatus
	 * @description 查询分成配置
	 * @param     
	 * @return void    
	 * @author linhongyu
	 * @createDate 2019年6月20日
	 */
	DivideInto selectStatus();
}