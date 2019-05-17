package com.yqwl.service.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yqwl.Vo.MainNewVo;
import com.yqwl.Vo.MainVo;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.common.utils.Pager;
import com.yqwl.common.utils.UpdateFile;
import com.yqwl.common.web.BizException;
import com.yqwl.dao.BuildingMapper;
import com.yqwl.dao.ExistingMapper;
import com.yqwl.dao.HomePageRecommendedMapper;
import com.yqwl.dao.HousesNewMapper;
import com.yqwl.dao.JournalismMapper;
import com.yqwl.pojo.Building;
import com.yqwl.pojo.Existing;
import com.yqwl.pojo.HomePageRecommended;
import com.yqwl.pojo.HousesNew;
import com.yqwl.pojo.Journalism;
import com.yqwl.service.HomePageRecommendedService;

@Service("homePageRecommendedService")
@Transactional(rollbackFor = { Exception.class })
public class HomePageRecommendedServiceImpl implements HomePageRecommendedService {
	@Autowired
	private HomePageRecommendedMapper homePageRecommendedMapper;
	@Autowired
	private BuildingMapper buildingMapper;
	@Autowired
	private HousesNewMapper housesNewMapper;
	@Autowired
	private JournalismMapper journalismMapper;
	@Autowired
	private ExistingMapper existingMapper;
	@Override
	public List<MainVo> homePageRecommended(Integer cityId, Integer type) throws Exception {
		List<MainVo> list = new LinkedList<>();
		//根据TYPE查询首页推荐房源或者楼盘
		List<HomePageRecommended> homePageRecommendeds = homePageRecommendedMapper.listByTypeAndCityId(type,cityId);
		switch (type) {
		case 3:
			//循环查询房源信息
			for (HomePageRecommended homePageRecommended : homePageRecommendeds) {
				MainVo mainVo = new MainVo();
				HousesNew housesNew = new HousesNew();
				housesNew = housesNewMapper.selectByPrimaryKey(homePageRecommended.getBuilding_id());
				mainVo.setHousesNew(housesNew);
				BeanUtils.copyProperties(homePageRecommended, mainVo);
				list.add(mainVo);
			}
			break;
		default:
			//循环查询楼盘信息
			for (HomePageRecommended homePageRecommended : homePageRecommendeds) {
				MainVo mainVo = new MainVo();
				Building building = new Building();
				building = buildingMapper.selectByPrimaryKey(homePageRecommended.getBuilding_id());
				mainVo.setBuilding(building);
				BeanUtils.copyProperties(homePageRecommended, mainVo);
				list.add(mainVo);
			}
			break;
		}
		return list;
	}

	@Override
	public MainNewVo homePageNew() throws Exception {
		MainNewVo mainNewVo = new MainNewVo();
		Journalism journalism = journalismMapper.getByTime();
		BeanUtils.copyProperties(journalism, mainNewVo);
		//行业风云
		List<Journalism> list = journalismMapper.listBytype(1);
		//找房攻略
		List<Journalism> list1 = journalismMapper.listBytype(2);
		mainNewVo.setIndustry(list);
		mainNewVo.setStrategy(list1);
		return mainNewVo;
	}

	@Override
	public List<Existing> homePageCity() throws Exception {
		return existingMapper.homePageCity();
	}

	@Override
	public Integer insert(HomePageRecommended homePageRecommended) throws Exception {
		List<HomePageRecommended> homePageRecommendeds = homePageRecommendedMapper.listByTypeAndCityId(homePageRecommended.getType(), homePageRecommended.getCity_id());
		switch (homePageRecommended.getType()) {
		case 1:
			if (homePageRecommendeds.size()>=3) throw new BizException(FastJsonUtil.getResponseJson("2000", "推荐位置已满")); 
			break;

		case 2:
			if (homePageRecommendeds.size()>=5) throw new BizException(FastJsonUtil.getResponseJson("2000", "推荐位置已满")); 
			break;
		}
		homePageRecommended.setTime(new Date());
		return homePageRecommendedMapper.insertSelective(homePageRecommended);
	}

	@Override
	public Integer delete(Long id) throws Exception {
		HomePageRecommended homePageRecommended = homePageRecommendedMapper.selectByPrimaryKey(id);
		UpdateFile.deleatFile(homePageRecommended.getImg());
		return homePageRecommendedMapper.deleteByPrimaryKey(id);
	}

	@Override
	public PageInfo<Existing> pagerListAll(Pager pager) throws Exception {
		PageHelper.startPage(pager);
		List<Existing> list = existingMapper.homePageCity();
		return new PageInfo<Existing>(list);
	}

	@Override
	public Integer insert(Existing existing) throws Exception {
		return existingMapper.insertSelective(existing);
	}

	@Override
	public Integer deleteExisting(Long id) throws Exception {
		Existing existing = existingMapper.selectByPrimaryKey(id);
		List<Building> buildings = buildingMapper.listAllByCityId((long)existing.getCity_id());
		if (buildings.size()>0) throw new BizException(FastJsonUtil.getResponseJson("2000", "该地区还有写字楼不能删除"));
		return existingMapper.deleteByPrimaryKey(id);
	}
	
	
}