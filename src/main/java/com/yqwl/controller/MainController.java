package com.yqwl.controller;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yqwl.Vo.MainNewVo;
import com.yqwl.Vo.MainVo;
import com.yqwl.Vo.MapBuildingVo;
import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.pojo.Existing;
import com.yqwl.service.BuildingService;
import com.yqwl.service.HomePageRecommendedService;

@Controller
@Scope("prototype")
@RequestMapping("main")
public class MainController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private HomePageRecommendedService homePageRecommendedService;
	@Autowired
	private BuildingService buildingService;

	@ResponseBody
	@RequestMapping(value = "/homePageRecommended", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String homePageRecommended(Integer cityId, Integer type) {
		int code = 0;
		String msg = null;
		try {
			List<MainVo> result = homePageRecommendedService.homePageRecommended(cityId, type);
			if (result.size() != 0) {
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

	@ResponseBody
	@RequestMapping(value = "/homePageNew", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String homePageNew() {
		int code = 0;
		String msg = null;
		try {
			MainNewVo result = homePageRecommendedService.homePageNew();
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

	@ResponseBody
	@RequestMapping(value = "/homePageCity", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String homePageCity() {
		int code = 0;
		String msg = null;
		try {
			Existing result = homePageRecommendedService.homePageCity();
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

	@ResponseBody
	@RequestMapping(value = "/MapSelectBuilding", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String MapSelectBuilding(@RequestParam(value = "cityId") Integer cityId,
			@RequestParam(value = "regionId",required=false) Integer regionId, @RequestParam(value = "startSpace",required=false) Integer startSpace,
			@RequestParam(value = "endSpace",required=false) Integer endSpace, @RequestParam(value = "startMoney",required=false) BigDecimal startMoney,
			@RequestParam(value = "endMoney",required=false) BigDecimal endMoney,@RequestParam(value="fitment",required=false)Integer fitment) {
		int code = 0;
		String msg = null;
		try {
			List<MapBuildingVo> result = buildingService.MapSelectBuilding(cityId, regionId, startSpace, endSpace, startMoney,
					endMoney, fitment);
			if (result.size() != 0) {
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
