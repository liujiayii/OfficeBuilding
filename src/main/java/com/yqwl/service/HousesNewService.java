package com.yqwl.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yqwl.Vo.BackHousesVo;
import com.yqwl.Vo.HousesNewVo;
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

	public HousesNewVo selectByFindID(long id) throws Exception;

	public PageInfo<HousesNew> listHousesNewByCondition(Pager pager) throws Exception;

	/* 查询可能喜欢的房源信息 **/
	List<HousesNewVo> selectLike(HousesNewVo record) throws Exception;

	public List<HousesNew> getMapById(Long buildingId) throws Exception;

	/** 后台新增房源信息及图片信息 */
	public int insertSelective(HousesNew record, Long brokerId, String... urls) throws Exception;

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

	public PageInfo<HousesNew> ListBackHousesNew(Pager pager, Long id) throws Exception;

	public int delHome(Long homeId) throws Exception;

	public BackHousesVo getById(Long id) throws Exception;

	public int deleteFile(Long id) throws Exception;

	public PlotDoor getPlotDoorById(Long id) throws Exception;

	public PlotBuild getPlotBuildById(Long id) throws Exception;

}
