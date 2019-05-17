package com.yqwl.controller.back;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yqwl.Vo.BrokerVo;
import com.yqwl.Vo.LaunchVo;
import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.common.web.BaseController;
import com.yqwl.pojo.Launch;
import com.yqwl.service.LaunchService;

/**
 *
 * @ClassName: LaunchController
 * @description 后台管理投放房源controller层
 *
 * @author linhongyu
 * @createDate 2019年4月22日
 */
@Controller
@RequestMapping("launch")
public class LaunchControllers extends BaseController{
	@Resource
	private LaunchService launchService;
	
	/**
	 * @Title: deleteByPrimaryKey
	 * @description 通过id删除一条数据
	 * @param @param id
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月10日
	 */
	@RequestMapping(value = "deleteByPrimaryKey", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String deleteByPrimaryKey(long id,HttpSession session){
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			int num=launchService.deleteByPrimaryKey(id);
		 	if(num!=0){
		 		return FastJsonUtil.getResponseJson(0, "删除成功", null);
		 	}else {
		 		return FastJsonUtil.getResponseJson(-1, "删除失败，或已删除", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return dealException(-200, "系统异常", e);
		}
	}
	
	/**
	 * @Title: selectLaun
	 * @description 查询所有投放房源数据
	 * @param @param recordVo
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月21日
	 */
	@RequestMapping(value = "selectLaun", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectLaun(LaunchVo recordVo,Integer page,Integer limit,HttpSession session){
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			recordVo.setPage((page-1)*limit);
			recordVo.setLimit(limit);
			Map<String, Object> laun = launchService.selectLaun(recordVo);
			if(laun.size()>0){
				return FastJsonUtil.getResponseJson(0, "查询成功", laun);
			}else {
				return FastJsonUtil.getResponseJson(-1, "查询失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return dealException(-200, "系统异常", e);
		}
	}
	
	/**
	 * @Title: updateStatus
	 * @description 修改投放房源处理状态
	 * @param @param records
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月22日
	 */
	@RequestMapping(value = "updateStatus", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String updateStatus(Launch records,HttpSession session){
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			int num=launchService.updateStatus(records);
		 	if(num!=0){
		 		return FastJsonUtil.getResponseJson(0, "修改成功", null);
		 	}else {
		 		return FastJsonUtil.getResponseJson(-1, "修改失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return dealException(-200, "系统异常", e);
		}
	}
	/**
	 * @Title: updateLaunBroker
	 * @description 处理对投放房源的抢单处理
	 * @param @param broker_id
	 * @param @param id
	 * @param @param session
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月24日
	 */
	@RequestMapping(value = "updateLaunBroker", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String updateLaunBroker(Long broker_id,Long id,HttpSession session){
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			int num=launchService.updateLaunBroker(broker_id, id);
		 	if(num!=0){
		 		return FastJsonUtil.getResponseJson(0, "抢单成功", null);
		 	}else {
		 		return FastJsonUtil.getResponseJson(-1, "抢单失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return dealException(-200, "系统异常", e);
		}
	}
	/**
	 * @Title: selectMyLaun
	 * @description 查询经纪人名下对投放房源信息
	 * @param @param broker_id
	 * @param @param session
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月24日
	 */
	@RequestMapping(value = "selectMyLaun", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectMyLaun(Long broker_id,HttpSession session, Integer page, Integer limit){
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			Map<String, Object> laun=launchService.selectMyLaun(broker_id, page, limit);
			if(laun.size()>0){
				return FastJsonUtil.getResponseJson(0, "查询成功", laun);
			}else {
				return FastJsonUtil.getResponseJson(-1, "查询失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return dealException(-200, "系统异常", e);
		}
	}
	
	
}
