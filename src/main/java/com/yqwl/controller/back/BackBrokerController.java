package com.yqwl.controller.back;

import java.util.List;

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
import com.yqwl.pojo.Broker;
import com.yqwl.pojo.HousesNew;
import com.yqwl.service.BrokerService;

@Controller
@Scope("prototype")
@RequestMapping("BackBroker")
public class BackBrokerController extends BaseController{
	@Autowired
	private BrokerService brokerService;
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
			System.out.println(pager);
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
}
