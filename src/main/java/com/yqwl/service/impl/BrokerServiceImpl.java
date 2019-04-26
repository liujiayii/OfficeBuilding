package com.yqwl.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.yqwl.Vo.BrokerVo;
import com.yqwl.common.utils.BeanUtil;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.common.utils.ListUtils;
import com.yqwl.common.utils.MD5Util;
import com.yqwl.common.utils.StringUtils;
import com.yqwl.common.web.BizException;
import com.yqwl.dao.BrokerMapper;
import com.yqwl.dao.FunctionMapper;
import com.yqwl.dao.RoleMapper;
import com.yqwl.pojo.Broker;
import com.yqwl.pojo.Function;
import com.yqwl.pojo.Role;
import com.yqwl.service.BrokerService;



/**
 *
 * @ClassName: BrokerServiceImpl
 * @description 用一句话描述这个类的作用
 *
 * @author 姓名全拼
 * @createDate 2019年4月11日
 */
@Service("brokerService")
public class BrokerServiceImpl implements BrokerService{
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
	private BrokerMapper brokerMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private FunctionMapper functionMapper;
	@Override
	public Broker selectByPrimaryKey(Long id) {
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
	

}
