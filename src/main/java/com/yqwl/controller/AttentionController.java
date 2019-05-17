package com.yqwl.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yqwl.Vo.AttentionVo;
import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.pojo.Attention;
import com.yqwl.service.AttentionService;

/**
 *
 * @ClassName: AttentionController
 * @description 收藏表控制层
 *
 * @author linhongyu
 * @createDate 2019年4月11日
 */
@Controller
@RequestMapping("attention")
public class AttentionController {

	@Resource
	private AttentionService attentionService;
	
	/**
	 * @Title: insertSelective
	 * @description 添加收藏
	 * @param @param record
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @throws Exception 
	 * @createDate 2019年4月11日
	 */
	@RequestMapping(value = "insertSelective", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String insertSelective(Attention record) throws Exception{
		Attention nemu=attentionService.selectFinfAll(record);
		if(nemu!=null){
			return FastJsonUtil.getResponseJson(2, "收藏成功", null);
		}
		try {
			record.setAttention_time(new Date());
			int insertSelective = attentionService.insertSelective(record);
			if (insertSelective != 0) {
				return FastJsonUtil.getResponseJson(0, "收藏成功", null);
			}
			return FastJsonUtil.getResponseJson(-1, "收藏失败", null);
		} catch (Exception e) {
			return FastJsonUtil.getResponseJson(-200, "系统异常", e);
		}
	}
	
	/**
	 * @Title: deleteByPrimaryKey
	 * @description 取消收藏
	 * @param @param id
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月11日
	 */
	@RequestMapping(value = "deleteByPrimaryKey", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String deleteByPrimaryKey(long id){
		try {
			int num=attentionService.deleteByPrimaryKey(id);
		 	 if(num!=0){
		 		return FastJsonUtil.getResponseJson(0, "取消收藏", null);
		 	}else {
		 		return FastJsonUtil.getResponseJson(-1, "取消失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return FastJsonUtil.getResponseJson(-200, "系统异常", e);
		}
	}
	/**
	 * @Title: selectScend
	 * @description 查询收藏商厦信息和数量
	 * @param @param records
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月18日
	 */
	@RequestMapping(value = "selectScend", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectScend(AttentionVo records){
		try {
			List<AttentionVo> att= attentionService.selectScend(records);
			Integer count=attentionService.selectCount(records);
			Map<String ,Object > map=new HashMap<String ,Object >();
			map.put("data", att);
		 	map.put("count", count);
		 	 if(att.size()>0){
		 		return FastJsonUtil.getResponseJson(0, "查询成功", map);
		 	}else {
		 		return FastJsonUtil.getResponseJson(-1, "查询失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return FastJsonUtil.getResponseJson(-200, "系统异常", e);
		}
	}
	
	/**
	 * @Title: selectThird
	 * @description 查询收藏房源信息和数量
	 * @param @param records
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月30日
	 */
	@RequestMapping(value = "selectThird", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectThird(AttentionVo records){
		try {
			List<AttentionVo> att= attentionService.selectThird(records);
			Integer count=attentionService.selectCount(records);
			Map<String ,Object > map=new HashMap<String ,Object >();
			map.put("data", att);
		 	map.put("count", count);
		 	 if(att.size()>0){
		 		return FastJsonUtil.getResponseJson(0, "查询成功", map);
		 	}else {
		 		return FastJsonUtil.getResponseJson(-1, "查询失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return FastJsonUtil.getResponseJson(-200, "系统异常", e);
		}
	}
}
