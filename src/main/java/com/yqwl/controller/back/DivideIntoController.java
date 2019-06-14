package com.yqwl.controller.back;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
import com.yqwl.pojo.DivideInto;
import com.yqwl.service.DivideIntoService;
/**
 * @ClassName: DivideIntoController
 * @description 分成设置后台控制器
 *
 * @author liuhangjing
 * @createDate 2019年6月09日
 *
 */
@Controller
@RequestMapping("divideInto")
public class DivideIntoController  extends BaseController{
	
	@Resource
	private DivideIntoService divideIntoService;
	/**列表显示*/
	@RequestMapping(value = "selectDivideIntoList",method = RequestMethod.GET,produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectDivideIntoList(Pager pager,HttpSession session){
		System.out.println("分成分页："+pager);
		try {
			int code = 0;
			String msg = null;
			/** 判断是否登录 */
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo!=null) {
				PageInfo<DivideInto> result = divideIntoService.divideIntoByCondition(pager);
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
	/**添加*/
	@ResponseBody
	@RequestMapping(value = "/insertDivideInto", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String insertDivideInto(HttpSession session, DivideInto divideInto) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				Integer result = divideIntoService.insertDivideInto(divideInto);
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
	/**根据id查询*/
	@RequestMapping(value = "/selectDivideIntoById", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectDivideIntoById(Long id,HttpSession session){
		int code = 0;
		String msg = null;
		
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo != null){
			
				DivideInto divideInto = divideIntoService.selectDivideIntoById(id);
				if(divideInto != null){
					msg = "查询成功";
					return FastJsonUtil.getResponseJson(code, msg, divideInto);
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
	/**修改*/
	@ResponseBody
	@RequestMapping(value = "/updateDivideInto", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String updateDivideInto(HttpSession session, DivideInto divideInto) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				Integer result = divideIntoService.updateDivideInto(divideInto);
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
	/**删除*/
	@ResponseBody
	@RequestMapping(value = "/deleteDivideInto", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String deleteDivideInto(HttpSession session, Long id) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				Integer result = divideIntoService.deleteDivideInto(id);
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
