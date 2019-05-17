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
import com.yqwl.Vo.ShopVo;
import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.common.utils.Pager;
import com.yqwl.common.web.BaseController;
import com.yqwl.pojo.Shop;
import com.yqwl.service.ShopService;

@Controller
@Scope("prototype")
@RequestMapping("backShop")
public class BackShopController extends BaseController {
	
	@Autowired
	private ShopService shopService;
	
	/**
	 * 
	 * @Title: selectByPrimaryKey
	 *
	 * @description 根据ID查询门店
	 *
	 * @param @param id
	 * @param @return 
	 * 
	 * @return String    
	 *
	 * @author yaozijun
	 *
	 * @createDate 2019年4月23日
	 */
	@RequestMapping(value = "selectByPrimaryKey", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectByPrimaryKey(Long id,HttpSession session){
		try {
			/** 判断是否登录 */
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo!=null) {
				Shop shop = shopService.selectByPrimaryKey(id);
				if(shop != null){
			 		return FastJsonUtil.getResponseJson(0, "查询成功", shop);
			 	}else {
			 		return FastJsonUtil.getResponseJson(1, "查询失败", null);
				}
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
	 * @description 新增门店信息
	 *
	 * @param @param record
	 * @param @param session
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
	public String insertSelective(Shop record,HttpSession session){
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				int count = shopService.insertSelective(record);
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
	 * @description 修改门店信息
	 *
	 * @param @param record
	 * @param @param session
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
	public String updateByPrimaryKeySelective(Shop record,HttpSession session){
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo!=null) {
				int count = shopService.updateByPrimaryKeySelective(record);
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
	/**
	 * 
	 * @Title: listAll
	 * @description 查询所有店铺
	 * @param session
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年4月26日 下午3:59:32
	 */
	@RequestMapping(value = "listAll", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String listAll(HttpSession session){
		try {
			/** 判断是否登录 */
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo!=null) {
				List<Shop> shop = shopService.listAll();
				if(shop.size() != 0){
			 		return FastJsonUtil.getResponseJson(0, "查询成功", shop);
			 	}else {
			 		return FastJsonUtil.getResponseJson(1, "查询失败", null);
				}
			}
			return FastJsonUtil.getResponseJson("-2", "未登录");
		} catch (Exception e) {
			return dealException(-200, "系统异常", e);
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
				Integer result = shopService.delete(id);
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
	 * @Title: listAll
	 * @description 分页查询所有店铺
	 * @param session
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年4月26日 下午3:59:32
	 */
	@RequestMapping(value = "listAllOnPage", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String listAllOnPage(HttpSession session,Pager pager){
		try {
			/** 判断是否登录 */
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo!=null) {
				PageInfo<ShopVo> shop = shopService.seleceShopList(pager);
				if(shop.getList().size() != 0){
			 		return FastJsonUtil.getResponseJson(0, "查询成功", shop);
			 	}else {
			 		return FastJsonUtil.getResponseJson(1, "查询失败", null);
				}
			}
			return FastJsonUtil.getResponseJson("-2", "未登录");
		} catch (Exception e) {
			return dealException(-200, "系统异常", e);
		}
	}
}
