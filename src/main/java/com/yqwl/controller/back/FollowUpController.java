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
import com.yqwl.Vo.FollowUpVo;
import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.dao.InformMapper;
import com.yqwl.pojo.FollowUp;
import com.yqwl.pojo.Inform;
import com.yqwl.service.FollowUpService;
/**
 *
 * @ClassName: FollowUpController
 * @description 经纪人跟进表的
 * @author linhongyu
 * @createDate 2019年6月9日
 */
@Controller
@RequestMapping("followUp")
public class FollowUpController {

	@Resource
	private FollowUpService followUpService;
	@Resource
	private InformMapper informMapper;
	/**
	 * @Title: insertSelective
	 * @description 点击电话时添加一条跟进数据
	 * @param @param record
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年6月9日
	 */
	@RequestMapping(value = "insertSelective", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String insertSelective(FollowUp record,HttpSession session){
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			record.setRemind_time(new Date());
			int nun=followUpService.insertSelective(record);
			Long id=record.getId();
		 	if(nun!=0){
		 		return FastJsonUtil.getResponseJson(0, "添加成功", id);
		 	}else {
		 		return FastJsonUtil.getResponseJson(-1, "添加失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return FastJsonUtil.getResponseJson(-200, "系统异常", e);
		}
	}
	/**
	 * 
	 *
	 * @Title: selectFollow
	 * @description 查询是否有未跟进房源
	 * @param @param broker_id
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年6月10日
	 */
	@RequestMapping(value = "selectFollow", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectFollow(Long broker_id,HttpSession session){
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			FollowUp followUp=followUpService.selectFollow(broker_id);
		 	if(followUp==null){
		 		return FastJsonUtil.getResponseJson(0, "可以查看手机号", null);
		 	}else {
		 		return FastJsonUtil.getResponseJson(-1, "添加上次更新内容，才能查看电话。。。", followUp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return FastJsonUtil.getResponseJson(-200, "系统异常", e);
		}
	}
	
	/**
	 * @Title: updateByPrimaryKeySelective
	 * @description 修改跟进状态和是否通知撤单(添加一条数据)
	 * @param @param record
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年6月10日
	 */
	@RequestMapping(value = "updateByPrimaryKeySelective", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String updateByPrimaryKeySelective(FollowUp record,HttpSession session){
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			record.setType(1);
			record.setRemind_time(new Date());
			int num=followUpService.updateByPrimaryKeySelective(record);
		 	if(num!=0){
		 		if(record.getRetreat()!=1){
		 			FollowUp followUp=followUpService.selectByPrimaryKey(record.getId());
		 			Inform inform=new Inform();
		 			inform.setFollow_id(followUp.getId());
		 			inform.setHome_id(followUp.getHome_id());
		 			inform.setBroker_id(followUp.getBrokers_id());
		 			informMapper.insertSelective(inform);
		 		}
		 		return FastJsonUtil.getResponseJson(0, "跟进成功", null);
		 	}else {
		 		return FastJsonUtil.getResponseJson(-1, "跟进失败，请从新录入", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return FastJsonUtil.getResponseJson(-200, "系统异常", e);
		}
	}
	/**
	 * @Title: selectHomeId
	 * @description 查询该房源的跟进信息
	 * @param @param home_id
	 * @param @param session
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年6月11日
	 */
	@RequestMapping(value = "selectHomeId", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectHomeId(Long home_id,HttpSession session){
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			List<FollowUpVo> followUp=followUpService.selectHomeId(home_id);
		 	if(followUp.size()>0){
		 		return FastJsonUtil.getResponseJson(0, "查询成功", followUp);
		 	}else {
		 		return FastJsonUtil.getResponseJson(-1, "查询失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return FastJsonUtil.getResponseJson(-200, "系统异常", e);
		}
	}
	/**
	 * @Title: selectThis
	 * @description 通过id查询跟进信息
	 * @param @param id
	 * @param @param session
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年6月26日
	 */
	@RequestMapping(value = "selectThis", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectThis(Long id,HttpSession session){
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			FollowUp followUp=followUpService.selectByPrimaryKey(id);
		 	if(followUp!=null){
		 		return FastJsonUtil.getResponseJson(0, "查询成功", followUp);
		 	}else {
		 		return FastJsonUtil.getResponseJson(-1, "查询失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return FastJsonUtil.getResponseJson(-200, "系统异常", e);
		}
	}
}
