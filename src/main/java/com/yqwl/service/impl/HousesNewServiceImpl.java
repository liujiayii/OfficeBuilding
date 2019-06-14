package com.yqwl.service.impl;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yqwl.Vo.BackHousesVo;
import com.yqwl.Vo.HousesNewVo;
import com.yqwl.common.utils.BeanUtil;
import com.yqwl.common.utils.DateUtil;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.common.utils.MapUtil;
import com.yqwl.common.utils.NumberUtil;
import com.yqwl.common.utils.Pager;
import com.yqwl.common.utils.StringUtils;
import com.yqwl.common.utils.UpdateFile;
import com.yqwl.common.web.BizException;
import com.yqwl.dao.AttentionMapper;
import com.yqwl.dao.BrokerMapper;
import com.yqwl.dao.BuildingMapper;
import com.yqwl.dao.EntrustseeMapper;
import com.yqwl.dao.HomePageRecommendedMapper;
import com.yqwl.dao.HousesNewMapper;
import com.yqwl.dao.PictureMapper;
import com.yqwl.dao.PlotBuildMapper;
import com.yqwl.dao.PlotDoorMapper;
import com.yqwl.dao.ShopMapper;
import com.yqwl.pojo.HomePageRecommended;
import com.yqwl.pojo.HousesNew;
import com.yqwl.pojo.Picture;
import com.yqwl.pojo.PlotBuild;
import com.yqwl.pojo.PlotDoor;
import com.yqwl.service.HousesNewService;

/**
 * @ClassName: HousesNewServiceImpl
 * @description 用一句话描述这个类的作用
 * @author 姓名全拼
 * @createDate 2019年4月9日
 */
@Service("housesNewService")
@Transactional(rollbackFor = { Exception.class })
public class HousesNewServiceImpl implements HousesNewService {

	@Resource
	private HousesNewMapper housesNewMapper;
	@Resource
	private BuildingMapper buildingMapper;
	@Autowired
	private PictureMapper pictureMapper;
	@Autowired
	private PlotBuildMapper plotBuildMapper;
	@Autowired
	private PlotDoorMapper plotDoorMapper;
	@Autowired
	private BrokerMapper brokerMapper;
	@Autowired
	private EntrustseeMapper entrustseeMapper;
	@Autowired
	private ShopMapper shopMapper;
	@Autowired
	private HomePageRecommendedMapper homePageRecommendedMapper;
	@Autowired
	private AttentionMapper attentionMapper;
	@Override
	public HousesNewVo selectByFindID(long id) throws Exception {
		/*
		 * HousesNewVo result = new HousesNewVo(); HousesNew housesNew =
		 * housesNewMapper.selectByPrimaryKey(id); Building building =
		 * buildingMapper.selectByPrimaryKey(housesNew.getBuilding_id());
		 * BeanUtils.copyProperties(result, housesNew);
		 * result.setBuilding(building);
		 */
		return housesNewMapper.selectByFindID(id);
	}

	/**
	 * 列表查询房源
	 */
	@Override
	public PageInfo<HousesNew> listHousesNewByCondition(Pager pager) throws Exception {
		System.out.println("2.所有房源实现类："+pager.getFilter());
		
		// 获取参数
		Map<String, Object> conditions = MapUtil.formSerializeToMap(pager.getFilter());
		Integer cityId = NumberUtil.dealInteger(StringUtils.getFirstString(conditions.get("cityId")));
		Integer regionId = NumberUtil.dealInteger(StringUtils.getFirstString(conditions.get("regionId")));
		Integer startSpace = NumberUtil.dealInteger(StringUtils.getFirstString(conditions.get("startSpace")));
		Integer endSpace = NumberUtil.dealInteger(StringUtils.getFirstString(conditions.get("endSpace")));
		Double startMoney1 = NumberUtil.dealDouble(StringUtils.getFirstString(conditions.get("startMoney")));
		Double endMoney1 = NumberUtil.dealDouble(StringUtils.getFirstString(conditions.get("endMoney")));
		BigDecimal startMoney = null;
		BigDecimal endMoney = null;
		if (startMoney1 != null && endMoney1 != null) {
			startMoney = BigDecimal.valueOf(startMoney1);
			endMoney = BigDecimal.valueOf(endMoney1);
		}
		Integer fitment = NumberUtil.dealInteger(StringUtils.getFirstString(conditions.get("fitment")));
		// 经纪人id
		Integer brokerId = NumberUtil.dealInteger(StringUtils.getFirstString(conditions.get("brokerId")));
		// 业主电话
		String phone = StringUtils.getFirstString(conditions.get("phone"));
		String ownerName = StringUtils.getFirstString(conditions.get("ownerName"));
		Integer buildingId = NumberUtil.dealInteger(StringUtils.getFirstString(conditions.get("buildingId")));
		System.out.println(cityId+","+regionId+","+startSpace+","+endSpace+","+startMoney+","+endMoney+","+fitment+","+brokerId+","+phone+","+buildingId);
		
		// 分页
		PageHelper.startPage(pager);
		List<HousesNew> list = housesNewMapper.listHousesNewByCondition(cityId, regionId, startSpace, endSpace,
				startMoney, endMoney, fitment, brokerId, phone, ownerName,buildingId);
		System.out.println("3.查询列表"+list);
		return new PageInfo<HousesNew>(list);
	}

	@Override
	public List<HousesNewVo> selectLike(HousesNewVo record) throws Exception {
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
	 * @param @param
	 *            record
	 * @param @param
	 *            brokerId
	 * @param @param
	 *            urls
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
		PlotDoor plotDoor = new PlotDoor();
		plotDoor.setId(record.getDoor_id());
		System.out.println(record.getDoor_id());
		plotDoor.setStatus(1);
		plotDoorMapper.updateByPrimaryKeySelective(plotDoor);
		record.setHoues_number(DateUtil.getCurrentTimestamp().toString());
		record.setTimes(new Date());
		Integer count = housesNewMapper.insertSelective(record);
		/** 判断(房源表)插入成功后向(房源图片储存表)插入图片 */
		if (count != 0&&urls != null&&urls.length>0) {
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
	 * @param @param
	 *            record
	 * @param @param
	 *            brokerId
	 * @param @param
	 *            urls
	 * @param @return
	 * @param @throws
	 *            Exception
	 * 
	 * @return int
	 *
	 * @author yaozijun
	 *
	 * @createDate 2019年4月23日
	 */
	@Override
	public int updateByPrimaryKeySelective(HousesNew record, Long brokerId, String... urls) throws Exception {
		HousesNew housesNew = housesNewMapper.selectByPrimaryKey(record.getId());
		//判断图片地址是否有修改
		if (!housesNew.getHouse_picture().equals(record.getHouse_picture())) {
			//删除原来图片
			UpdateFile.deleatFile(housesNew.getHouse_picture());
		}
		//修改房源字典表状态
		PlotDoor plotDoor = new PlotDoor();
		plotDoor.setId(housesNew.getDoor_id());
		plotDoor.setStatus(0);
		int i = plotDoorMapper.updateByPrimaryKeySelective(plotDoor);
		if (i == 0) {
			throw new BizException(FastJsonUtil.getResponseJson("2000", "修改房源字典失败"));
		}
		plotDoor.setId(record.getDoor_id());
		plotDoor.setStatus(1);
		plotDoorMapper.updateByPrimaryKeySelective(plotDoor);
		Integer count = housesNewMapper.updateByPrimaryKey(record);
		/** 判断(房源表)插入成功后向(房源图片储存表)插入图片 */
		if (count != 0&&urls != null&&urls.length>0) {
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

	@Override
	public List<PlotBuild> getPlotBuildByConditions(Long buildingId) throws Exception {
		return plotBuildMapper.getPlotBuildByConditions(buildingId);
	}

	@Override
	public List<PlotDoor> getPlotDoorByConditions(Long buildId) throws Exception {
		return plotDoorMapper.getPlotDoorByConditions(buildId);
	}

	@Override
	public int insertPlotDoor(PlotDoor plotDoor) throws Exception {
		return plotDoorMapper.insertSelective(plotDoor);
	}

	@Override
	public int insertPlotBuild(PlotBuild plotBuild) throws Exception {
		return plotBuildMapper.insertSelective(plotBuild);
	}

	@Override
	public int updatePlotBuild(PlotBuild plotBuild) throws Exception {
		return plotBuildMapper.updateByPrimaryKeySelective(plotBuild);
	}

	@Override
	public int updatePlotDoor(PlotDoor plotDoor) throws Exception {
		return plotDoorMapper.updateByPrimaryKeySelective(plotDoor);
	}

	@Override
	public int deletePlotDoor(Long id) throws Exception {
		System.out.println(id);
		PlotDoor plotDoor = plotDoorMapper.selectByPrimaryKey(id);
		if (plotDoor.getStatus() != 0) throw new BizException(FastJsonUtil.getResponseJson(2000, "待租或已组房源不能删除", null));
		return plotDoorMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int deletePlotBuild(Long id) throws Exception {
		List<PlotDoor> list = plotDoorMapper.getPlotDoorByConditions(id);
		for (PlotDoor plotDoor : list) {
			if (plotDoor.getStatus() != 0) throw new BizException(FastJsonUtil.getResponseJson(2000, "待租或已组房源不能删除", null));
		}
		plotDoorMapper.deleteByBuildId(id);
		return plotBuildMapper.deleteByPrimaryKey(id);
	}

	@Override
	public PageInfo<HousesNew> ListBackHousesNew(Pager pager,Long id) throws Exception {
		// 获取参数
		Map<String, Object> conditions = MapUtil.formSerializeToMap(pager.getFilter());
		Integer cityId = NumberUtil.dealInteger(StringUtils.getFirstString(conditions.get("cityId")));
		Integer regionId = NumberUtil.dealInteger(StringUtils.getFirstString(conditions.get("regionId")));
		Integer startSpace = NumberUtil.dealInteger(StringUtils.getFirstString(conditions.get("startSpace")));
		Integer endSpace = NumberUtil.dealInteger(StringUtils.getFirstString(conditions.get("endSpace")));
		Double startMoney1 = NumberUtil.dealDouble(StringUtils.getFirstString(conditions.get("startMoney")));
		Double endMoney1 = NumberUtil.dealDouble(StringUtils.getFirstString(conditions.get("endMoney")));
		BigDecimal startMoney = null;
		BigDecimal endMoney = null;
		if (startMoney1 != null && endMoney1 != null) {
			startMoney = BigDecimal.valueOf(startMoney1);
			endMoney = BigDecimal.valueOf(endMoney1);
		}
		Integer fitment = NumberUtil.dealInteger(StringUtils.getFirstString(conditions.get("fitment")));
		Long shopId = brokerMapper.getBrokerByShopId(id);
		
		// 经纪人id
		Integer brokerId = NumberUtil.dealInteger(StringUtils.getFirstString(conditions.get("brokerId")));
		// 业主电话
		String phone = StringUtils.getFirstString(conditions.get("phone"));
		// 业主姓名
		String ownerName = StringUtils.getFirstString(conditions.get("ownerName"));
		Integer buildingId = NumberUtil.dealInteger(StringUtils.getFirstString(conditions.get("buildingId")));
		// 分页
		PageHelper.startPage(pager);
		List<HousesNew> list = housesNewMapper.ListBackHousesNew(cityId, regionId, startSpace, endSpace,
				startMoney, endMoney, fitment, shopId, brokerId, phone, ownerName,buildingId);
		return new PageInfo<HousesNew>(list);
	}

	@Override
	public int delHome(Long homeId) throws Exception {
		HousesNew housesNew = housesNewMapper.selectByPrimaryKey(homeId);
		List<HomePageRecommended> homePageRecommendeds = homePageRecommendedMapper.listByType(3);
		for (HomePageRecommended homePageRecommended : homePageRecommendeds) {
			if (homePageRecommended.getBuilding_id() == homeId) throw new BizException(FastJsonUtil.getResponseJson(2000, "该房源已被推荐到首页不能删除", null));
		}
		attentionMapper.delByHousesId(homeId);
		entrustseeMapper.delByHousesId(homeId);
		pictureMapper.delByHousesId(homeId);
		PlotDoor plotDoor = new PlotDoor();
		plotDoor.setId(housesNew.getDoor_id());
		plotDoor.setStatus(1);
		plotDoorMapper.updateByPrimaryKeySelective(plotDoor);
		return housesNewMapper.deleteByPrimaryKey(homeId);
	}

	@Override
	public BackHousesVo getById(Long id) throws Exception {
		BackHousesVo backHousesVo = new BackHousesVo();
		HousesNew housesNew = housesNewMapper.selectByPrimaryKey(id);
		PlotDoor plotDoor = plotDoorMapper.selectByPrimaryKey(housesNew.getDoor_id());
		PlotBuild plotBuild = plotBuildMapper.selectByPrimaryKey(plotDoor.getBuild_id());
		BeanUtil.copyProperties(backHousesVo,housesNew);
		System.out.println(housesNew);
		backHousesVo.setBroker(brokerMapper.selectByPrimaryKey((long)housesNew.getEntering_broker_id()));
		backHousesVo.setBuilding(buildingMapper.selectByPrimaryKey(housesNew.getBuilding_id()));
		backHousesVo.setShop(shopMapper.selectByPrimaryKey(housesNew.getShop_id()));
		backHousesVo.setPictures(pictureMapper.selectPic(id));
		backHousesVo.setPlotDoor(plotDoor);
		backHousesVo.setPlotBuild(plotBuild);
		return backHousesVo;
	}

	@Override
	public int deleteFile(Long id) throws Exception {
		Picture picture = pictureMapper.selectByPrimaryKey(id);
		if (UpdateFile.deleatFile(picture.getPicture())) {
			return pictureMapper.deleteByPrimaryKey(id);
		}
		return 0;
	}

	@Override
	public PlotDoor getPlotDoorById(Long id) throws Exception {
		return plotDoorMapper.selectByPrimaryKey(id);
	}

	@Override
	public PlotBuild getPlotBuildById(Long id) throws Exception {
		return plotBuildMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insertDoor(Long build_id, Integer flooors, Integer startDoor, Integer endDoor,List<Integer> span) throws Exception {
		int flag = startDoor;
		int count = 0;
		for (int i = 1; i <= flooors; i++) {
			if (span.contains(i)) {
				continue;
			}
			for (; startDoor <= endDoor; startDoor++) {
				PlotDoor plotDoor = new PlotDoor();
				plotDoor.setBuild_id(build_id);
				plotDoor.setFloor(i);
				plotDoor.setStatus(0);
				if (startDoor<10) {
					plotDoor.setDoor_num(i+"0"+startDoor);
				}else {
					plotDoor.setDoor_num(i+""+startDoor);
				}
				count += plotDoorMapper.insertSelective(plotDoor);
			}
			startDoor = flag;
		}
		return count;
	}

	@Override
	public int deletePlotDoorByFloor(Long buildId,Integer floor) throws Exception {
		List<PlotDoor> list = plotDoorMapper.getPlotDoorByFloor(buildId,floor);
		for (PlotDoor plotDoor : list) {
			if (plotDoor.getStatus() != 0) throw new BizException(FastJsonUtil.getResponseJson(2000, "待租或已组房源不能删除", null));
		}
		return plotDoorMapper.deletePlotDoorByFloor(buildId,floor);
	}

	/**
	 * @Title: updateSelective
	 * @description 修改房源状态活开盘修改
	 * @param @param record
	 * @param @return    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年6月12日
	 */
	@Override
	public int updateSelective(HousesNew record) {
		return housesNewMapper.updateSelective(record);
	}

}
