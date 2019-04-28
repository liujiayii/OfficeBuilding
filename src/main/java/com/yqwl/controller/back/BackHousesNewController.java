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
import com.yqwl.pojo.HousesNew;
import com.yqwl.service.HousesNewService;
import com.yqwl.service.PictureService;

/**
 * 
 * @ClassName: BackHousesNewController
 *
 * @description 后台房源表功能控制层
 *
 * @author yaozijun
 *
 * @createDate 2019年4月23日
 */
@Controller
@Scope("prototype")
@RequestMapping("BackHousesNew")
public class BackHousesNewController extends BaseController{
	@Autowired
	private HousesNewService housesNewService;
	/**
	 * 
	 * @Title: selectBackHousesNewList
	 *
	 * @description 后台列表显示房源
	 *
	 * @param @param pager
	 * @param @return 
	 * 
	 * @return String    
	 *
	 * @author yaozijun
	 *
	 * @createDate 2019年4月23日
	 */
	@RequestMapping(value = "selectBackHousesNewList", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectBackHousesNewList(Pager pager,HttpSession session){
		try {
			int code = 0;
			String msg = null;
			/** 判断是否登录 */
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo!=null) {
				PageInfo<HousesNew> result = housesNewService.listHousesNewByCondition(pager);
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
	 * @Title: insertSelective
	 *
	 * @description 后台新增房源信息及图片信息
	 *
	 * @param @param record
	 * @param @param brokerId
	 * @param @param picture
	 * @param @return 
	 * 
	 * @return String    
	 *
	 * @author yaozijun
	 *
	 * @createDate 2019年4月23日
	 */
	@RequestMapping(value = "insertSelective", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String insertSelective(HousesNew record,HttpSession session,String... urls){
		try {
			/** 判断是否登录 */
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo!=null) {
				int count = housesNewService.insertSelective(record,brokerVo.getId(),urls);
				if(count != 0){
					return FastJsonUtil.getResponseJson(0, "新增成功", null);
				}else {
					return FastJsonUtil.getResponseJson(-1, "新增失败", null);
				}
			}
			return FastJsonUtil.getResponseJson("-2", "未登录");
		} catch (Exception e) {
			return dealException(-200, "系统异常", e);
		}
	}
	
	/**
	 * 
	 * @Title: updateByPrimaryKeySelective
	 *
	 * @description 后台修改房源信息及图片信息
	 *
	 * @param @param record
	 * @param @param session
	 * @param @param urls
	 * @param @return 
	 * 
	 * @return String    
	 *
	 * @author yaozijun
	 *
	 * @createDate 2019年4月23日
	 */
	@RequestMapping(value = "updateByPrimaryKeySelective", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String updateByPrimaryKeySelective(HousesNew record,HttpSession session,String... urls){
		try {
			/** 判断是否登录 */
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				int count = housesNewService.updateByPrimaryKeySelective(record,brokerVo.getId(),urls);
				if(count != 0){
					return FastJsonUtil.getResponseJson(0, "修改成功", null);
				}else {
					return FastJsonUtil.getResponseJson(-1, "修改失败", null);
				}
			}
			return FastJsonUtil.getResponseJson("-2", "未登录");
		} catch (Exception e) {
			return dealException(-200, "系统异常", e);
		}
	}
	
}
