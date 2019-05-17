package com.yqwl.controller.back;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yqwl.Vo.BrokerVo;
import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.common.web.BaseController;
import com.yqwl.pojo.Entrustsee;
import com.yqwl.service.EntrustseeService;

/**
 *
 * @ClassName: EntrustseeController
 * @description 预约看房后台管理Controller层
 *
 * @author linhongyu
 * @createDate 2019年4月22日
 */
@Controller
@RequestMapping("entrustsee")
public class EntrustseeControllers extends BaseController{
	@Resource
	private EntrustseeService entrustseeService;
	
	/**
	 * @Title: updateType
	 * @description 修改预约看房状态
	 * @param @param seetype
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月10日
	 */
	@RequestMapping(value = "updateType", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String updateType(Entrustsee record,HttpSession session){
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			int num=entrustseeService.updateType(record);
		 	if(num!=0){
		 		return FastJsonUtil.getResponseJson(0, "修改成功", null);
		 	}else {
		 		return FastJsonUtil.getResponseJson(-1, "修改失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return dealException(-200, "系统异常", e);
		}
	}
	/**
	 * @Title: selectAllEN
	 * @description 后台查询所有预约看房
	 * @param @param record
	 * @param @param page
	 * @param @param limit
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月10日
	 */
	@RequestMapping(value = "selectAllEN", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectAllEN(Long broker_id,Integer page,Integer limit,HttpSession session){
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			page = (page-1)*limit;
			Map<String, Object> ent=entrustseeService.selectAllEN(broker_id,page,limit);
		 	if(ent.size()>0){
		 		return FastJsonUtil.getResponseJson(0, "查询成功", ent);
		 	}else {
		 		return FastJsonUtil.getResponseJson(-1, "查询失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return dealException(-200, "系统异常", e);
		}
	}
	/**
	 * @Title: updateBoerk
	 * @description 抢单成功
	 * @param @param broker_id
	 * @param @param id
	 * @param @param session
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月24日
	 */
	@RequestMapping(value = "updateBoerk", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String updateBoerk(Long broker_id,Long id,HttpSession session){
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			int num=entrustseeService.updateBoerk(broker_id, id);
		 	if(num!=0){
		 		return FastJsonUtil.getResponseJson(0, "抢单成功", null);
		 	}else {
		 		return FastJsonUtil.getResponseJson(-1, "抢单失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return dealException(-200, "系统异常", e);
		}
	}
	/**
	 * @Title: selectBroker
	 * @description 经纪人查询预约的数据 
	 * @param @param broker_id
	 * @param @param session
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月24日
	 */
	@RequestMapping(value = "selectBroker", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectBroker(Long broker_id,HttpSession session,Integer page,Integer limit){
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			Map<String, Object> entrustsees=entrustseeService.selectBroker(broker_id,page,limit);
		 	if(entrustsees.size()>0){
		 		return FastJsonUtil.getResponseJson(0, "查询成功", entrustsees);
		 	}else {
		 		return FastJsonUtil.getResponseJson(-1, "查询失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return dealException(-200, "系统异常", e);
		}
	}
}
