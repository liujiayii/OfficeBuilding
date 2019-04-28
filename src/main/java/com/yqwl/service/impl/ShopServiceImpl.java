package com.yqwl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yqwl.common.utils.Pager;
import com.yqwl.dao.ShopMapper;
import com.yqwl.pojo.Shop;
import com.yqwl.service.ShopService;

public class ShopServiceImpl implements ShopService {
	@Autowired
	private ShopMapper shopMapper;

	@Override
	public PageInfo<Shop> seleceShopList(Pager pager) throws Exception {
		PageHelper.startPage(pager);
		List<Shop> list = shopMapper.listAll();
		return new PageInfo<Shop>(list);
	}

	/** 根据ID查询门店 */
	@Override
	public Shop selectByPrimaryKey(Long id) throws Exception {

		return shopMapper.selectByPrimaryKey(id);
	}

	/** 新增门店信息 */
	@Override
	public int insertSelective(Shop record) throws Exception {
		return shopMapper.insertSelective(record);
	}

	/** 修改门店信息 */
	@Override
	public int updateByPrimaryKeySelective(Shop record) throws Exception {
		return shopMapper.updateByPrimaryKeySelective(record);
	}
	/**
	 * 查询所有店铺
	 */
	@Override
	public List<Shop> listAll() throws Exception {
		return shopMapper.listAll();
	}

}
