package com.yqwl.controller.back;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yqwl.Vo.InformVo;
import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.pojo.Inform;
import com.yqwl.service.InformService;

/**
 *
 * @ClassName: InformController
 * @description 控制层
 * @author linhongyu
 * @createDate 2019年6月10日
 */
@Controller
@RequestMapping("inform")
public class InformController {

	@Resource
	private InformService informService;
	
	/**
	 * 
	 *
	 * @Title: selectByInform
	 * @description 登录时查询是否有通知撤单消息
	 * @param @param broker_id
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年6月10日
	 */
	@RequestMapping(value = "selectByInform", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectByInform(Long broker_id){
		try {

			List<InformVo> inform=informService.selectByInform(broker_id);
		 	if(inform.size()!=0){
		 		return FastJsonUtil.getResponseJson(0, "撤单通知", inform);

		 	}else {
		 		return FastJsonUtil.getResponseJson(-1, "无撤单通知", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return FastJsonUtil.getResponseJson(-200, "系统异常", e);
		}
	}
	
}
