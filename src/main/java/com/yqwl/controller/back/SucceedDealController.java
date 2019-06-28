package com.yqwl.controller.back;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.yqwl.Vo.BrokerVo;
import com.yqwl.Vo.SucceedDealVo;
import com.yqwl.Vo.SucceedDealVo1;
import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.common.utils.Pager;
import com.yqwl.common.web.BaseController;
import com.yqwl.pojo.SuccedDealCost;
import com.yqwl.pojo.SucceedDeal;
import com.yqwl.pojo.User;
import com.yqwl.service.SucceedDealService;

@Controller
@RequestMapping("SuccedDeal")
public class SucceedDealController extends BaseController {
	@Autowired
	private SucceedDealService succeedDealService;
	/**
	 * 
	 * @Title: insert
	 * @description 新增录入成交
	 * @param session
	 * @param succeedDeal
	 * @param succedDealCosts
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年6月18日 下午1:40:38
	 */
	@ResponseBody
	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String insert(HttpSession session,SucceedDeal succeedDeal,String succedDealCosts) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				Integer result = succeedDealService.insert(succeedDeal,succedDealCosts);
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
	 * @Title: update
	 * @description 修改录入成交
	 * @param session
	 * @param succeedDeal
	 * @param succedDealCosts
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年6月18日 下午1:40:49
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String update(HttpSession session,SucceedDeal succeedDeal,String succedDealCosts) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				Integer result = succeedDealService.update(succeedDeal,succedDealCosts);
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
	 * @description 分页查询所有
	 * @param pager
	 * @param session
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年6月18日 下午1:41:01
	 */
	@RequestMapping(value = "listAll", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String listAll(Pager pager,HttpSession session){
		try {
			int code = 0;
			String msg = null;
			/** 判断是否登录 */
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo!=null) {
				PageInfo<SucceedDealVo> result = succeedDealService.listAll(pager);
				if (result.getTotal() != 0) {
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
	
	
	@RequestMapping(value = "getById", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String getById(Long id,HttpSession session){
		try {
			int code = 0;
			String msg = null;
			/** 判断是否登录 */
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo!=null) {
				SucceedDealVo1 result = succeedDealService.getById(id);
				if (result != null) {
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
	 * @Title: selectByPrimaryCount
	 * @description 查询经纪人成交单数和金额
	 * @param @param shopId
	 * @param @param startTime
	 * @param @param endTime
	 * @param @param session
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年6月17日
	 */
	@RequestMapping(value = "selectByPrimaryCount", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectByPrimaryCount(Long shopId,Date startTime, Date endTime,HttpSession session){
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			List<Map<String, Object>> num = succeedDealService.selectByPrimaryCount(shopId, endTime, endTime);
		 	if(num.size()!=0){
		 		return FastJsonUtil.getResponseJson(0, "查询成功", num);
		 	}else {
		 		return FastJsonUtil.getResponseJson(-1, "查询失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return FastJsonUtil.getResponseJson(-200, "系统异常", e);
		}
	}
	
	
}
