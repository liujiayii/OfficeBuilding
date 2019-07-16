package com.yqwl.controller.back;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.deser.ValueInstantiators.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yqwl.Vo.BrokerVo;
import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.common.web.BaseController;
import com.yqwl.service.ClientService;

/**
 *
 * @ClassName: ClientController
 * @description Client表的controller控制层
 * @author linhongyu
 * @createDate 2019年5月5日
 */
@Controller
@RequestMapping("client")
public class ClientControllers extends BaseController{
	@Autowired
	private ClientService clientService;
	
	/**
	 * @Title: selectClient
	 * @description 查询客户列表并分页条数
	 * @param @param page
	 * @param @param limit
	 * @param @return    
	 * @return List<Client>    
	 * @author linhongyu
	 * @createDate 2019年5月5日
	 */
	@RequestMapping(value = "selectClient", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectClient(Integer page,Integer limit,HttpSession session){
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			page=(page-1)*limit;
			Map<String, Object> map = clientService.selectClient(page,limit);
		 	if(map!=null){
		 		return FastJsonUtil.getResponseJson(0, "查询成功", map);
		 	}else {
		 		return FastJsonUtil.getResponseJson(-1, "查询失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return dealException(-200, "系统异常", e);
		}
	}
}
