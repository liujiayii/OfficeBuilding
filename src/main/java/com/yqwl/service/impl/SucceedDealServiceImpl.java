package com.yqwl.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yqwl.common.utils.DateUtil;
import com.yqwl.common.utils.MapUtil;
import com.yqwl.common.utils.NumberUtil;
import com.yqwl.common.utils.Pager;
import com.yqwl.common.utils.StringUtils;
import com.yqwl.dao.SuccedDealCostMapper;
import com.yqwl.dao.SucceedDealMapper;
import com.yqwl.pojo.SuccedDealCost;
import com.yqwl.pojo.SucceedDeal;
import com.yqwl.service.SucceedDealService;
@Service("succedDealService")
@Transactional(rollbackFor = { Exception.class })
public class SucceedDealServiceImpl implements SucceedDealService {
	@Autowired
	private SucceedDealMapper succeedDealMapper;
	@Autowired
	private SuccedDealCostMapper succedDealCostMapper;
	
	@Override
	public Integer insert(SucceedDeal succeedDeal, List<SuccedDealCost> succedDealCosts) throws Exception {
		int i = succeedDealMapper.insertSelective(succeedDeal);
		for (SuccedDealCost succedDealCost : succedDealCosts) {
			succedDealCost.setSucced_id(succeedDeal.getId());
			succedDealCostMapper.insertSelective(succedDealCost);
		}
		return i;
	}

	@Override
	public Integer update(SucceedDeal succeedDeal, List<SuccedDealCost> succedDealCosts) throws Exception {
		int i = succeedDealMapper.updateByPrimaryKeySelective(succeedDeal);
		for (SuccedDealCost succedDealCost : succedDealCosts) {
			succedDealCostMapper.updateByPrimaryKeySelective(succedDealCost);
		}
		return i;
	}

	@Override
	public PageInfo<SucceedDeal> listAll(Pager pager) throws Exception {
		//TODO
		Map<String, Object> conditions = MapUtil.formSerializeToMap(pager.getFilter());
		Long shopId = NumberUtil.dealLong(StringUtils.getFirstString(conditions.get("shopId")));
		Long groupId = NumberUtil.dealLong(StringUtils.getFirstString(conditions.get("groupId")));
		Long brokerId = NumberUtil.dealLong(StringUtils.getFirstString(conditions.get("brokerId")));
		Date startTime = DateUtil.stringToDate(StringUtils.getFirstString(conditions.get("startTime")));
		Date endTime = DateUtil.stringToDate(StringUtils.getFirstString(conditions.get("endTime")));
		String pack = StringUtils.getFirstString(conditions.get("pack"));
		PageHelper.startPage(pager);
		//List<E>
		return null;
	}
	
	
}
