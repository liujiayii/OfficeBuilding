package com.yqwl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.yqwl.Vo.BuildingVo;
import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.common.utils.Pager;
import com.yqwl.pojo.Region;
import com.yqwl.service.BuildingService;

@Controller
@Scope("prototype")
@RequestMapping("building")
public class BuildingController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private BuildingService buildingService;

	/**
	 * 
	 * @Title: listBuildingByCondition
	 * @description 楼盘条件搜索 (分页)
	 * @param pager
	 *            filter=cityId=130000&regionId=130104&startSpace=300&endSpace=
	 *            700&startMoney=10.00&endMoney=20.00&fitment=1 pageSize = 10;
	 *            默认每页的行数 pageNum = 1; 默认当前页
	 * @return String
	 * @author likai
	 * @createDate 2019年4月10日 下午3:22:03
	 */
	@ResponseBody
	@RequestMapping(value = "/listBuildingByCondition", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	public String listBuildingByCondition(Pager pager) {
		int code = 0;
		String msg = null;
		try {
			PageInfo<BuildingVo> result = buildingService.listBuildingByCondition(pager);
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
	 * @Title: listByBuilding
	 * @description 搜索框搜索楼盘
	 * @param pager
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年4月13日 下午1:47:40
	 */
	@ResponseBody
	@RequestMapping(value = "/listByBuilding", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String listByBuilding(Pager pager) {
		int code = 0;
		String msg = null;
		try {
			PageInfo<Region> result = buildingService.listByBuilding(pager);
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
	 * @Title: listByHouseCount
	 * @description  一个城市有多少房源
	 * @param cityId
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年4月13日 下午1:48:44
	 */
	@ResponseBody
	@RequestMapping(value = "/listByHouseCount", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String listByHouseCount(Integer cityId) {
		int code = 0;
		String msg = null;
		try {
			Integer result = buildingService.listByHouseCount(cityId);
			msg = "查询成功";
			return FastJsonUtil.getResponseJson(code, msg, result);
		} catch (Exception e) {
			code = -200;
			msg = "系统异常";
			logger.error(e.getMessage(), e);
			return FastJsonUtil.getResponseJson(code, msg, e);
		}
	}
	

	/**
	 * 
	 * @Title: getBuildingById
	 * @description 楼盘详情
	 * @param BuildingId
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年4月15日 上午10:15:25
	 */
	@ResponseBody
	@RequestMapping(value = "/getBuildingById", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String getBuildingById(Long BuildingId) {
		int code = 0;
		String msg = null;
		try {
			BuildingVo result = buildingService.getBuildingById(BuildingId);
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

}
