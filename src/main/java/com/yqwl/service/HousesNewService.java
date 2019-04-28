package com.yqwl.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.github.pagehelper.PageInfo;
import com.yqwl.Vo.HousesNewVo;
import com.yqwl.common.utils.Pager;
import com.yqwl.pojo.HousesNew;

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
	
	/*查询可能喜欢的房源信息**/
	List<HousesNewVo> selectLike(HousesNewVo record);

	public List<HousesNew> getMapById(Long buildingId) throws Exception;
	
	/** 后台新增房源信息及图片信息 */
	public int insertSelective(HousesNew record,Long brokerId,String... urls) throws Exception;
	
	/** 后台修改房源信息及图片信息*/
	public int updateByPrimaryKeySelective(HousesNew record,Long brokerId,String... urls) throws Exception;

}
