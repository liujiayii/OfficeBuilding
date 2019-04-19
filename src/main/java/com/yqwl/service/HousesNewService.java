package com.yqwl.service;


import java.util.List;

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
}
