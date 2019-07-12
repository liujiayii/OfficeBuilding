package com.yqwl.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
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
import com.yqwl.common.utils.UpdateFiles;
import com.yqwl.dao.AttentionMapper;
import com.yqwl.dao.BrokerMapper;
import com.yqwl.dao.BuildingMapper;
import com.yqwl.dao.EntrustseeMapper;
import com.yqwl.dao.HomePageRecommendedMapper;
import com.yqwl.dao.HousesNewMapper;
import com.yqwl.dao.PhotoMapper;
import com.yqwl.pojo.Attention;
import com.yqwl.pojo.Broker;
import com.yqwl.pojo.Building;
import com.yqwl.pojo.HomePageRecommended;
import com.yqwl.pojo.HousesNew;
import com.yqwl.pojo.Photo;
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
	@Autowired
	private AttentionMapper attentionMapper;
	@Autowired
	private HomePageRecommendedMapper homePageRecommendedMapper;
	/**
	 * 楼盘条件搜索 (分页)
	 */
	@Override
	public PageInfo<BuildingVo> listBuildingByCondition(Pager pager) throws Exception {
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
		List<BuildingVo> list = buildingMapper.listBuildingByCondition(cityId,regionId,startSpace,endSpace,startMoney,endMoney,fitment);
		PageInfo<BuildingVo> result = new PageInfo<BuildingVo>(list);
		//遍历查询每个楼盘的房源
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
	/**
	 * 搜索框搜索楼盘
	 */
	@Override
	public PageInfo<BuildingVo> listByBuilding(Pager pager) throws Exception {
		//获取参数
		Map<String, Object> conditions = MapUtil.formSerializeToMap(pager.getFilter());
		String condition = new String(StringUtils.getFirstString(conditions.get("record")).trim().getBytes("ISO-8859-1"), "UTF-8");
		Integer cityId = NumberUtil.dealInteger(StringUtils.getFirstString(conditions.get("cityId"))); 
		//分页
		PageHelper.startPage(pager);
		List<BuildingVo> list = buildingMapper.listByBuilding(condition,cityId);
		PageInfo<BuildingVo> result = new PageInfo<BuildingVo>(list);
		//遍历查询每个楼盘的房源
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
	/**
	 * 一个城市有多少房源
	 */
	@Override
	public Integer listByHouseCount(Integer cityId) throws Exception {
		return buildingMapper.listByHouseCount(cityId);
	}

	/**
	 *
	 * @Title: selectBuil
	 * @description 通过id查询信息
	 *
	 * @param @param id
	 * @param @return    
	 * @return BuildingListVo    
	 *
	 * @author linhongyu
	 * @createDate 2019年4月15日
	 */
	@Override
	public BuildingListVo selectBuil(Long id) throws Exception{
		return buildingMapper.selectBuil(id);
	}
	/**
	 * 楼盘详情
	 */
	@Override
	public BuildingVo getBuildingById(Long buildingId) throws Exception {
		BuildingVo buildingVo = new BuildingVo();
		//楼盘详情
		Building building = buildingMapper.selectByPrimaryKey(buildingId);
		//楼盘图片
		List<Photo> photos = photoMapper.listByBuildingId(buildingId);
		//楼盘房源
		List<HousesNew> housesNews = housesNewMapper.listHousesNewByBuildingId(buildingId);
		//查询经纪人
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
	/**
	 * @Title: insertSelective
	 * @description 新增一条商厦信息
	 * @param @param building
	 * @param @return    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年4月25日
	 */
	@Override
	public int insertSelective(Building record) throws Exception {
		return buildingMapper.insertSelective(record);
	}
	/**
	 * @Title: updateByPrimaryKeySelective
	 * @description 修改一条商厦信息
	 * @param @param building
	 * @param @return    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年4月25日
	 */
	@Override
	public int updateByPrimaryKeySelective(Building record) throws Exception {
		int num=buildingMapper.updateByPrimaryKeySelective(record);
		long id=record.getId();
		if(num!=0){
			List<Photo> photos=photoMapper.selectPhoto(id);
			if(photos.size()>0){
				for(int i=0;i<photos.size();i++){
					String urls=photos.get(i).getPhoto();
					UpdateFiles.deleatFile(urls);
					Long ids=photos.get(i).getId();
					photoMapper.deleteByPrimaryKey(ids);
				}
			}
		}
		return num;
	}
	/**
	 * @Title: selectByPrimaryKey
	 * @description 通过id查询商厦详情
	 * @param @param building
	 * @param @return    
	 * @return Building    
	 * @author linhongyu
	 * @createDate 2019年4月25日
	 */
	@Override
	public Map<String, Object> selectByPrimaryKey(Long id) throws Exception{
		Building building = buildingMapper.selectByPrimaryKey(id);
		List<Photo> photos = photoMapper.selectPhoto(id);
		Map<String, Object> map = new HashMap<>();
		map.put("data", building);
		map.put("photos", photos);
		return map;
	}
	/**
	 * @Title: selectBuilding
	 * @description 通过城市查询商厦信息
	 * @param @param building
	 * @param @return    
	 * @return List<BuildingListVo>    
	 * @author linhongyu
	 * @createDate 2019年4月25日
	 */
	@Override
	public List<BuildingListVo> selectBuilding(BuildingListVo building) throws Exception {
		return buildingMapper.selectBuilding(building);
	}
	/**
	 * @Title: selectBuilding
	 * @description 通过城市查询商厦信息条数
	 * @param @param building
	 * @param @return    
	 * @return List<BuildingListVo>    
	 * @author linhongyu
	 * @createDate 2019年4月25日
	 */
	@Override
	public Integer selectContBuil(BuildingListVo building) throws Exception {
		return buildingMapper.selectContBuil(building);
	}
	/**
	 * @Title: deleteByPrimaryKey
	 * @description 删除一条商厦信息
	 * @param @param id
	 * @param @return
	 * @param @throws Exception    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年4月30日
	 */
	@Override
	public int deleteByPrimaryKey(Long id) throws Exception {
		int num=0;
		Long buildingId=id;
		List<HousesNew> housesNews=housesNewMapper.selectHousesNew(buildingId);
		if(housesNews.size()!=0){
			num=-101;
			return num;  //该商厦下有关联房源
		}else {
			Long houses_new_id=id;
			List<Attention> attentions=attentionMapper.selectAtten(houses_new_id);
			if(attentions.size()!=0){
				num=-102;
				return num;  //该商厦有人关注
			}else {
				Long building_id=id;
				HomePageRecommended s=homePageRecommendedMapper.selectRecommended(building_id);	
				if(s!=null){
					num=-103;
					return num;  //该商厦首页推荐
				}
			}
		}
		Building building=buildingMapper.selectByPrimaryKey(id);
		String url=building.getMansion_picture();
		UpdateFiles.deleatFile(url);
		num=buildingMapper.deleteByPrimaryKey(id);
		if(num==1){
			List<Photo> photos=photoMapper.selectPhoto(id);
			for(int i=0;i<photos.size();i++){
				String urls=photos.get(i).getPhoto();
				UpdateFiles.deleatFile(urls);
				Long ids=photos.get(i).getId();
				photoMapper.deleteByPrimaryKey(ids);
			}
		}
		return num;
	}
	@Override
	public List<Building> listAllByCityId(Long cityId) throws Exception {
		return buildingMapper.listAllByCityId(cityId);
	}
	@Override
	public List<Building> listAllByRegionId(Long regionId) throws Exception {
		return buildingMapper.listAllByRegionId(regionId);
	}
	@Override
	public List<Building> listBybuildingByCity(Integer cityId,Integer regionId) throws Exception {
		return buildingMapper.listBybuildingByCity(cityId,regionId);
	}

}
