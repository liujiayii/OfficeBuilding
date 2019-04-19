
package com.yqwl.controller;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yqwl.Vo.EntrustseeVo;
import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.common.utils.JYSMSUtil;
import com.yqwl.pojo.Entrustsee;
import com.yqwl.service.EntrustseeService;

/**
 *
 * @ClassName: EntrustseeController
 * @description 预约看房功能控制器
 *
 * @author 姓名全拼
 * @createDate 2019年4月10日
 */
@Controller
@RequestMapping("entrustsee")
public class EntrustseeController {
	@Resource
	private EntrustseeService entrustseeService;
	/**
	 * @Title: getmasge
	 * @description 发送短信
	 * @param @param phone_number
	 * @param @param session
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月11日
	 */
	@RequestMapping(value = "/getmasge")
	@ResponseBody
	public String getmasge(BigInteger phone_number,HttpSession session){
		String regularp = "^((13[0-9])|(14[0-9])|(19[0-9])|(16[0-9])|(15[^4,\\D])|(17[0-9])|(18[0-9]))(\\d{8})$";
		String phone = phone_number.toString();
		if (!phone.matches(regularp)) {
			return FastJsonUtil.getResponseJson(-1, "手机号码错误", null, null);
		}
			HashMap<String, String> map = new HashMap<>();
			map.put("time", "5");
			int a = (int) ((Math.random() * 9 + 1) * 100000);
			map.put("code", a + "");
			@SuppressWarnings("unused")
			boolean sendMessage = JYSMSUtil.sendMessage(phone, "3537", map);
		if(sendMessage=true){
			session.setAttribute("validate", a);
			return FastJsonUtil.getResponseJson(0, "发送成功", null, null);
		}else {
			return FastJsonUtil.getResponseJson(-2, "发送失败", null, null);
		}
	}
	/**
	 * @Title: insert
	 * @description 添加一条预约看房数据
	 * @param @param record
	 * @param @return    
	 * @return String    
	 * @author 姓名全拼
	 * @createDate 2019年4月10日
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String insert(Entrustsee record,Integer validate,HttpSession session){
		Integer a=(Integer) session.getAttribute("validate");
		if(!a.equals(validate)){
			return FastJsonUtil.getResponseJson(2, "验证码不正确，请从新发送", null);
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		Date now=new Date();
		String time = df.format(now);// new Date()为获取当前系统时间
		try {
			record.setPleasetime(new Timestamp(df.parse(time).getTime()));
			record.setSeetype(1);
			int nun=entrustseeService.insert(record);
		 	if(nun!=0){
		 		return FastJsonUtil.getResponseJson(0, "预约看房成功", null);
		 	}else {
		 		return FastJsonUtil.getResponseJson(-1, "添加失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return FastJsonUtil.getResponseJson(-200, "系统异常", e);
		}
	}
	/**
	 * @Title: updateType
	 * @description 修改预约看房状态
	 * @param @param seetype
	 * @param @return    
	 * @return String    
	 * @author 姓名全拼
	 * @createDate 2019年4月10日
	 */
	@RequestMapping(value = "updateType", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String updateType(Entrustsee record){
		try {
			int num=entrustseeService.updateType(record);
		 	if(num!=0){
		 		return FastJsonUtil.getResponseJson(0, "修改成功", null);
		 	}else {
		 		return FastJsonUtil.getResponseJson(-1, "修改失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return FastJsonUtil.getResponseJson(-200, "系统异常", e);
		}
	}
	/**
	 * @Title: selectAllEN
	 * @description 后台查询所有预约看房
	 * @param @param record
	 * @param @param page
	 * @param @param limit
	 * @param @return    
	 * @return String    
	 * @author 姓名全拼
	 * @createDate 2019年4月10日
	 */
	@RequestMapping(value = "selectAllEN", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectAllEN(EntrustseeVo record,Integer page,Integer limit){
		try {
			record.setPage((page-1)*limit);
			record.setLimit(limit);
			List<EntrustseeVo> ent=entrustseeService.selectAllEN(record);
		 	if(ent.size()>0){
		 		return FastJsonUtil.getResponseJson(0, "查询成功", null);
		 	}else {
		 		return FastJsonUtil.getResponseJson(-1, "查询失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return FastJsonUtil.getResponseJson(-200, "系统异常", e);
		}
	}
}
