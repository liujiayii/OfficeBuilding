package com.yqwl.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yqwl.Vo.BuildingListVo;
import com.yqwl.Vo.BuildingVo;
import com.yqwl.Vo.MapBuildingVo;
import com.yqwl.pojo.Building;

public interface BuildingMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_building
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Long id) throws Exception;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_building
	 * @mbggenerated
	 */
	int insert(Building record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_building
	 * @mbggenerated
	 */
	int insertSelective(Building record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_building
	 * @mbggenerated
	 */
	Building selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_building
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(Building record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_building
	 * @mbggenerated
	 */
	int updateByPrimaryKey(Building record);

	List<BuildingVo> listBuildingByCondition(@Param("cityId")Integer cityId , @Param("regionId")Integer regionId,@Param("startSpace") Integer startSpace,@Param("endSpace") Integer endSpace,@Param("startMoney") BigDecimal startMoney,
			@Param("endMoney")BigDecimal endMoney,@Param("fitment") Integer fitment);

	List<BuildingVo> listByBuilding(@Param("condition")String condition,@Param("cityId")Integer cityId);

	Integer listByHouseCount(Integer cityId);
	
	BuildingListVo selectBuil(Long id);

	List<MapBuildingVo> MapSelectBuilding(@Param("cityId")Integer cityId,@Param("regionId") Integer regionId,@Param("startSpace") Integer startSpace,@Param("endSpace") Integer endSpace,
			@Param("startMoney")BigDecimal startMoney,@Param("endMoney") BigDecimal endMoney,@Param("fitment") Integer fitment);
	/**
	 * @Title: selectBuilding
	 * @description 通过城市查询商厦信息
	 * @param @param building
	 * @param @return    
	 * @return List<BuildingListVo>    
	 * @author linhongyu
	 * @createDate 2019年4月25日
	 */
	List<BuildingListVo> selectBuilding(BuildingListVo building);
	/**
	 * @Title: selectBuilding
	 * @description 通过城市查询商厦信息条数
	 * @param @param building
	 * @param @return    
	 * @return List<BuildingListVo>    
	 * @author linhongyu
	 * @createDate 2019年4月25日
	 */
	Integer selectContBuil(BuildingListVo building);

	List<Building> listAllByCityId(Long cityId);
	
	
}