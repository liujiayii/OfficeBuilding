package com.yqwl.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.pojo.Delegation;
import com.yqwl.service.DelegationService;

/**
 *
 * @ClassName: DelegationController
 * @description 委托表controller前台控制层
 *
 * @author linhongyu
 * @createDate 2019年4月10日
 */
@Controller
@RequestMapping("delegation")
public class DelegationController {
	
	@Resource
	private DelegationService delegationService;
	/**
	 * @Title: insert
	 * @description 添加一条委托数据
	 * @param @param record
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月10日
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String insert(Delegation record){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		Date now=new Date();
		String time = df.format(now);// new Date()为获取当前系统时间
		try {
			record.setMake_time(new Timestamp(df.parse(time).getTime()));
			record.setMake_type(1);
			int nun=delegationService.insertSelective(record);
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
