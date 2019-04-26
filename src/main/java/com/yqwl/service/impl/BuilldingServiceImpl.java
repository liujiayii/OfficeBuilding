package com.yqwl.service.impl;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.yqwl.Vo.BuildingListVo;

import com.yqwl.Vo.BuildingVo;
import com.yqwl.Vo.MapBuildingVo;
import com.yqwl.common.utils.MapUtil;
import com.yqwl.common.utils.NumberUtil;
import com.yqwl.common.utils.Pager;
import com.yqwl.common.utils.StringUtils;
import com.yqwl.dao.BrokerMapper;
import com.yqwl.dao.BuildingMapper;
import com.yqwl.dao.EntrustseeMapper;
import com.yqwl.dao.HousesNewMapper;
import com.yqwl.dao.PhotoMapper;
import com.yqwl.pojo.Broker;
import com.yqwl.pojo.Building;
import com.yqwl.pojo.HousesNew;
import com.yqwl.pojo.Photo;
import com.yqwl.pojo.Region;
import com.yqwl.service.BuildingService;

@Service("buildingService")
@Transactional(rollbackFor = { Exception.class })
public class BuilldingServiceImpl implements BuildingService {
	@Autowired
	private BuildingMapper buildingMapper;
	@Autowired
	private PhotoMapper photoMapper;
	@Autowired
	private HousesNewMapper housesNewMapper;
	@Autowired
	private BrokerMapper brokerMapper;
	@Autowired
	private EntrustseeMapper entrustseeMapper;
	
	@Override
	public PageInfo<BuildingVo> listBuildingByCondition(Pager pager) throws Exception {
		Map<String, Object> conditions = MapUtil.formSerializeToMap(pager.getFilter());
		Integer cityId = NumberUtil.dealInteger(StringUtils.getFirstString(conditions.get("cityId")));
		Integer regionId = NumberUtil.dealInteger(StringUtils.getFirstString(conditions.get("regionId")));
		Integer startSpace = NumberUtil.dealInteger(StringUtils.getFirstString(conditions.get("startSpace")));
		Integer endSpace = NumberUtil.dealInteger(StringUtils.getFirstString(conditions.get("endSpace")));
		Double startMoney1 = NumberUtil.dealDouble(StringUtils.getFirstString(conditions.get("startMoney")));
		Double endMoney1 = NumberUtil.dealDouble(StringUtils.getFirstString(conditions.get("endMoney")));
		BigDecimal startMoney=null;
		BigDecimal endMoney = null;
		if (startMoney1!=null && endMoney1 !=null) {
			startMoney = BigDecimal.valueOf(startMoney1);
			endMoney = BigDecimal.valueOf(endMoney1);
		}
		Integer fitment = NumberUtil.dealInteger(StringUtils.getFirstString(conditions.get("fitment")));
		PageHelper.startPage(pager);
		List<BuildingVo> list = buildingMapper.listBuildingByCondition(cityId,regionId,startSpace,endSpace,startMoney,endMoney,fitment);
		PageInfo<BuildingVo> result = new PageInfo<BuildingVo>(list);
		for (int i = 0; i < result.getList().size(); i++) {
			BuildingVo buildingVo = result.getList().get(i);
			List<HousesNew> housesNews = housesNewMapper.listHousesNewByBuildingId(buildingVo.getId());
			Integer count = 0;
			for (HousesNew housesNew : housesNews) {
				count += entrustseeMapper.getByHousesNewIdCount(housesNew.getId());
			}
			buildingVo.setHousesNews(housesNews);
			buildingVo.setSubscribeCount(count);
			result.getList().set(i, buildingVo);
		}
		return result;
	}

	@Override
	public PageInfo<BuildingVo> listByBuilding(Pager pager) throws Exception {
		Map<String, Object> conditions = MapUtil.formSerializeToMap(pager.getFilter());
		String condition = StringUtils.getFirstString(conditions.get("record"));
		Integer cityId = NumberUtil.dealInteger(StringUtils.getFirstString(conditions.get("cityId"))); 
		PageHelper.startPage(pager);
		List<BuildingVo> list = buildingMapper.listByBuilding(condition,cityId);
		PageInfo<BuildingVo> result = new PageInfo<BuildingVo>(list);
		for (int i = 0; i < result.getList().size(); i++) {
			BuildingVo buildingVo = result.getList().get(i);
			List<HousesNew> housesNews = housesNewMapper.listHousesNewByBuildingId(buildingVo.getId());
			Integer count = 0;
			for (HousesNew housesNew : housesNews) {
				count += entrustseeMapper.getByHousesNewIdCount(housesNew.getId());
			}
			buildingVo.setHousesNews(housesNews);
			buildingVo.setSubscribeCount(count);
			result.getList().set(i, buildingVo);
		}
		return result;
	}

	@Override
	public Integer listByHouseCount(Integer cityId) throws Exception {
		return buildingMapper.listByHouseCount(cityId);
	}


	@Override
	public BuildingListVo selectBuil(long id) {
		return buildingMapper.selectBuil(id);
	}

	@Override
	public BuildingVo getBuildingById(Long buildingId) throws Exception {
		BuildingVo buildingVo = new BuildingVo();
		Building building = buildingMapper.selectByPrimaryKey(buildingId);
		List<Photo> photos = photoMapper.listByBuildingId(buildingId);
		List<HousesNew> housesNews = housesNewMapper.listHousesNewByBuildingId(buildingId);
		Broker broker = brokerMapper.selectByPrimaryKey(building.getBroker_id());
		BeanUtils.copyProperties(building, buildingVo);
		buildingVo.setPhotos(photos);
		buildingVo.setBroker(broker);
		buildingVo.setHousesNews(housesNews);
		return buildingVo;
	}
	
	@Override
	public List<MapBuildingVo> MapSelectBuilding(Integer cityId, Integer regionId, Integer startSpace, Integer endSpace,
			BigDecimal startMoney, BigDecimal endMoney, Integer fitment) throws Exception {
		List<MapBuildingVo> buildingVos = new LinkedList<>();
		buildingVos = buildingMapper.MapSelectBuilding(cityId,regionId,startSpace,endSpace,startMoney,endMoney,fitment);
		for (MapBuildingVo mapBuildingVo : buildingVos) {
			List<HousesNew> housesNews = housesNewMapper.listHousesNewByBuildingId(mapBuildingVo.getId());
			mapBuildingVo.setHousesNews(housesNews);
		}
		return buildingVos;
	}

}
