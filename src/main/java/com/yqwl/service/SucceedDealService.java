package com.yqwl.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yqwl.common.utils.Pager;
import com.yqwl.pojo.SuccedDealCost;
import com.yqwl.pojo.SucceedDeal;

public interface SucceedDealService {

	Integer insert(SucceedDeal succeedDeal, List<SuccedDealCost> succedDealCosts) throws Exception;

	Integer update(SucceedDeal succeedDeal, List<SuccedDealCost> succedDealCosts) throws Exception;

	PageInfo<SucceedDeal> listAll(Pager pager) throws Exception;

}
