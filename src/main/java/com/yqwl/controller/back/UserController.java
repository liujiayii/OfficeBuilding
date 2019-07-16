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
import com.yqwl.Vo.UserVo;
import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.common.utils.Pager;
import com.yqwl.common.web.BaseController;
import com.yqwl.pojo.Group;
import com.yqwl.pojo.HousesNew;
import com.yqwl.pojo.User;
import com.yqwl.pojo.UserFollowUp;
import com.yqwl.pojo.UserPhone;
import com.yqwl.service.UserService;

@Controller
@RequestMapping("user")
public class UserController extends BaseController {
	@Autowired
	private UserService userService;
	/**
	 * 
	 * @Title: insert
	 * @description 添加客户
	 * @param session
	 * @param user
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年6月10日 下午5:19:36
	 */
	@ResponseBody
	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String insert(HttpSession session,User user,String... phone) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				Integer result = userService.insert(user,phone);
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
	 * @Title: updateUserPhone
	 * @description 修改客户手机号
	 * @param session
	 * @param userPhone
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年6月11日 上午10:09:06
	 */
	@ResponseBody
	@RequestMapping(value = "/updateUserPhone", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String updateUserPhone(HttpSession session,UserPhone userPhone) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				Integer result = userService.updateUserPhone(userPhone);
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
	 * @Title: insertUserPhone
	 * @description 添加用户手机号
	 *
	 * @param session
	 * @param userPhone
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年6月18日 上午10:46:51
	 */
	@ResponseBody
	@RequestMapping(value = "/insertUserPhone", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String insertUserPhone(HttpSession session,UserPhone userPhone) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				Integer result = userService.insertUserPhone(userPhone);
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
	 * @Title: update
	 * @description 修改客户
	 * @param session
	 * @param user
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年6月10日 下午5:19:49
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String update(HttpSession session,User user) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				Integer result = userService.update(user);
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
	 * @Title: getByid
	 * @description 查询单条客户信息和跟进
	 * @param session
	 * @param id
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年6月10日 下午5:19:59
	 */
	@ResponseBody
	@RequestMapping(value = "/getByid", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String getByid(HttpSession session,Long id) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				UserVo result = userService.getByid(id);
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
	@RequestMapping(value = "/findAll", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String findAll(HttpSession session) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				List<User> result = userService.findAll();
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
	 * @Title: listAll
	 * @description 分页查询所有客户
	 * @param pager
	 * @param session
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年6月10日 下午5:20:30
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
				PageInfo<UserVo> result = userService.listAll(pager);
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
	
	/**
	 * 
	 * @Title: listAllByShop
	 * @description 本店客源
	 * @param pager
	 * @param session
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年7月15日 下午1:53:52
	 */
	@RequestMapping(value = "listAllByShop", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String listAllByShop(Pager pager,HttpSession session){
		try {
			int code = 0;
			String msg = null;
			/** 判断是否登录 */
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo!=null) {
				PageInfo<UserVo> result = userService.listAllByShop(pager,brokerVo.getId());
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
	
	/**
	 * 
	 * @Title: listAllByShop
	 * @description 我的客源
	 * @param pager
	 * @param session
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年7月15日 下午1:54:15
	 */
	@RequestMapping(value = "listAllByBrokerId", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String listAllByBrokerId(Pager pager,HttpSession session){
		try {
			int code = 0;
			String msg = null;
			/** 判断是否登录 */
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo!=null) {
				PageInfo<User> result = userService.listAllByBrokerId(pager,brokerVo.getId());
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
	
	
	/**
	 * 
	 * @Title: insertUserFollowUp
	 * @description 客户跟进
	 * @param session
	 * @param userFollowUp
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年7月15日 上午11:33:00
	 */
	@ResponseBody
	@RequestMapping(value = "/insertUserFollowUp", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String insertUserFollowUp(HttpSession session,UserFollowUp userFollowUp) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				Integer result = userService.insertUserFollowUp(userFollowUp);
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
	 * @Title: selectListShop
	 * @description 通过区县id查询分店id
	 * @param @param region_id
	 * @param @param session
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年6月13日
	 */
	@RequestMapping(value = "selectListShop", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectListShop(Long region_id,HttpSession session){
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			List<User> num = userService.selectListShop(region_id);
		 	if(num.size()>0){
		 		return FastJsonUtil.getResponseJson(0, "查询成功", null);
		 	}else {
		 		return FastJsonUtil.getResponseJson(-1, "查询失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return FastJsonUtil.getResponseJson(-200, "系统异常", e);
		}
	}
	/**
	 * @Title: selectAllSome
	 * @description 查询客源
	 * @param @param shopId
	 * @param @param startTime
	 * @param @param endTime
	 * @param @return    
	 * @return List<Map<String,Object>>    
	 * @author linhongyu
	 * @createDate 2019年6月17日
	 */
	@RequestMapping(value = "selectAllSome", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectAllSome(Long shopId,Date startTime, Date endTime,HttpSession session){
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			List<Map<String, Object>> num = userService.selectAllSome(shopId, endTime, endTime);
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
