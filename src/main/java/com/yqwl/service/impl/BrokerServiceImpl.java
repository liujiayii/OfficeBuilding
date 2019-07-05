package com.yqwl.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yqwl.Vo.BackBrokerVo;
import com.yqwl.Vo.BrokerVo;
import com.yqwl.common.utils.BeanUtil;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.common.utils.ListUtils;
import com.yqwl.common.utils.MD5Util;
import com.yqwl.common.utils.MapUtil;
import com.yqwl.common.utils.NumberUtil;
import com.yqwl.common.utils.Pager;
import com.yqwl.common.utils.StringUtils;
import com.yqwl.common.web.BizException;
import com.yqwl.dao.BrokerMapper;
import com.yqwl.dao.BrokerRoleMapper;
import com.yqwl.dao.FunctionMapper;
import com.yqwl.dao.GroupMapper;
import com.yqwl.dao.RoleMapper;
import com.yqwl.dao.ShopMapper;
import com.yqwl.pojo.Broker;
import com.yqwl.pojo.BrokerRole;
import com.yqwl.pojo.Function;
import com.yqwl.pojo.Group;
import com.yqwl.pojo.Role;
import com.yqwl.pojo.Shop;
import com.yqwl.service.BrokerService;



/**
 *
 * @ClassName: BrokerServiceImpl
 * @description 经纪人接口实现层
 *
 * @author linhongyu
 * @createDate 2019年4月11日
 */
@Service("brokerService")
@Transactional(rollbackFor = { Exception.class })
public class BrokerServiceImpl implements BrokerService{
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
	private BrokerMapper brokerMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private FunctionMapper functionMapper;
	@Autowired
	private BrokerRoleMapper brokerRoleMapper;
	/**
	 * @Title: selectByPrimaryKey
	 * @description 通过id查询经纪人
	 * @param @param id
	 * @param @return
	 * @param @throws Exception    
	 * @return Broker    
	 * @author linhongyu
	 * @createDate 2019年4月29日
	 */
	@Autowired
	private GroupMapper groupMapper;
	@Autowired
	private ShopMapper shopMapper;
	
	@Override
	public Broker selectByPrimaryKey(Long id) throws Exception{
		return brokerMapper.selectByPrimaryKey(id);
	}
	/**
	 * 登陆
	 */
	@Override
	public BrokerVo login(String userName, String password) throws Exception {
		//验证账号密码
		Broker broker = verify(userName,password);
		BrokerVo brokerVo = new BrokerVo();
		BeanUtil.copyProperties(brokerVo,broker);
		//查询账号的所有角色
		List<Role> roles = roleMapper.getBrokerByRole(broker.getId());
		brokerVo.setRoles(roles);
		List<Function> functions = new ArrayList<>();
		//查询角色的所有权限 重复权限滤重
		for (Role role : roles) {
			List<Function> list = functionMapper.getFunctionByRoleId(role.getId());
			functions.removeAll(list);
			functions.addAll(list);
		}
		JSONArray jsonArray = ListUtils.listToTree(JSONArray.parseArray(JSON.toJSONString(functions)), "id", "pid", "children");
		brokerVo.setFunctions(jsonArray);
		brokerVo.setCityId(brokerMapper.getBrokerByCityId(broker.getGroup_id()));
		return brokerVo;
	}

	private Broker verify(String userName, String password) throws Exception{
		if (StringUtils.isEmpty(userName)) {
			logger.error("用户名为空");
			throw new BizException(FastJsonUtil.getResponseJsonNotEmpty(2004, "用户名为空", null));
		}
		if (StringUtils.isEmpty(password)) {
			logger.error("密码为空");
			throw new BizException(FastJsonUtil.getResponseJsonNotEmpty(2001, "密码为空", null));
		}
		String encrypt = MD5Util.getMD5Code(password);
		Broker broker = brokerMapper.getByUserNameAndPassword(userName,encrypt);
		if (broker == null) {
			throw new BizException(FastJsonUtil.getResponseJsonNotEmpty(1000, "用户名或密码错误", null));
		}
		return broker;
	}
	@Override
	public Integer insertBroker(Broker broker, Long... roleIds) throws Exception {
		int i = brokerMapper.insertSelective(broker);
		for (Long long1 : roleIds) {
			System.out.println(long1);
			BrokerRole brokerRole = new BrokerRole();
			brokerRole.setBroker_id(broker.getId());
			brokerRole.setRole_id(long1);
			brokerRoleMapper.insertSelective(brokerRole);
		}
		return i;
	}
	@Override
	public Integer updateBroker(Broker broker, Long... roleIds) throws Exception {
		brokerRoleMapper.delByBrokerId(broker.getId());
		for (Long long1 : roleIds) {
			BrokerRole brokerRole = new BrokerRole();
			brokerRole.setBroker_id(broker.getId());
			brokerRole.setRole_id(long1);
			brokerRoleMapper.insertSelective(brokerRole);
		}
		return brokerMapper.updateByPrimaryKeySelective(broker);
	}
	/**
	 * @Title: listAll
	 * @description 查询所有经纪人信息
	 * @param @return
	 * @param @throws Exception    
	 * @return List<Broker>    
	 * @author linhongyu
	 * @createDate 2019年4月29日
	 */
	@Override
	public List<Broker> listAll() throws Exception {
		return brokerMapper.listAll();
	}
	@Override
	public BackBrokerVo getById(Long id) throws Exception {
		Broker broker =  brokerMapper.selectByPrimaryKey(id);
		List<Role> roles = roleMapper.getBrokerByRole(id);
		Group group = groupMapper.selectByPrimaryKey(broker.getGroup_id());
		Shop shop = shopMapper.selectByPrimaryKey(group.getShop_id());
		BackBrokerVo backBrokerVo = new BackBrokerVo();
		BeanUtil.copyProperties(backBrokerVo,broker);
		backBrokerVo.setGroup(group);
		backBrokerVo.setShop(shop);
		backBrokerVo.setRoles(roles);
		return backBrokerVo;
	}
	@Override
	public PageInfo<Broker> ListBackBroker(Pager pager) throws Exception {
		Map<String, Object> conditions = MapUtil.formSerializeToMap(pager.getFilter());
		String condition = StringUtils.getFirstString(conditions.get("condition"));
		PageHelper.startPage(pager);
		List<Broker> list = brokerMapper.listByCondition(condition);
		return new PageInfo<Broker>(list);
	}
	@Override
	public List<Broker> getByGroupId(Long groupId) throws Exception {
		return brokerMapper.getBrokerByGroupId(groupId);
	}
	@Override
	public List<Broker> listAllByStatus(Integer status,Integer cityId) throws Exception {
		return brokerMapper.listAllByStatus(status,cityId);
	}
	

}
