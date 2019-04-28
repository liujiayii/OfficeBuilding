package com.yqwl.service.impl;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yqwl.Vo.HousesNewVo;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.common.utils.MapUtil;
import com.yqwl.common.utils.NumberUtil;
import com.yqwl.common.utils.Pager;
import com.yqwl.common.utils.StringUtils;
import com.yqwl.common.utils.UpdateFiles;
import com.yqwl.dao.BuildingMapper;
import com.yqwl.dao.HousesNewMapper;
import com.yqwl.dao.PictureMapper;
import com.yqwl.pojo.HousesNew;
import com.yqwl.pojo.Picture;
import com.yqwl.service.HousesNewService;
import com.yqwl.service.PictureService;

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
	@Autowired
	private PictureMapper pictureMapper;
	@Override
	public HousesNewVo selectByFindID(long id) throws Exception{
		/*HousesNewVo result = new HousesNewVo();
		HousesNew housesNew = housesNewMapper.selectByPrimaryKey(id);
		Building building = buildingMapper.selectByPrimaryKey(housesNew.getBuilding_id());
		BeanUtils.copyProperties(result, housesNew);
		result.setBuilding(building);*/
		return housesNewMapper.selectByFindID(id);
	}
	
	/**
	 * 列表查询房源
	 */
	@Override
	public PageInfo<HousesNew> listHousesNewByCondition(Pager pager) throws Exception {
		//获取参数
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
		//分页
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

	/**
	 * 地图找房点击查询详细信息
	 */
	@Override
	public List<HousesNew> getMapById(Long buildingId) throws Exception {
		return housesNewMapper.listHousesNewByBuildingId(buildingId);
	}
	
	/**
	 * 
	 * @Title: insertSelective
	 *
	 * @description 后台新增房源信息及图片信息
	 *
	 * @param @param record
	 * @param @param brokerId
	 * @param @param urls
	 * @param @return 
	 * 
	 * @return int    
	 *
	 * @author yaozijun
	 *
	 * @createDate 2019年4月23日
	 */
	@Override
	public int insertSelective(HousesNew record, Long brokerId, String... urls) {
		Integer count = housesNewMapper.insertSelective(record);
		/** 判断(房源表)插入成功后向(房源图片储存表)插入图片 */
		if (count!=0) {
			for (String url : urls) {
				Picture picture = new Picture();
				picture.setBroker_id(brokerId);
				picture.setHouses_new_id(record.getId());
				picture.setPicture(url);
				pictureMapper.insertSelective(picture);
			}
		}
		
		return count;
	}
	
	/**
	 * 
	 * @Title: updateByPrimaryKeySelective
	 *
	 * @description 后台修改房源信息及图片信息
	 *
	 * @param @param record
	 * @param @param brokerId
	 * @param @param urls
	 * @param @return
	 * @param @throws Exception 
	 * 
	 * @return int    
	 *
	 * @author yaozijun
	 *
	 * @createDate 2019年4月23日
	 */
	@Override
	public int updateByPrimaryKeySelective(HousesNew record, Long brokerId, String... urls) throws Exception{
		Integer count = housesNewMapper.updateByPrimaryKey(record);
		/** 判断(房源表)插入成功后向(房源图片储存表)插入图片 */
		if (count!=0) {
			/** 修改图片相当于新增图片，不删除之前保存的 */
			for (String url : urls) {
				Picture picture = new Picture();
				picture.setBroker_id(brokerId);
				picture.setHouses_new_id(record.getId());
				picture.setPicture(url);
				pictureMapper.insertSelective(picture);
			}
		}
		return count;
	}

}
