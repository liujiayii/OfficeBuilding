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
import com.yqwl.Vo.BrokerVo;
import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.common.utils.Pager;
import com.yqwl.common.web.BaseController;
import com.yqwl.pojo.Group;
import com.yqwl.service.GroupService;

@Controller
@Scope("prototype")
@RequestMapping("BackGroup")
public class BackGroupController extends BaseController {
	@Autowired
	private GroupService groupService;
	/**
	 * 
	 * @Title: insert
	 * @description 新增小组
	 * @param session
	 * @param group
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年4月26日 下午5:01:09
	 */
	@ResponseBody
	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String insert(HttpSession session,Group group) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				Integer result = groupService.insert(group);
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
	 * @description 修改小组
	 * @param session
	 * @param group
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年4月29日 上午9:13:14
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String update(HttpSession session,Group group) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				Integer result = groupService.update(group);
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
	
	
	@ResponseBody
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String delete(HttpSession session,Long id) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				Integer result = groupService.delete(id);
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
	/**
	 * 
	 * @Title: getByid
	 * @description 查询单个小组
	 * @param session
	 * @param id
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年4月29日 上午9:13:27
	 */
	@ResponseBody
	@RequestMapping(value = "/getByid", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String getByid(HttpSession session,Long id) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				Group result = groupService.getByid(id);
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
	 
	/**
	 * 
	 * @Title: getByShopId
	 * @description 根据店铺查询小组
	 * @param session
	 * @param ShopId
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年5月4日 下午5:37:45
	 */
	@ResponseBody
	@RequestMapping(value = "/getByShopId", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String getByShopId(HttpSession session,Long ShopId) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				List<Group> result = groupService.getByShopId(ShopId);
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
	 * @Title: ListAll
	 * @description 分页查询所有小组
	 * @param session
	 * @param pager
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年4月29日 上午9:13:43
	 */
	@ResponseBody
	@RequestMapping(value = "/ListAll", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String ListAll(HttpSession session,Pager pager) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				PageInfo<Group> result = groupService.ListAll(pager);
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
}
