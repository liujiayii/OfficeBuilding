package com.yqwl.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.yqwl.Vo.BackHousesVo;
import com.yqwl.Vo.HousesNewVo;
import com.yqwl.Vo.HousesVo;
import com.yqwl.common.utils.Pager;
import com.yqwl.pojo.HousesNew;
import com.yqwl.pojo.PlotBuild;
import com.yqwl.pojo.PlotDoor;

/**
 *
 * @ClassName: HousesNew
 * @description 用一句话描述这个类的作用
 *
 * @author 姓名全拼
 * @createDate 2019年4月9日
 */
public interface HousesNewService {
	/* 通过id查询房源详细数据 **/
	public HousesNewVo selectByFindID(long id) throws Exception;

	public PageInfo<HousesNew> listHousesNewByCondition(Pager pager) throws Exception;

	/* 查询可能喜欢的房源信息 **/
	List<HousesNewVo> selectLike(HousesNewVo record) throws Exception;

	public List<HousesNew> getMapById(Long buildingId) throws Exception;

	/** 后台新增房源信息及图片信息 
	 * @param number */
	public int insertSelective(HousesNew record, Long brokerId, String number, String... urls) throws Exception;

	/** 后台修改房源信息及图片信息 */
	public int updateByPrimaryKeySelective(HousesNew record, Long brokerId, String... urls) throws Exception;

	public List<PlotBuild> getPlotBuildByConditions(Long buildingId) throws Exception;

	public List<PlotDoor> getPlotDoorByConditions(Long buildId) throws Exception;

	public int insertPlotDoor(PlotDoor plotDoor) throws Exception;

	public int insertPlotBuild(PlotBuild plotBuild) throws Exception;

	public int updatePlotBuild(PlotBuild plotBuild) throws Exception;

	public int updatePlotDoor(PlotDoor plotDoor) throws Exception;

	public int deletePlotDoor(Long id) throws Exception;

	public int deletePlotBuild(Long id) throws Exception;

	public PageInfo<HousesVo> ListBackHousesNew(Pager pager, Long id) throws Exception;

	public int delHome(Long homeId) throws Exception;

	public BackHousesVo getById(Long id) throws Exception;

	public int deleteFile(Long id) throws Exception;

	public PlotDoor getPlotDoorById(Long id) throws Exception;

	public PlotBuild getPlotBuildById(Long id) throws Exception;

	public int insertDoor(Long build_id, Integer flooors, Integer startDoor, Integer endDoor, List<Integer> span) throws Exception;

	public int deletePlotDoorByFloor(Long id,Integer floor) throws Exception;
	/**
	 * @Title: updateSelective
	 * @description 修改房源状态活开盘修改
	 * @param @param record
	 * @param @return    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年6月12日
	 */
	int updateSelective(HousesNew record) throws Exception;

	/**
	 * 
	 * @Title: getDecisionAnalysis
	 *
	 * @description 添加决策分析(根据条件查询相关经纪人房源状况)
	 *
	 * @param @param shopId
	 * @param @param startTime
	 * @param @param endTime
	 * @param @return 
	 * 
	 * @return List<Map<String,Object>>    
	 *
	 * @author yaozijun
	 *
	 * @createDate 2019年6月14日
	 */
	public List<Map<String, Object>> getDecisionAnalysis(Long shopId,Date startTime,Date endTime) throws Exception;
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
	List<HousesNewVo> selectPaireds(int demand_acreage,int demand_money,int region_id,Long building_id,Integer page,Integer limit) throws Exception;

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
	Map<String, Object> selectGoufing(Long id) throws Exception;

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
	public int updateByPrimaryKey(HousesNew record);


	public PageInfo<HousesNew> frontListHousesNewByCondition(Pager pager) throws Exception;

	/**
	 *
	 * @Title: updateTypes
	 * @description 修改上下架状态
	 * @param @param record
	 * @param @return    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年7月9日
	 */
	public int updateTypes(HousesNew record) throws Exception;

}
