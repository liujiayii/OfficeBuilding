package com.yqwl.controller.back;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yqwl.Vo.BrokerVo;
import com.yqwl.Vo.CollectVo;
import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.pojo.Collect;
import com.yqwl.service.CollectService;

/**
 *
 * @ClassName: CollectController
 * @description 经纪人收藏
 * @author linhongyu
 * @createDate 2019年6月12日
 */
@Controller
@RequestMapping("collect")
public class CollectController {
	
	@Resource
	private CollectService collectService;
	/**
	 * @Title: insertSelective
	 * @description 经纪人收藏房源
	 * @param @param record
	 * @param @return    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年6月12日
	 */
	@RequestMapping(value = "insertSelective", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String insertSelective(Collect record,HttpSession session){
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			Collect collect=collectService.selectTwo(record);
			if(collect==null){
				record.setTime(new Date());
				int num = collectService.insertSelective(record);
				if(num!=0){
			 		return FastJsonUtil.getResponseJson(0, "新增成功", null);
			 	}else {
			 		return FastJsonUtil.getResponseJson(-1, "新增失败", null);
				}
			}
			return FastJsonUtil.getResponseJson(-1, "该房源已收藏", null);
		} catch (Exception e) {
			e.printStackTrace();
			return FastJsonUtil.getResponseJson(-200, "系统异常", e);
		}
	}
	/**
	 * @Title: deleteByPrimaryKey
	 * @description 经纪人取消收藏
	 * @param @param id
	 * @param @return    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年6月12日
	 */
	@RequestMapping(value = "deleteByPrimaryKey", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String deleteByPrimaryKey(Long id,HttpSession session){
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			int num = collectService.deleteByPrimaryKey(id);
		 	if(num!=0){
		 		return FastJsonUtil.getResponseJson(0, "删除成功", null);
		 	}else {
		 		return FastJsonUtil.getResponseJson(-1, "删除失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return FastJsonUtil.getResponseJson(-200, "系统异常", e);
		}
	}
	/**
	 * @Title: selectListCo
	 * @description 查询经纪人收藏数据
	 * @param @param broker_id
	 * @param @param session
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年6月13日
	 */
	@RequestMapping(value = "selectListCo", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectListCo(Long broker_id,Integer page,Integer limit,HttpSession session){
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			page=(page-1)*limit;
			Map<String, Object> collectVos= collectService.selectListCo(broker_id,page,limit);
		 	if(collectVos.size()>0){
		 		return FastJsonUtil.getResponseJson(0, "查询成功", collectVos);
		 	}else {
		 		return FastJsonUtil.getResponseJson(-1, "查询失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return FastJsonUtil.getResponseJson(-200, "系统异常", e);
		}
	}
}
