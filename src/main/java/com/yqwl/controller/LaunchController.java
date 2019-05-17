package com.yqwl.controller;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.pojo.Launch;
import com.yqwl.service.LaunchService;

/**
 *
 * @ClassName: LaunchController
 * @description 前台添加投放房源controller层
 *
 * @author linhongyu
 * @createDate 2019年4月10日
 */
@Controller
@RequestMapping("launch")
public class LaunchController {

	@Resource
	private LaunchService launchService;
	
	/**
	 * @Title: insert
	 * @description 添加一条投放房源信息
	 * @param @param record
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月10日
	 */
	@RequestMapping(value = "insertFirst", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String insertFirst(Launch record){
		try {
			record.setTimes(new Date());
			record.setStatus(1);
			int nun=launchService.insertSelective(record);
			
		 	if(nun!=0){
		 		return FastJsonUtil.getResponseJson(0, "添加成功", null);
		 	}else {
		 		return FastJsonUtil.getResponseJson(-1, "添加失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return FastJsonUtil.getResponseJson(-200, "系统异常", e);
		}
	}
}
