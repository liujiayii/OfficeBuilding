package com.yqwl.dao;

import com.yqwl.pojo.SuccedDealCost;

public interface SuccedDealCostMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_succed_deal_cost
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_succed_deal_cost
	 * @mbggenerated
	 */
	int insert(SuccedDealCost record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_succed_deal_cost
	 * @mbggenerated
	 */
	int insertSelective(SuccedDealCost record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_succed_deal_cost
	 * @mbggenerated
	 */
	SuccedDealCost selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_succed_deal_cost
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(SuccedDealCost record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_succed_deal_cost
	 * @mbggenerated
	 */
	int updateByPrimaryKey(SuccedDealCost record);
}