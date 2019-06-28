package com.yqwl.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yqwl.Vo.PushMoney;
import com.yqwl.Vo.SucceedDealListVo;
import com.yqwl.Vo.SucceedDealVo;
import com.yqwl.Vo.SucceedDealVo1;
import com.yqwl.common.utils.BeanUtil;
import com.yqwl.common.utils.DateUtil;
import com.yqwl.common.utils.MapUtil;
import com.yqwl.common.utils.NumberUtil;
import com.yqwl.common.utils.Pager;
import com.yqwl.common.utils.StringUtils;
import com.yqwl.dao.BrokerMapper;
import com.yqwl.dao.DivideIntoMapper;
import com.yqwl.dao.GroupMapper;
import com.yqwl.dao.HousesNewMapper;
import com.yqwl.dao.SuccedDealCostMapper;
import com.yqwl.dao.SucceedDealMapper;
import com.yqwl.dao.UserFollowUpMapper;
import com.yqwl.dao.UserMapper;
import com.yqwl.dao.UserPhoneMapper;
import com.yqwl.pojo.Broker;
import com.yqwl.pojo.DivideInto;
import com.yqwl.pojo.Group;
import com.yqwl.pojo.HousesNew;
import com.yqwl.pojo.SuccedDealCost;
import com.yqwl.pojo.SucceedDeal;
import com.yqwl.pojo.User;
import com.yqwl.pojo.UserFollowUp;
import com.yqwl.service.SucceedDealService;

@Service("succedDealService")
@Transactional(rollbackFor = { Exception.class })
public class SucceedDealServiceImpl implements SucceedDealService {
	@Autowired
	private SucceedDealMapper succeedDealMapper;
	@Autowired
	private SuccedDealCostMapper succedDealCostMapper;
	@Autowired
	private GroupMapper groupMapper;
	@Autowired
	private BrokerMapper brokerMapper;
	@Autowired
	private DivideIntoMapper DivideIntoMapper;
	@Autowired
	private UserPhoneMapper userPhoneMapper;
	@Autowired
	private HousesNewMapper housesNewMapper;
	@Autowired
	private UserFollowUpMapper userFollowUpMapper;
	@Autowired
	private UserMapper userMapper;

	@Override
	public Integer insert(SucceedDeal succeedDeal, String succedDealCosts) throws Exception {
		int i = succeedDealMapper.insertSelective(succeedDeal);
		List<SuccedDealCost> List = JSONObject.parseArray(succedDealCosts, SuccedDealCost.class);
		for (SuccedDealCost succedDealCost : List) {
			succedDealCost.setSucced_id(succeedDeal.getId());
			succedDealCostMapper.insertSelective(succedDealCost);
		}
		return i;
	}

	@Override
	public Integer update(SucceedDeal succeedDeal, String succedDealCosts) throws Exception {
		int i = succeedDealMapper.updateByPrimaryKeySelective(succeedDeal);
		List<SuccedDealCost> List = JSONObject.parseArray(succedDealCosts, SuccedDealCost.class);
		for (SuccedDealCost succedDealCost : List) {
			succedDealCostMapper.updateByPrimaryKeySelective(succedDealCost);
		}
		return i;
	}

	@Override
	public PageInfo<SucceedDealVo> listAll(Pager pager) throws Exception {
		Map<String, Object> conditions = MapUtil.formSerializeToMap(pager.getFilter());
		Long shopId = NumberUtil.dealLong(StringUtils.getFirstString(conditions.get("shopId")));
		Long groupId = NumberUtil.dealLong(StringUtils.getFirstString(conditions.get("groupId")));
		Long brokerId = NumberUtil.dealLong(StringUtils.getFirstString(conditions.get("brokerId")));
		Date startTime = DateUtil.stringToDate(StringUtils.getFirstString(conditions.get("startTime")));
		Date endTime = DateUtil.stringToDate(StringUtils.getFirstString(conditions.get("endTime")));
		String pack = StringUtils.getFirstString(conditions.get("pack"));
		PageHelper.startPage(pager);
		List<SucceedDealVo> list = succeedDealMapper.listAll(shopId, groupId, brokerId, startTime, endTime, pack);
		return new PageInfo<SucceedDealVo>(list);
	}

	@Override
	public List<Map<String, Object>> selectByPrimaryCount(Long shopId, Date startTime, Date endTime) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		/** 查询该店铺下所有小组 */
		List<Group> groupList = groupMapper.getByShopId(shopId);
		/** 循环遍历每个小组下的经纪人 */
		for (Group group : groupList) {
			Map<String, Object> map1 = new HashMap<>();
			List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
			List<Broker> brokerList = brokerMapper.getBrokerByGroupId(group.getId());
			/** 计算每个小组下的成员对应成交单数与佣金金额 */
			for (Broker broker : brokerList) {
				Map<String, Object> map2 = new HashMap<>();
				SucceedDealListVo succeedDealListVo = new SucceedDealListVo();
				succeedDealListVo
						.setSingular(succeedDealMapper.selectByPrimaryCount(broker.getId(), startTime, endTime));
				succeedDealListVo
						.setBrokerage(succeedDealMapper.selectByPrimarySum(broker.getId(), startTime, endTime));
				map2.put("name", broker.getReal_name());
				map2.put("succeedDealListVo", succeedDealListVo);
				list2.add(map2);
			}
			map1.put("groupName", group.getName());
			map1.put("list", list2);
			list.add(map1);
		}
		return list;
	}

	@Override
	public SucceedDealVo1 getById(Long id) throws Exception {
		SucceedDealVo1 succeedDealVo = new SucceedDealVo1();
		Double Money = 0.0;
		BeanUtil.copyProperties(succeedDealVo, succeedDealMapper.selectByPrimaryKey(id));
		HousesNew housesNew = housesNewMapper.selectByPrimaryKey(succeedDealVo.getHouse_id());
		User user = userMapper.selectByPrimaryKey(succeedDealVo.getParty_b_user_id());
		UserFollowUp userFollowUp = userFollowUpMapper.getByUserIdOrNew(succeedDealVo.getParty_b_user_id());
		DivideInto divideInto = DivideIntoMapper.listDivideIntoByCondition().get(0);
		succeedDealVo.setUserPhones(userPhoneMapper.listByUserId(succeedDealVo.getParty_b_user_id()));
		List<SuccedDealCost> succedDealCosts = succedDealCostMapper.listBySucceedId(succeedDealVo.getId());
		succeedDealVo.setSuccedDealCosts(succedDealCosts);
		for (SuccedDealCost succedDealCost : succedDealCosts) {
			Money += succedDealCost.getMoney();
		}
		List<PushMoney> pushMoneys = new ArrayList<>();
		/** 合同成交 */
		PushMoney pushMoney1 = new PushMoney();
		/** 客源维护 */
		PushMoney pushMoney2 = new PushMoney();
		/** 客源录入 */
		PushMoney pushMoney3 = new PushMoney();
		/** 房源维护 */
		PushMoney pushMoney4 = new PushMoney();
		/** 房源开盘 */
		PushMoney pushMoney5 = new PushMoney();
		/** 房源录入 */
		PushMoney pushMoney6 = new PushMoney();
		/** 房源实勘 */
		PushMoney pushMoney7 = new PushMoney();
		/** 拿钥匙 */
		PushMoney pushMoney8 = new PushMoney();
		// 成交人分成
		pushMoney1.setName(brokerMapper.selectByPrimaryKey(succeedDealVo.getBroker_id()).getReal_name());
		pushMoney1.setCause("合同成交");
		pushMoney1.setProportion(divideInto.getPact_clinch_per());
		pushMoney1.setPerformance(Money * divideInto.getPact_clinch_per() / 100);
		// 客源维护
		pushMoney2.setName(brokerMapper.selectByPrimaryKey(userFollowUp.getBroker_id()).getReal_name());
		pushMoney2.setCause("客源维护");
		pushMoney2.setProportion(divideInto.getPassenger_suorce_vindicate_per());
		pushMoney2.setPerformance(Money * divideInto.getPassenger_suorce_vindicate_per() / 100);
		// 客源录入
		pushMoney3.setName(brokerMapper.selectByPrimaryKey(user.getBroker_id()).getReal_name());
		pushMoney3.setCause("客源录入");
		pushMoney3.setProportion(divideInto.getPassenger_suorce_enter_per());
		pushMoney3.setPerformance(Money * divideInto.getPassenger_suorce_enter_per() / 100);
		// 房源维护
		pushMoney4.setName(brokerMapper.selectByPrimaryKey(housesNew.getMaintain_broker_id()).getReal_name());
		pushMoney4.setCause("房源维护");
		pushMoney4.setProportion(divideInto.getVindicate_per());
		pushMoney4.setPerformance(Money * divideInto.getVindicate_per() / 100);
		// 房源开盘
		pushMoney5.setName(brokerMapper.selectByPrimaryKey(housesNew.getOpen_broker_id()).getReal_name());
		pushMoney5.setCause("房源开盘");
		pushMoney5.setProportion(divideInto.getOpen_quot_per());
		pushMoney5.setPerformance(Money * divideInto.getOpen_quot_per() / 100);
		// 房源录入
		pushMoney6.setName(brokerMapper.selectByPrimaryKey(housesNew.getEntering_broker_id()).getReal_name());
		pushMoney6.setCause("房源录入");
		pushMoney6.setProportion(divideInto.getEnter_per());
		pushMoney6.setPerformance(Money * divideInto.getEnter_per() / 100);
		// 房源实勘
		if (housesNew.getSolid_broker_id() == null) {
			pushMoney7.setName("-");
			pushMoney7.setCause("房源实勘");
			pushMoney7.setProportion(0);
			pushMoney7.setPerformance(0.00);
			// 如果没有实勘人则按规则分配
			switch (divideInto.getSend_photo_allot()) {
			// 分配给录入人
			case 1:
				// 原录入人分配比例加上实勘人分配比例
				pushMoney6.setProportion(pushMoney6.getProportion() + divideInto.getSend_photo_per());
				// 重新计算分成金额
				pushMoney6.setPerformance(Money * (pushMoney6.getProportion()) / 100);
				break;
			// 分配给开盘人
			case 2:
				// 原开盘人分配比例加上实勘人分配比例
				pushMoney5.setProportion(pushMoney5.getProportion() + divideInto.getSend_photo_per());
				// 重新计算分成金额
				pushMoney5.setPerformance(Money * (pushMoney5.getProportion()) / 100);
				break;
			// 分配给维护人
			case 3:
				// 原维护人分配比例加上实勘人分配比例
				pushMoney4.setProportion(pushMoney4.getProportion() + divideInto.getSend_photo_per());
				// 重新计算分成金额
				pushMoney4.setPerformance(Money * (pushMoney4.getProportion()) / 100);
				break;
			// 分配给成交人
			case 4:
				// 原成交人分配比例加上实勘人分配比例
				pushMoney1.setProportion(pushMoney1.getProportion() + divideInto.getSend_photo_per());
				// 重新计算分成金额
				pushMoney1.setPerformance(Money * (pushMoney1.getProportion()) / 100);
				break;
			}
		} else {
			pushMoney7.setName(brokerMapper.selectByPrimaryKey(housesNew.getSolid_broker_id()).getReal_name());
			pushMoney7.setCause("房源实勘");
			pushMoney7.setProportion(divideInto.getSend_photo_per());
			pushMoney7.setPerformance(Money * divideInto.getSend_photo_per() / 100);
		}

		// 拿钥匙
		if (housesNew.getKey_broker_id() == null) {
			pushMoney8.setName("-");
			pushMoney8.setCause("拿钥匙");
			pushMoney8.setProportion(0);
			pushMoney8.setPerformance(0.00);
			// 如果没有拿钥匙则按规则分配
			switch (divideInto.getSend_photo_allot()) {
			// 分配给录入人
			case 1:
				// 原录入人分配比例加上拿钥匙分配比例
				pushMoney6.setProportion(pushMoney6.getProportion() + divideInto.getTake_key_per());
				// 重新计算分成金额
				pushMoney6.setPerformance(Money * (pushMoney6.getProportion()) / 100);
				break;
			// 分配给开盘人
			case 2:
				// 原开盘人分配比例加上拿钥匙分配比例
				pushMoney5.setProportion(pushMoney5.getProportion() + divideInto.getTake_key_per());
				// 重新计算分成金额
				pushMoney5.setPerformance(Money * (pushMoney5.getProportion()) / 100);
				break;
			// 分配给维护人
			case 3:
				// 原维护人分配比例加上拿钥匙分配比例
				pushMoney4.setProportion(pushMoney4.getProportion() + divideInto.getTake_key_per());
				// 重新计算分成金额
				pushMoney4.setPerformance(Money * (pushMoney4.getProportion()) / 100);
				break;
			// 分配给成交人
			case 4:
				// 原成交人分配比例加上拿钥匙分配比例
				pushMoney1.setProportion(pushMoney1.getProportion() + divideInto.getTake_key_per());
				// 重新计算分成金额
				pushMoney1.setPerformance(Money * (pushMoney1.getProportion()) / 100);
				break;
			}
		} else {
			pushMoney8.setName(brokerMapper.selectByPrimaryKey(housesNew.getKey_broker_id()).getReal_name());
			pushMoney8.setCause("拿钥匙");
			pushMoney8.setProportion(divideInto.getTake_key_per());
			pushMoney8.setPerformance(Money * divideInto.getTake_key_per() / 100);
		}
		pushMoneys.add(pushMoney1);
		pushMoneys.add(pushMoney2);
		pushMoneys.add(pushMoney3);
		pushMoneys.add(pushMoney4);
		pushMoneys.add(pushMoney5);
		pushMoneys.add(pushMoney6);
		pushMoneys.add(pushMoney7);
		pushMoneys.add(pushMoney8);
		succeedDealVo.setPushMoneys(pushMoneys);
		return succeedDealVo;
	}

}
