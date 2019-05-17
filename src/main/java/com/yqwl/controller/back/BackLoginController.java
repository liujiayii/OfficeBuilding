package com.yqwl.controller.back;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yqwl.Vo.BrokerVo;
import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.common.web.BaseController;
import com.yqwl.service.BrokerService;
@Controller
@Scope("prototype")
@RequestMapping("brokerLogin")
public class BackLoginController extends BaseController{
	
	@Autowired
	private BrokerService BrokerService;
	/**
	 * 
	 * @Title: login
	 * @description 后台登陆
	 * @param session
	 * @param userName
	 * @param password
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年4月24日 上午9:29:38
	 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String login(HttpSession session,String userName,String password) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo result = BrokerService.login(userName,password);
			if (result != null) {
				session.setAttribute(Constants.Login_User, result);
				msg = "登陆成功";
				return FastJsonUtil.getResponseJson(code, msg, result);
			}
			code = -1;
			msg = "登陆失败";
			return FastJsonUtil.getResponseJson(code, msg, null);
		} catch (Exception e) {
			code = -200;
			msg = "系统异常";
			return dealException(code, msg, e);
		}
	}
	/**
	 * 
	 * @Title: logout
	 * @description 登出
	 * @param session
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年4月24日 上午9:29:49
	 */
	@ResponseBody
	@RequestMapping(value = "/logout", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String logout(HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			session.invalidate();
			msg = "退出成功";
			return FastJsonUtil.getResponseJson(code, msg, null);
		} catch (Exception e) {
			code = -200;
			msg = "系统异常";
			return dealException(code, msg, e);
		}
	}
}
