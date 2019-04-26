package com.yqwl.controller.back;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yqwl.Vo.BrokerVo;
import com.yqwl.Vo.FuncRoleVo;
import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.common.utils.UpdateFile;
import com.yqwl.common.web.BaseController;
import com.yqwl.pojo.Role;
import com.yqwl.service.FunctionService;
import com.yqwl.service.RoleService;

@Controller
@Scope("prototype")
@RequestMapping("SystemSettings")
public class SystemSettingsController extends BaseController {
	@Autowired
	private RoleService roleService;
	@Autowired
	private FunctionService functionService;
	/**
	 * 
	 * @Title: insertRole
	 * @description 新增角色
	 * @param session
	 * @param role
	 * @param functionIds
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年4月23日 下午5:13:31
	 */
	@ResponseBody
	@RequestMapping(value = "/insertRole", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String insertRole(HttpSession session, Role role, Long... functionIds) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				Integer result = roleService.insertRole(role, functionIds);
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
	 * @Title: listAllFunction
	 * @description 查询所有权限和角色的所有权限
	 * @param session
	 * @param roleId
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年4月23日 下午5:13:46
	 */
	@ResponseBody
	@RequestMapping(value = "/listAllFunction", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String listAllFunction(HttpSession session,@RequestParam(value = "roleId", required = false) Long roleId) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				FuncRoleVo result = functionService.listAllFunction(roleId);
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
	 * @Title: updateFile
	 * @description 上传图片
	 * @param session
	 * @param file
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年4月23日 下午5:24:23
	 */
	@ResponseBody
	@RequestMapping(value = "/updateFile", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String updateFile(HttpSession session, MultipartFile file) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				String url = UpdateFile.update(file);
				msg = "上传成功";
				return FastJsonUtil.getResponseJson(code, msg, url);
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
	 * @Title: UpdateRole
	 * @description 修改角色
	 * @param session
	 * @param role
	 * @param functionIds
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年4月23日 下午5:24:35
	 */
	@ResponseBody
	@RequestMapping(value = "/UpdateRole", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String UpdateRole(HttpSession session, Role role,Long... functionIds) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				Integer result = roleService.UpdateRole(role,functionIds);
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
}
