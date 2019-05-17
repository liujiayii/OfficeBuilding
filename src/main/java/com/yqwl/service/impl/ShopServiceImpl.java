package com.yqwl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yqwl.Vo.ShopVo;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.common.utils.Pager;
import com.yqwl.common.web.BizException;
import com.yqwl.dao.BrokerMapper;
import com.yqwl.dao.GroupMapper;
import com.yqwl.dao.HousesNewMapper;
import com.yqwl.dao.RegionMapper;
import com.yqwl.dao.ShopMapper;
import com.yqwl.pojo.Broker;
import com.yqwl.pojo.Group;
import com.yqwl.pojo.HousesNew;
import com.yqwl.pojo.Region;
import com.yqwl.pojo.Shop;
import com.yqwl.service.ShopService;
@Service("shopService")
@Transactional(rollbackFor = { Exception.class })
public class ShopServiceImpl implements ShopService {
	@Autowired
	private ShopMapper shopMapper;
	@Autowired
	private GroupMapper groupMapper;
	@Autowired
	private BrokerMapper brokerMapper;
	@Autowired
	private HousesNewMapper housesNewMapper;
	@Autowired
	private RegionMapper regionMapper;
	
	@Override
	public PageInfo<ShopVo> seleceShopList(Pager pager) throws Exception {
		PageHelper.startPage(pager);
		List<ShopVo> list = shopMapper.listAllPage();
		for (ShopVo shopVo : list) {
			StringBuffer name = new StringBuffer();
			Region region = regionMapper.selectByPrimaryKey(Integer.valueOf(shopVo.getRegion_id().toString()));
			name.append(region.getTitle());
			region = regionMapper.selectByPrimaryKey(region.getPid());
			name.insert(0, region.getTitle());
			region = regionMapper.selectByPrimaryKey(region.getPid());
			name.insert(0, region.getTitle());
			shopVo.setRegion(name.toString());
		}
		return new PageInfo<ShopVo>(list);
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

	@Override
	public Integer delete(Long id) throws Exception {
		List<Group> groups = groupMapper.getByShopId(id);
		for (Group group : groups) {
			List<Broker> list = brokerMapper.getBrokerByGroupId(group.getId());
			if (list.size()>0) throw new BizException(FastJsonUtil.getResponseJson("2000", "小组成员未清空")); 
			groupMapper.deleteByPrimaryKey(group.getId());
		}
		List<HousesNew> housesNews = housesNewMapper.listByShopId(id);
		if (housesNews.size()>0) throw new BizException(FastJsonUtil.getResponseJson("2000", "店铺下还有房源")); 
		return shopMapper.deleteByPrimaryKey(id);
	}

}
