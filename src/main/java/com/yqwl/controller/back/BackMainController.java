package com.yqwl.controller.back;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yqwl.Vo.MainVo;
import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.common.web.BaseController;
import com.yqwl.pojo.HomePageRecommended;
import com.yqwl.service.HomePageRecommendedService;

@Controller
@Scope("prototype")
@RequestMapping("BackMain")
public class BackMainController extends BaseController {
	@Autowired
	private HomePageRecommendedService homePageRecommendedService;
	
	/**
	 * 
	 * @Title: insert
	 * @description 添加首页推荐
	 * @param homePageRecommended
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年5月7日 上午9:13:01
	 */
	@ResponseBody
	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String insert(HomePageRecommended homePageRecommended) {
		int code = 0;
		String msg = null;
		try {
			Integer result = homePageRecommendedService.insert(homePageRecommended);
			if (result != 0) {
				msg = "新增成功";
				return FastJsonUtil.getResponseJson(code, msg, result);
			}
			code = -1;
			msg = "新增失败";
			return FastJsonUtil.getResponseJson(code, msg, null);
		} catch (Exception e) {
			code = -200;
			msg = "系统异常";
			return dealException(-200, "系统异常", e);
		}
	}
	/**
	 * 
	 * @Title: delete
	 * @description 删除首页推荐
	 * @param id
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年5月7日 上午9:13:10
	 */
	@ResponseBody
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String delete(Long id) {
		int code = 0;
		String msg = null;
		try {
			Integer result = homePageRecommendedService.delete(id);
			if (result != 0) {
				msg = "删除成功";
				return FastJsonUtil.getResponseJson(code, msg, result);
			}
			code = -1;
			msg = "删除失败";
			return FastJsonUtil.getResponseJson(code, msg, null);
		} catch (Exception e) {
			code = -200;
			msg = "系统异常";
			return dealException(-200, "系统异常", e);
		}
	}
	
}
