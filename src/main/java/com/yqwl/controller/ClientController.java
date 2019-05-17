package com.yqwl.controller;

import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.pojo.Client;
import com.yqwl.service.ClientService;

/**
 *
 * @ClassName: ClientController
 * @description 前台登录注册功能的controller层
 *
 * @author linhongyu
 * @createDate 2019年4月16日
 */
@Controller
@RequestMapping("client")
public class ClientController {

	@Resource
	private ClientService clientService;
	
	/**
	 * @Title: insert
	 * @description 登录短信验证
	 * @param @param record
	 * @param @param validate
	 * @param @param session
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月16日
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "insert", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String insert(Client record,Integer validate,HttpSession session){
		Integer a=(Integer) session.getAttribute("validate");
		if(!a.equals(validate)){
			return FastJsonUtil.getResponseJson(2, "验证码不正确，请从新发送", null);
		}
		try {
			long phones=record.getPhones();
			Client as=clientService.seleceFindId(phones);
			if(as==null){
				record.setState_time(new Date());
				int client=clientService.insert(record);
				long ids=record.getId();
				if (client != 0) {
					return FastJsonUtil.getResponseJson(0, "注册并登录成功", ids);
				}else {
					return FastJsonUtil.getResponseJson(-1, "登录失败", null);
				}
			}else if(as!=null){
				long id=as.getId();
				return FastJsonUtil.getResponseJson(0, "登录成功", id);
			}else {
				return FastJsonUtil.getResponseJson(-2, "登录失败", null);
			}
		} catch (Exception e) {
			return FastJsonUtil.getResponseJson(-200, "系统异常", e);
		}
	}
}
