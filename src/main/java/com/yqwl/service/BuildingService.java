package com.yqwl.service;

import java.math.BigDecimal;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yqwl.Vo.BuildingListVo;
import com.yqwl.Vo.BuildingVo;
import com.yqwl.Vo.MapBuildingVo;
import com.yqwl.common.utils.Pager;
import com.yqwl.pojo.Building;
import com.yqwl.pojo.Region;

public interface BuildingService {

	PageInfo<BuildingVo> listBuildingByCondition(Pager pager) throws Exception;

	PageInfo<BuildingVo> listByBuilding(Pager pager) throws Exception;

	Integer listByHouseCount(Integer cityId) throws Exception;

	BuildingVo getBuildingById(Long buildingId) throws Exception;
	List<MapBuildingVo> MapSelectBuilding(Integer cityId, Integer regionId, Integer startSpace, Integer endSpace, BigDecimal startMoney, BigDecimal endMoney, Integer fitment) throws Exception;
	/**
	 *
	 * @Title: selectBuil
	 * @description 用一句话描述这个方法的作用
	 *
	 * @param @param id
	 * @param @return    
	 * @return BuildingListVo    
	 *
	 * @author 姓名全拼
	 * @createDate 2019年4月15日
	 */
	BuildingListVo selectBuil(long id);

}
