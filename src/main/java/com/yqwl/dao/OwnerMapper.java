package com.yqwl.dao;

import java.util.List;

import com.yqwl.pojo.Owner;

public interface OwnerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_owner
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_owner
     *
     * @mbggenerated
     */
    int insert(Owner record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_owner
     *
     * @mbggenerated
     */
    int insertSelective(Owner record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_owner
     *
     * @mbggenerated
     */
    Owner selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_owner
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Owner record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_owner
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Owner record);
    
    List<Owner> selectHome(Long id);
}