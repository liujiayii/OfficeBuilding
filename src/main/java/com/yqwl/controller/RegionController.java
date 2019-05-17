package com.yqwl.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.pojo.Region;
import com.yqwl.service.RegionService;

@Controller
@Scope("prototype")
@RequestMapping("region")
public class RegionController {
	@Autowired
	private RegionService regionservece;
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	/**
	 * 
	 * @Title: listRegion
	 * @description 地区查询
	 * @param pid
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年4月29日 上午9:16:46
	 */
	@ResponseBody
	@RequestMapping(value = "listRegion", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String listRegion(String pid){
		int code = 0;
		String msg = null;
		try {
			List<Region> result = regionservece.listRegionByPid(pid);
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
	@RequestMapping(value = "getRegionByid", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String getRegionByid(Integer id){
		int code = 0;
		String msg = null;
		try {
			Region result = regionservece.getRegionByid(id);
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
