package com.yqwl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.common.utils.Pager;
import com.yqwl.service.GroupService;
import com.yqwl.service.HousesNewService;
import com.yqwl.common.utils.Constants;
import com.yqwl.service.PictureService;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.github.pagehelper.PageInfo;
import com.yqwl.Vo.BrokerVo;
import com.yqwl.Vo.HousesNewVo;
import com.yqwl.pojo.Delegation;
import com.yqwl.pojo.Group;
import com.yqwl.pojo.HousesNew;
import com.yqwl.pojo.Picture;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @ClassName: HousesNewController
 * @description 房源表功能控制层
 *
 * @author linhongyu
 * @createDate 2019年4月9日
 */
@Controller
@RequestMapping("housesNew")
public class HousesNewController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private HousesNewService housesNewService;

 	@Resource
 	private PictureService pictureService;
 	
 	@Resource
 	private GroupService groupService;
 	
	/**
	 * @Title: selectByFindID
	 * @description 查询房源详情
	 * @param @param housesNewVo
	 * @param @param id
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月9日
	 */
	@RequestMapping(value = "selectByFindID", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectByFindID(long id){
		try {
			HousesNewVo hous = housesNewService.selectByFindID(id);
			List<Picture> picture= pictureService.selectPic(id);
			Map<String ,Object > map=new HashMap<String ,Object >();
			map.put("data", hous);
		 	map.put("picture", picture);
		 	System.out.println(map);
		 	if(hous!=null){
		 		return FastJsonUtil.getResponseJson(0, "查询成功", map);
		 	}else {
		 		return FastJsonUtil.getResponseJson(-1, "查询失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return FastJsonUtil.getResponseJson(-200, "系统异常", e);
		}
	 	
	}
	/**
	 * @Title: selectLike
	 * @description 查询同一个城市最新房源
	 * @param @param record
	 * @param @param page
	 * @param @param limit
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月11日
	 */
	@RequestMapping(value = "selectLike", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectLike(HousesNewVo record,Integer page,Integer limit){
		try {
			record.setPage((page-1)*limit);
			record.setLimit(limit);
			List<HousesNewVo> hou=housesNewService.selectLike(record);
		 	if(hou.size()>0){
		 		return FastJsonUtil.getResponseJson(0, "查询成功", hou);
		 	}else {
		 		return FastJsonUtil.getResponseJson(-1, "查询失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return FastJsonUtil.getResponseJson(-200, "系统异常", e);
		}
	 	
	}
	
	
	/**
	 * 
	 * @Title: listHousesNewByCondition
	 * @description 列表查询房源
	 * @param pager
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年4月10日 下午4:37:08
	 */
	@ResponseBody
	@RequestMapping(value = "/listHousesNewByCondition", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	public String listHousesNewByCondition(Pager pager){
		int code = 0;
		String msg = null;
		try {
			PageInfo<HousesNew> result = housesNewService.listHousesNewByCondition(pager);
			if (result.getTotal() != 0) {
				msg = "查询成功";
				return FastJsonUtil.getResponseJson(code, msg, result);
			}
			code = -1;
			msg = "查询失败";
			return FastJsonUtil.getResponseJson(code, msg, null);
		} catch (Exception e) {
			code = -200;
			msg = "系统异常";
			logger.error(e.getMessage(), e);
			return FastJsonUtil.getResponseJson(code, msg, e);
		}
	}
	
	/**
	 * 
	 * @Title: getMapById
	 * @description 地图找房点击查询详细信息
	 * @param BuildingId
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年4月24日 上午10:01:23
	 */
	@ResponseBody
	@RequestMapping(value = "/getMapById", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String getMapById(Long BuildingId) {
		int code = 0;
		String msg = null;
		try {
			List<HousesNew> result = housesNewService.getMapById(BuildingId);
			if (result != null) {
				msg = "查询成功";
				return FastJsonUtil.getResponseJson(code, msg, result);
			}
			code = -1;
			msg = "查询失败";
			return FastJsonUtil.getResponseJson(code, msg, null);
		} catch (Exception e) {
			code = -200;
			msg = "系统异常";
			logger.error(e.getMessage(), e);
			return FastJsonUtil.getResponseJson(code, msg, e);
		}
	}
	/**
	 * @Title: selectGoufing
	 * @description 查询经纪人数据加分成
	 * @param @param id
	 * @param @param session
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年6月20日
	 */
	@RequestMapping(value = "selectGoufing", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectGoufing(Long id,HttpSession session){
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			Map<String, Object> map=housesNewService.selectGoufing(id);
		 	if(map.size()!=0){
		 		return FastJsonUtil.getResponseJson(0, "查询成功", map);
		 	}else {
		 		return FastJsonUtil.getResponseJson(-1, "无数据", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return FastJsonUtil.getResponseJson(-200, "系统异常", e);
		}
	}
	/***
	 * 
	 *
	 * @Title: updateBroker
	 * @description 修改经纪人信息
	 * @param @param record
	 * @param @param session
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年6月20日
	 */
	@RequestMapping(value = "updateBroker", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String updateBroker(HousesNew record,HttpSession session){
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			int nun=housesNewService.updateByPrimaryKey(record);
		 	if(nun!=0){
		 		return FastJsonUtil.getResponseJson(0, "修改成功", null);
		 	}else {
		 		return FastJsonUtil.getResponseJson(-1, "修改失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return FastJsonUtil.getResponseJson(-200, "系统异常", e);
		}
	}
}
