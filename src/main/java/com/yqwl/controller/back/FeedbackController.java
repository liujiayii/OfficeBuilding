package com.yqwl.controller.back;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yqwl.Vo.BrokerVo;
import com.yqwl.Vo.FeedbackVo;
import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.pojo.Feedback;
import com.yqwl.service.FeedbackService;

/**
 *
 * @ClassName: FeedbackController
 * @description 控制层
 * @author linhongyu
 * @createDate 2019年6月12日
 */
@Controller
@RequestMapping("feedback")
public class FeedbackController {
	@Resource
	private FeedbackService feedbackService;
	
	/**
	 * @Title: insertSelective
	 * @description 新增一条带看反馈信息
	 * @param @param record
	 * @param @return    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年6月12日
	 */
	@RequestMapping(value = "insertSelective", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String insertSelective(Feedback record,HttpSession session){
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			record.setTime(new Date());
			int nun=feedbackService.insertSelective(record);
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
	 /**
     * @Title: selectListKey
     * @description 查询该房源的反馈信息
     * @param @param home_id
     * @param @return    
     * @return List<Feedback>    
     * @author linhongyu
     * @createDate 2019年6月12日
     */
	@RequestMapping(value = "selectListKey", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectListKey(Long hone_id,HttpSession session){
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			List<FeedbackVo> feedbacks=feedbackService.selectListKey(hone_id);
		 	if(feedbacks.size()>0){
		 		return FastJsonUtil.getResponseJson(0, "查询成功", feedbacks);
		 	}else {
		 		return FastJsonUtil.getResponseJson(-1, "无带看房源", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return FastJsonUtil.getResponseJson(-200, "系统异常", e);
		}
	}
}
