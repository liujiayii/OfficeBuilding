package com.yqwl.controller.back;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yqwl.Vo.BrokerVo;
import com.yqwl.Vo.DelegationVo;
import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.common.web.BaseController;
import com.yqwl.pojo.Delegation;
import com.yqwl.service.DelegationService;

/**
 *
 * @ClassName: DelegationControllers
 * @description 委托表controller后台控制层
 *
 * @author linhongyu
 * @createDate 2019年4月22日
 */
@Controller
@RequestMapping("delegation")
public class DelegationControllers extends BaseController{
	
	@Resource
	private DelegationService delegationService;

	/**
	 * @Title: updateFindID
	 * @description 修改委托找房当前状态或备注
	 * @param @param record
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月10日
	 */
	@RequestMapping(value = "updateFindID", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String updateFindID(Delegation record,HttpSession session){
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			int num=delegationService.updateFindID(record);
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
	 * @Title: selectDeleAll
	 * @description 查询委托看房数据
	 * @param @param recorrdVo
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月20日
	 */
	@RequestMapping(value = "selectDeleAll", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectDeleAll(DelegationVo recorrdVo,Integer page,Integer limit,HttpSession session){
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			recorrdVo.setPage((page-1)*limit);
			recorrdVo.setLimit(limit);
			List<DelegationVo> dele=delegationService.selectDeleAll(recorrdVo);
			Integer count=delegationService.selectCont(recorrdVo);
			Map<String ,Object > map=new HashMap<String ,Object >();
			map.put("date", dele);
			map.put("count", count);
		 	if(dele.size()>0){
		 		return FastJsonUtil.getResponseJson(0, "查询成功", map);
		 	}else {
		 		return FastJsonUtil.getResponseJson(-1, "查询失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return dealException(-200, "系统异常", e);
		}
	}
	/**
	 * @Title: updateDeleBroker
	 * @description 对委托找房进行抢单
	 * @param @param broker_id
	 * @param @param id
	 * @param @param session
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月24日
	 */
	@RequestMapping(value = "updateDeleBroker", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String updateDeleBroker(Long broker_id,Long id,HttpSession session){
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			int num=delegationService.updateDeleBroker(broker_id, id);
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
	 * @Title: selectDeleCount
	 * @description 查询经纪人对委托信息的处理信息
	 * @param @param broker_id
	 * @param @param session
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月24日
	 */
	@RequestMapping(value = "selectDeleCount", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectDeleCount(Long broker_id,HttpSession session,Integer page, Integer limit){
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			page = (page-1)*limit;
			Map<String, Object> laun=delegationService.selectDeleCount(broker_id, page, limit);
			if(laun.size()>0){
				return FastJsonUtil.getResponseJson(0, "查询成功", laun);
			}else {
				return FastJsonUtil.getResponseJson(-1, "查询失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return dealException(-200, "系统异常", e);
		}
	}
}
