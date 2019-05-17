package com.yqwl.controller.back;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.yqwl.Vo.BrokerVo;
import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.common.utils.Pager;
import com.yqwl.common.web.BaseController;
import com.yqwl.pojo.Existing;
import com.yqwl.service.HomePageRecommendedService;

@Controller
@Scope("prototype")
@RequestMapping("BackExisting")
public class BackExistingController extends BaseController{
	
	@Autowired
	private HomePageRecommendedService homePageRecommendedService;
	
	/**
	 * 
	 * @Title: pagerListAll
	 * @description 分页查询录入地区
	 * @param session
	 * @param pager
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年5月6日 下午2:38:19
	 */
	@ResponseBody
	@RequestMapping(value = "/pagerListAll", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String pagerListAll(HttpSession session,Pager pager) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				PageInfo<Existing> result = homePageRecommendedService.pagerListAll(pager);
				if (result.getList().size() != 0) {
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
	 * @Title: insert
	 * @description 新增房源地区
	 * @param session
	 * @param existing
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年5月6日 下午2:39:56
	 */
	@ResponseBody
	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String insert(HttpSession session,Existing existing) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				Integer result = homePageRecommendedService.insert(existing);
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
	 * @Title: deleteExisting
	 * @description 删除房源地区 
	 * @param session
	 * @param id
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年5月6日 下午2:46:03
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteExisting", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String deleteExisting(HttpSession session,Long id) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				Integer result = homePageRecommendedService.deleteExisting(id);
				if (result != 0) {
					msg = "删除成功";
					return FastJsonUtil.getResponseJson(code, msg, result);
				}
				code = -1;
				msg = "删除失败";
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
