package com.yqwl.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.yqwl.Vo.SucceedDealVo;
import com.yqwl.Vo.SucceedDealVo1;
import com.yqwl.common.utils.Pager;
import com.yqwl.pojo.SuccedDealCost;
import com.yqwl.pojo.SucceedDeal;

public interface SucceedDealService {

	Integer insert(SucceedDeal succeedDeal, String succedDealCosts) throws Exception;

	Integer update(SucceedDeal succeedDeal, String succedDealCosts) throws Exception;

	PageInfo<SucceedDealVo> listAll(Pager pager) throws Exception;
	/**
	 * @Title: selectByPrimaryCount
	 * @description 查询成交
	 * @param @param shopId
	 * @param @param startTime
	 * @param @param endTime
	 * @param @return    
	 * @return List<Map<String,Object>>    
	 * @author linhongyu
	 * @createDate 2019年6月17日
	 */
	public List<Map<String, Object>> selectByPrimaryCount(Long shopId,Date startTime,Date endTime);

	SucceedDealVo1 getById(Long id) throws Exception;
}
