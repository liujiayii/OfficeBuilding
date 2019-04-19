package com.yqwl.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yqwl.Vo.MainNewVo;
import com.yqwl.Vo.MainVo;
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
		List<HomePageRecommended> homePageRecommendeds = homePageRecommendedMapper.listByType(type);
		MainVo mainVo = new MainVo();
		switch (type) {
		case 3:
			HousesNew housesNew = new HousesNew();
			for (HomePageRecommended homePageRecommended : homePageRecommendeds) {
				housesNew = housesNewMapper.selectByPrimaryKey(homePageRecommended.getBuilding_id());
				mainVo.setHousesNew(housesNew);
				BeanUtils.copyProperties(homePageRecommended, mainVo);
				list.add(mainVo);
			}
			break;
		default:
			Building building = new Building();
			for (HomePageRecommended homePageRecommended : homePageRecommendeds) {
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
	public Existing homePageCity() throws Exception {
		return existingMapper.homePageCity();
	}
	
	
}