package com.yqwl.service.impl;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yqwl.Vo.BackHousesVo;
import com.yqwl.Vo.HousesNewAnalysisVo;
import com.yqwl.Vo.HousesNewVo;
import com.yqwl.Vo.HousesVo;
import com.yqwl.common.utils.BeanUtil;
import com.yqwl.common.utils.Constants;
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
import com.yqwl.dao.DivideIntoMapper;
import com.yqwl.dao.EntrustseeMapper;
import com.yqwl.dao.GroupMapper;
import com.yqwl.dao.HomePageRecommendedMapper;
import com.yqwl.dao.HousesNewMapper;
import com.yqwl.dao.PictureMapper;
import com.yqwl.dao.PlotBuildMapper;
import com.yqwl.dao.PlotDoorMapper;
import com.yqwl.dao.ShopMapper;
import com.yqwl.dao.UserMapper;
import com.yqwl.pojo.Broker;
import com.yqwl.pojo.Delegation;
import com.yqwl.pojo.DivideInto;
import com.yqwl.pojo.Entrustsee;
import com.yqwl.pojo.Group;
import com.yqwl.pojo.HomePageRecommended;
import com.yqwl.pojo.HousesNew;
import com.yqwl.pojo.Picture;
import com.yqwl.pojo.PlotBuild;
import com.yqwl.pojo.PlotDoor;
import com.yqwl.pojo.User;
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
	@Autowired
	private GroupMapper groupMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private DivideIntoMapper divideIntoMapper;
	
	
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
		Long brokerId = NumberUtil.dealLong(StringUtils.getFirstString(conditions.get("brokerId")));
		Long broker_id = NumberUtil.dealLong(StringUtils.getFirstString(conditions.get("broker_id")));
		System.out.println(brokerId);
		// 业主电话
		String homes_number = StringUtils.getFirstString(conditions.get("home_number"));
		String home_number=null;
		if(!(homes_number.equals("null") || homes_number.equals("")) ){
			home_number = homes_number;
		}
		String homes_name = new String(StringUtils.getFirstString(conditions.get("home_name")).trim().getBytes("ISO-8859-1"), "UTF-8");
		String home_name=null;
		if(!(homes_name.equals("null") || homes_name.equals(""))){
			home_name = homes_name;
		}
		Long buildingId = NumberUtil.dealLong(StringUtils.getFirstString(conditions.get("buildingId")));
		
		Integer  whether = NumberUtil.dealInteger(StringUtils.getFirstString(conditions.get("whether")));

		// 分页
		PageHelper.startPage(pager);
		List<HousesNew> list = housesNewMapper.listHousesNewByCondition(cityId, regionId, startSpace, endSpace,
				startMoney, endMoney, fitment, brokerId,buildingId,home_number,home_name, whether,broker_id);
		
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
		record.setBegin_time(new Date());
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
	public PageInfo<HousesVo> ListBackHousesNew(Pager pager,Long id) throws Exception {
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
		Long broker_id = NumberUtil.dealLong(StringUtils.getFirstString(conditions.get("broker_id")));
		Long brokerId = NumberUtil.dealLong(StringUtils.getFirstString(conditions.get("brokerId")));
		// 业主电话
		String homes_number = StringUtils.getFirstString(conditions.get("home_number"));
		String home_number=null;
		if(!(homes_number.equals("null") || homes_number.equals("")) ){
			home_number = homes_number;
		}
		String homes_name = new String(StringUtils.getFirstString(conditions.get("home_name")).trim().getBytes("ISO-8859-1"), "UTF-8");
		String home_name=null;
		if(!(homes_name.equals("null") || homes_name.equals(""))){
			home_name = homes_name;
		}
		Long buildingId = NumberUtil.dealLong(StringUtils.getFirstString(conditions.get("buildingId")));
		
		Integer whether = NumberUtil.dealInteger(StringUtils.getFirstString(conditions.get("whether")));
		System.out.println(whether);
		// 分页
		PageHelper.startPage(pager);
		List<HousesVo> list = housesNewMapper.ListBackHousesNew(cityId, regionId, startSpace, endSpace,
				startMoney, endMoney, fitment, shopId, brokerId, home_number, home_name, buildingId,whether,broker_id);
		return new PageInfo<HousesVo>(list);
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
		System.out.println("plotDoor"+plotDoor);
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

	/** 添加决策分析(根据条件查询相关经纪人房源状况) */
	@Override
	public List<Map<String, Object>> getDecisionAnalysis(Long shopId,Date startTime,Date endTime) {
		List<Map<String, Object>>list = new ArrayList<Map<String,Object>>();
		/** 查询该店铺下所有小组 */
		List<Group> groupList = groupMapper.getByShopId(shopId);
		/** 循环遍历每个小组下的经纪人 */
		for (Group group : groupList) {
			Map<String, Object> map1 = new HashMap<>();
			List<Map<String, Object>> list2 = new ArrayList<Map<String,Object>>();
			List<Broker> brokerList = brokerMapper.getBrokerByGroupId(group.getId());
			/** 计算每个小组下的成员对应不同房源状态的数量 */
			for (Broker broker : brokerList) {
				Map<String, Object> map2 = new HashMap<>();
				HousesNewAnalysisVo  housesNewAnalysisVo = new HousesNewAnalysisVo();
				housesNewAnalysisVo.setNormal(housesNewMapper.getCountByWhether(broker.getId(),1,startTime,endTime));
				housesNewAnalysisVo.setPostpone(housesNewMapper.getCountByWhether(broker.getId(),2,startTime,endTime));
				housesNewAnalysisVo.setElse_sell(housesNewMapper.getCountByWhether(broker.getId(),3,startTime,endTime));
				housesNewAnalysisVo.setElse_rent(housesNewMapper.getCountByWhether(broker.getId(),4,startTime,endTime));
				housesNewAnalysisVo.setUnknown(housesNewMapper.getCountByWhether(broker.getId(),5,startTime,endTime));
				housesNewAnalysisVo.setRevoke(housesNewMapper.getCountByWhether(broker.getId(),6,startTime,endTime));
				housesNewAnalysisVo.setOneself_rent(housesNewMapper.getCountByWhether(broker.getId(),7,startTime,endTime));
				housesNewAnalysisVo.setOneself_sell(housesNewMapper.getCountByWhether(broker.getId(),8,startTime,endTime));
				housesNewAnalysisVo.setBe_confirmed(housesNewMapper.getCountByWhether(broker.getId(),9,startTime,endTime));
				housesNewAnalysisVo.setRecall(housesNewMapper.getCountByWhether(broker.getId(),10,startTime,endTime));
				
				map2.put("name", broker.getReal_name());
				map2.put("housesNewAnalysisVo", housesNewAnalysisVo);
				
				list2.add(map2);
			}
			map1.put("groupName", group.getName());
			map1.put("list", list2);
			list.add(map1);
		}
		
		return list;
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
	public int updateSelective(HousesNew record) throws Exception{
		return housesNewMapper.updateSelective(record);
	}
	/**
	 * @Title: selectPaireds
	 * @description 查询用户需求和房源匹配
	 * @param @param demand_acreage
	 * @param @param demand_money
	 * @param @return    
	 * @return List<HousesNewVo>    
	 * @author linhongyu
	 * @createDate 2019年6月18日
	 */
	@Override
	public List<HousesNewVo> selectPaireds(int demand_acreage,int demand_money,int region_id,Long building_id,Integer page,Integer limit) throws Exception{
		List<HousesNewVo> list= housesNewMapper.selectPaired(demand_acreage*0.8, 1.2*demand_acreage,demand_money*0.8, demand_money*1.2, region_id, building_id,page,limit);
		return list;
	}
	/**
	 *
	 * @Title: selectGoufing
	 * @description 查询该房源所有经纪人信息
	 * @param @return
	 * @param @throws Exception    
	 * @return HousesNew    
	 * @author linhongyu
	 * @createDate 2019年6月20日
	 */
	@Override
	public Map<String, Object> selectGoufing(Long id) throws Exception{
		Map<String, Object> map = new HashMap<>();
		HousesNew housesNew=housesNewMapper.selectByPrimaryKey(id);
		Integer wher=housesNew.getWhether();
		if(housesNew.getEntering_broker_id()!=null){
			Broker broker=brokerMapper.selectByPrimaryKey(housesNew.getEntering_broker_id());
			if(broker!=null){
				String Lname=broker.getReal_name();
				map.put("Lname", Lname);//录入经纪人姓名
			}else {
				map.put("Lname", null);
			}
		}
		if(housesNew.getMaintain_broker_id()!=null){
			Broker brokers=brokerMapper.selectByPrimaryKey(housesNew.getMaintain_broker_id());
			if (brokers!=null) {
				String Wname=brokers.getReal_name();
				map.put("Wname", Wname);//维护经纪人姓名
			} else {
				map.put("Wname", null);
			}
		}
		if(housesNew.getOpen_broker_id()!=null){
			Broker brokert=brokerMapper.selectByPrimaryKey(housesNew.getOpen_broker_id());
			if (brokert!=null) {
				String Kname=brokert.getReal_name();
				map.put("Kname", Kname);//开盘经纪人姓名
			} else {
				map.put("Kname", null);
			}
		}
		if(housesNew.getKey_broker_id()!=null){
			Broker brokerk=brokerMapper.selectByPrimaryKey(housesNew.getKey_broker_id());
			if (brokerk!=null) {
				String Nname=brokerk.getReal_name();
				map.put("Nname", Nname);//拿钥匙经纪人姓名
			} else {
				map.put("Nname", null);
			}
			
		}
		if(housesNew.getSolid_broker_id()!=null){
			Broker brokerT=brokerMapper.selectByPrimaryKey(housesNew.getSolid_broker_id());
			if (brokerT!=null) {
				String Tname=brokerT.getReal_name();
				map.put("Tname", Tname);//实勘图片经纪人姓名
			} else {
				map.put("Tname", null);
			}
		}
		BigDecimal mon=housesNew.getMoney();
		Integer unit=housesNew.getMoney_unit();
		DivideInto divideInto=divideIntoMapper.selectStatus();
		System.out.println(divideInto+"divideInto");
		BigDecimal money = null;
		if(unit==1){
			money=mon;
		}else if (unit==2) {
			money=mon.multiply(new BigDecimal(housesNew.getOffice_space())).multiply(new BigDecimal(30));
		}else if (unit==3) {
			money=mon.divide(new BigDecimal(6));
		}else if (unit==4) {
			money=mon.multiply(new BigDecimal(housesNew.getOffice_space()));
		}else if (unit==5) {
			money=mon.multiply(new BigDecimal(housesNew.getOffice_space())).multiply(new BigDecimal(30));
		}else if (unit==6) {
			money=mon.multiply(new BigDecimal(10000));
		}
		BigDecimal Lone=money.multiply(new BigDecimal(divideInto.getEnter_per())).divide(new BigDecimal(100));//录入经纪人分红
		BigDecimal Ktwo=money.multiply(new BigDecimal(divideInto.getOpen_quot_per())).divide(new BigDecimal(100));//开盘经纪人分红
		BigDecimal Wthere=money.multiply(new BigDecimal(divideInto.getVindicate_per())).divide(new BigDecimal(100));//维护经纪人分红
		BigDecimal Tfist=money.multiply(new BigDecimal(divideInto.getSend_photo_per())).divide(new BigDecimal(100));//实勘图片经纪人分红
		BigDecimal Yfrive=money.multiply(new BigDecimal(divideInto.getTake_key_per())).divide(new BigDecimal(100));//拿钥匙经纪人分红
		if(wher==1){
			map.put("wher", "正常");
		}else if (wher==3) {
			map.put("wher", "成交");
		}else if (wher==6) {
			map.put("wher", " 撤单");
		}
		map.put("wher", "失效");
		map.put("Lone", Lone);
		map.put("Ktwo", Ktwo);
		map.put("Wthere", Wthere);
		map.put("Tfist", Tfist);
		map.put("Nfrive", Yfrive);
		return map;
	}

	/**
	 *
	 * @Title: updateByPrimaryKey
	 * @description 修改房源各个经纪人
	 * @param @param record
	 * @param @return    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年6月20日
	 */
	@Override
	public int updateByPrimaryKey(HousesNew record) {
		return housesNewMapper.updateByPrimaryKey(record);
	}
	
}
