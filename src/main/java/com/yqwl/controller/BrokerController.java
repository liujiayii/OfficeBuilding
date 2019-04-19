package com.yqwl.controller;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.pojo.Broker;
import com.yqwl.service.BrokerService;

/**
 *
 * @ClassName: BrokerController
 * @description 经纪人控制层
 *
 * @author linhongyu
 * @createDate 2019年4月11日
 */
@Controller
@RequestMapping("broker")
public class BrokerController {

	@Resource
	private BrokerService brokerService;
	/**
	 * @Title: selectByPrimaryKey
	 * @description 通过id查询经纪人基本信息
	 * @param @param id
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月11日
	 */
	@RequestMapping(value = "selectByPrimaryKey", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectByPrimaryKey(long id){
		try {
			Broker broker=brokerService.selectByPrimaryKey(id);
		 	if(broker!=null){
		 		return FastJsonUtil.getResponseJson(0, "查询成功", broker);
		 	}else {
		 		return FastJsonUtil.getResponseJson(1, "查询失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return FastJsonUtil.getResponseJson(-200, "系统异常", e);
		}
	 	
	}
}
