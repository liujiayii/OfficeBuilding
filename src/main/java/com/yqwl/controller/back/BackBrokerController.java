package com.yqwl.controller.back;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.yqwl.Vo.BackBrokerVo;
import com.yqwl.Vo.BrokerVo;
import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.common.utils.Pager;
import com.yqwl.common.web.BaseController;
import com.yqwl.dao.BrokerMapper;
import com.yqwl.dao.GroupMapper;
import com.yqwl.pojo.Broker;
import com.yqwl.pojo.Group;
import com.yqwl.pojo.HousesNew;
import com.yqwl.service.BrokerService;
import com.yqwl.service.GroupService;

@Controller
@Scope("prototype")
@RequestMapping("BackBroker")
public class BackBrokerController extends BaseController{
	@Autowired
	private BrokerService brokerService;
	@Autowired
	private BrokerMapper brokerMapper;
	@Autowired
	private GroupMapper groupMapper;
	/**
	 * 
	 * @Title: insertBroker
	 * @description 新增经纪人
	 * @param session
	 * @param Broker
	 * @param roleIds
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年4月29日 上午9:12:05
	 */
	@ResponseBody
	@RequestMapping(value = "/insertBroker", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String insertBroker(HttpSession session, Broker Broker, Long... roleIds) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				Integer result = brokerService.insertBroker(Broker, roleIds);
				if (result != 0) {
					msg = "新增成功";
					return FastJsonUtil.getResponseJson(code, msg, result);
				}
				code = -1;
				msg = "新增失败";
				return FastJsonUtil.getResponseJson(code, msg, null);
			}
			msg = "未登录";
			return FastJsonUtil.getResponseJson("-2", msg);
		} catch (Exception e) {
			code = -200;
			msg = "系统异常";
			return dealException(code, msg, e);
		}
	}
	/**
	 * 
	 * @Title: updateBroker
	 * @description 修改经纪人
	 * @param session
	 * @param Broker
	 * @param roleIds
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年4月29日 上午9:12:16
	 */
	@ResponseBody
	@RequestMapping(value = "/updateBroker", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String updateBroker(HttpSession session, Broker Broker, Long... roleIds) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				Integer result = brokerService.updateBroker(Broker, roleIds);
				if (result != 0) {
					msg = "修改成功";
					return FastJsonUtil.getResponseJson(code, msg, result);
				}
				code = -1;
				msg = "修改失败";
				return FastJsonUtil.getResponseJson(code, msg, null);
			}
			msg = "未登录";
			return FastJsonUtil.getResponseJson("-2", msg);
		} catch (Exception e) {
			code = -200;
			msg = "系统异常";
			return dealException(code, msg, e);
		}
	}
	/**
	 * 
	 * @Title: listAll
	 * @description 查询所有经纪人
	 * @param session
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年4月29日 上午9:12:41
	 */
	@ResponseBody
	@RequestMapping(value = "/listAll", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String listAll(HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				List<Broker> result = brokerService.listAll();
				if (result.size() != 0) {
					msg = "查询成功";
					return FastJsonUtil.getResponseJson(code, msg, result);
				}
				code = -1;
				msg = "查询失败";
				return FastJsonUtil.getResponseJson(code, msg, null);
			}
			msg = "未登录";
			return FastJsonUtil.getResponseJson("-2", msg);
		} catch (Exception e) {
			code = -200;
			msg = "系统异常";
			return dealException(code, msg, e);
		}
	}
	
	/**
	 * 
	 * @Title: listAll
	 * @description 根据状态查询所有经纪人
	 * @param session
	 * @param status
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年7月4日 下午5:07:36
	 */
	@ResponseBody
	@RequestMapping(value = "/listAllByStatus", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String listAll(HttpSession session,Integer status,Integer cityId) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				List<Broker> result = brokerService.listAllByStatus(status,cityId);
				if (result.size() != 0) {
					msg = "查询成功";
					return FastJsonUtil.getResponseJson(code, msg, result);
				}
				code = -1;
				msg = "查询失败";
				return FastJsonUtil.getResponseJson(code, msg, null);
			}
			msg = "未登录";
			return FastJsonUtil.getResponseJson("-2", msg);
		} catch (Exception e) {
			code = -200;
			msg = "系统异常";
			return dealException(code, msg, e);
		}
	}
	
	/**
	 * 
	 * @Title: ListBackBroker
	 * @description 分页查询所有经纪人
	 * @param pager
	 * @param session
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年5月5日 上午9:47:29
	 */
	@RequestMapping(value = "ListBackBroker", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String ListBackBroker(Pager pager,HttpSession session){
		try {
			int code = 0;
			String msg = null;
			/** 判断是否登录 */
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo!=null) {
				PageInfo<Broker> result = brokerService.ListBackBroker(pager);
				if (result.getList().size() != 0) {
					msg = "查询成功";
					return FastJsonUtil.getResponseJson(code, msg, result);
				}
				code = -1;
				msg = "查询失败";
				return FastJsonUtil.getResponseJson(code, msg, null);
			}
			return FastJsonUtil.getResponseJson("-2", "未登录");
		} catch (Exception e) {
			return dealException(-200, "系统异常", e);
		}
	}
	/**
	 * 
	 * @Title: getById
	 * @description 根据ID查询单个经纪人
	 * @param session
	 * @param id
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年4月29日 上午9:12:59
	 */
	@ResponseBody
	@RequestMapping(value = "/getById", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String getById(HttpSession session,Long id) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				BackBrokerVo result = brokerService.getById(id);
				if (result != null) {
					msg = "查询成功";
					return FastJsonUtil.getResponseJson(code, msg, result);
				}
				code = -1;
				msg = "查询失败";
				return FastJsonUtil.getResponseJson(code, msg, null);
			}
			msg = "未登录";
			return FastJsonUtil.getResponseJson("-2", msg);
		} catch (Exception e) {
			code = -200;
			msg = "系统异常";
			return dealException(code, msg, e);
		}
	}
	
	
	
	@ResponseBody
	@RequestMapping(value = "/getByGroupId", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String getByGroupId(HttpSession session,Long groupId) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				List<Broker> result = brokerService.getByGroupId(groupId);
				if (result.size() != 0) {
					msg = "查询成功";
					return FastJsonUtil.getResponseJson(code, msg, result);
				}
				code = -1;
				msg = "查询失败";
				return FastJsonUtil.getResponseJson(code, msg, null);
			}
			msg = "未登录";
			return FastJsonUtil.getResponseJson("-2", msg);
		} catch (Exception e) {
			code = -200;
			msg = "系统异常";
			return dealException(code, msg, e);
		}
	}
	/**
	 * 
	 *
	 * @Title: selectShopBorker
	 * @description 查询一个门店的经纪人信息
	 * @param @param session
	 * @param @param id
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年6月11日
	 */
	@ResponseBody
	@RequestMapping(value = "/selectShopBorker", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String selectShopBorker(HttpSession session,Long id) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo !=null) {
				List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				Broker result = brokerService.selectByPrimaryKey(id);
				Group group=groupMapper.selectByPrimaryKey(result.getGroup_id());
				List<Group> groups=groupMapper.getByShopId(group.getShop_id());
				for (Group group2 : groups) {
					List<Broker> brokers=brokerMapper.getBrokerByGroupId(group2.getId());
					for (Broker broker : brokers) {
						Map<String, Object> param = new LinkedHashMap<String, Object>();
						param.put("id", broker.getId());
						param.put("real_name", broker.getReal_name());
						list.add(param);
					}
				}
				if (list.size() != 0) {
					msg = "查询成功";
					return FastJsonUtil.getResponseJson(code, msg, list);
				}
				code = -1;
				msg = "查询失败";
				return FastJsonUtil.getResponseJson(code, msg, null);
			}
			msg = "未登录";
			return FastJsonUtil.getResponseJson("-2", msg);
		} catch (Exception e) {
			code = -200;
			msg = "系统异常";
			return dealException(code, msg, e);
		}
	}
	
	
	/**
	 * 
	 * @Title: resourceTransfer
	 * @description 资源转移
	 * @param session
	 * @param brokerId
	 * @param houseTarget
	 * @param userTarget
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年7月15日 上午10:34:23
	 */
	@ResponseBody
	@RequestMapping(value = "/resourceTransfer", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String resourceTransfer(HttpSession session,Long brokerId,Long houseTarget,Long userTarget) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				Integer result = brokerService.resourceTransfer(brokerId,houseTarget,userTarget);
				if (result != 0) {
					msg = "转移成功";
					return FastJsonUtil.getResponseJson(code, msg, result);
				}
				code = -1;
				msg = "无信息可转移";
				return FastJsonUtil.getResponseJson(code, msg, null);
			}
			msg = "未登录";
			return FastJsonUtil.getResponseJson("-2", msg);
		} catch (Exception e) {
			code = -200;
			msg = "系统异常";
			return dealException(code, msg, e);
		}
	}
	
}
