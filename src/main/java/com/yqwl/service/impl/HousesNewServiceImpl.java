package com.yqwl.service.impl;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yqwl.Vo.HousesNewVo;
import com.yqwl.common.utils.MapUtil;
import com.yqwl.common.utils.NumberUtil;
import com.yqwl.common.utils.Pager;
import com.yqwl.common.utils.StringUtils;
import com.yqwl.dao.BuildingMapper;
import com.yqwl.dao.HousesNewMapper;
import com.yqwl.pojo.HousesNew;
import com.yqwl.service.HousesNewService;

/**
 * @ClassName: HousesNewServiceImpl
 * @description 用一句话描述这个类的作用
 * @author 姓名全拼
 * @createDate 2019年4月9日
 */
@Service("housesNewService")
public class HousesNewServiceImpl implements HousesNewService{

	@Resource
	private HousesNewMapper housesNewMapper;
	@Resource
	private BuildingMapper buildingMapper;
	@Override
	public HousesNewVo selectByFindID(long id) throws Exception{
		/*HousesNewVo result = new HousesNewVo();
		HousesNew housesNew = housesNewMapper.selectByPrimaryKey(id);
		Building building = buildingMapper.selectByPrimaryKey(housesNew.getBuilding_id());
		BeanUtils.copyProperties(result, housesNew);
		result.setBuilding(building);*/
		return housesNewMapper.selectByFindID(id);
	}
	
	
	@Override
	public PageInfo<HousesNew> listHousesNewByCondition(Pager pager) throws Exception {
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
		List<HousesNew> list = housesNewMapper.listHousesNewByCondition(cityId,regionId,startSpace,endSpace,startMoney,endMoney,fitment);
		return new PageInfo<HousesNew>(list);
	}


	/* (non-Javadoc)
	 * @see com.yqwl.service.HousesNewService#selectLike(com.yqwl.Vo.HousesNewVo)
	 */
	@Override
	public List<HousesNewVo> selectLike(HousesNewVo record) {
		return housesNewMapper.selectLike(record);
	}


	@Override
	public List<HousesNew> getMapById(Long buildingId) throws Exception {
		return housesNewMapper.listHousesNewByBuildingId(buildingId);
	}

}
