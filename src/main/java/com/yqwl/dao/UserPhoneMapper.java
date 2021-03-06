package com.yqwl.dao;

import java.util.List;

import com.yqwl.pojo.UserPhone;

public interface UserPhoneMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_phone
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_phone
     *
     * @mbggenerated
     */
    int insert(UserPhone record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_phone
     *
     * @mbggenerated
     */
    int insertSelective(UserPhone record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_phone
     *
     * @mbggenerated
     */
    UserPhone selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_phone
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(UserPhone record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_phone
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(UserPhone record);

	List<UserPhone> listByUserId(Long userId);
}