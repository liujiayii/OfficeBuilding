package com.yqwl.dao;

import java.util.List;

import com.yqwl.Vo.AttentionVo;
import com.yqwl.pojo.Attention;

public interface AttentionMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_attention
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_attention
	 * @mbggenerated
	 */
	int insert(Attention record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_attention
	 * @mbggenerated
	 */
	int insertSelective(Attention record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_attention
	 * @mbggenerated
	 */
	Attention selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_attention
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(Attention record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_attention
	 * @mbggenerated
	 */
	int updateByPrimaryKey(Attention record);
	
	Attention selectFinfAll(Attention record);
	
	List<AttentionVo> selectScend(AttentionVo records);
	
	List<AttentionVo> selectThird(AttentionVo records);
	
	Integer selectCount(AttentionVo records);
}