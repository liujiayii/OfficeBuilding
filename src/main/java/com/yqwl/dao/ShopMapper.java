package com.yqwl.dao;

import java.util.List;

import com.yqwl.Vo.ShopVo;
import com.yqwl.pojo.Shop;

public interface ShopMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_shop
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_shop
     *
     * @mbggenerated
     */
    int insert(Shop record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_shop
     *
     * @mbggenerated
     */
    int insertSelective(Shop record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_shop
     *
     * @mbggenerated
     */
    Shop selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_shop
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Shop record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_shop
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Shop record);

	List<ShopVo> listAllPage();
	
	List<Shop> listAll();
}