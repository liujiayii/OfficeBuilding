package com.yqwl.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yqwl.common.utils.Pager;
import com.yqwl.pojo.Shop;

public interface ShopService {
	/** 后台列表显示门店 */
	public PageInfo<Shop> seleceShopList(Pager pager) throws Exception;
	
	/** 根据ID查询门店 */
	public Shop selectByPrimaryKey(Long id) throws Exception;
	
	/** 新增门店信息 */
	public int insertSelective(Shop record) throws Exception;
	
	/** 修改门店信息 */
	public int updateByPrimaryKeySelective(Shop record) throws Exception;

	public List<Shop> listAll() throws Exception;
}
