package com.yqwl.controller.back;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.yqwl.Vo.BrokerVo;
import com.yqwl.Vo.JournalismVo;
import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.common.utils.UpdateFiles;
import com.yqwl.common.web.BaseController;
import com.yqwl.pojo.Journalism;
import com.yqwl.pojo.NewsPic;
import com.yqwl.service.JournalismService;
import com.yqwl.service.NewsPicService;
import net.sf.json.JSONObject;
import org.springframework.web.multipart.MultipartHttpServletRequest;
/**
 *
 * @ClassName: JournalismControllers
 * @description 新闻后台功能类
 * @author linhongyu
 * @createDate 2019年4月22日
 */
@Controller
@RequestMapping("journalism")
public class JournalismControllers extends BaseController{

	@Resource
	private JournalismService journalismService;
	@Resource
	private NewsPicService newsPicService;

	/** 上传图片 */
	@RequestMapping(value = "uploading", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String uploading(HttpServletRequest req) {
		try {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req;
			//MultipartFile files = multipartRequest.getFile("file");
			List<MultipartFile> files = multipartRequest.getFiles("file");
			List<String> result = new LinkedList<>();
			for (MultipartFile multipartFile : files) {
				Map<String, String> map;
				map = UpdateFiles.update(multipartFile);
				String urls = map.get("Path");
				result.add(urls);
			}
			JSONObject jsonObject = new JSONObject();
			if (result.size()!=0) {
				jsonObject.put("errno", 0);
				jsonObject.put("data", result);
				return jsonObject.toString();
			}
			jsonObject.put("errno", 1);
			jsonObject.put("data", null);
			return jsonObject.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return dealException(-200, "系统异常", e);
		}
	}
	/**
	 * @Title: selectAllAome
	 * @description 后台查询新闻信息并分页
	 * @param @param records
	 * @param @param page
	 * @param @param limit
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月23日
	 */
	@RequestMapping(value = "selectAllAome", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectAllAome(JournalismVo records,Integer page,Integer limit,HttpSession session){
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			records.setPage((page-1)*limit);
			records.setLimit(limit);
			List<JournalismVo> Journa = journalismService.selectAllAome(records);
			Integer count = journalismService.selectCountJour(records);
			Map<String ,Object > map=new HashMap<String ,Object >();
			map.put("date", Journa);
			map.put("count", count);
			if(Journa.size()>0){
				return FastJsonUtil.getResponseJson(0, "查询成功", map);
			}else {
				return FastJsonUtil.getResponseJson(-1, "查询失败", null);
				}
		} catch (Exception e) {
			e.printStackTrace();
			return dealException(-200, "系统异常", e);
		}
	}
	
	/**
	 * @Title: insertSelective
	 * @description 新增一条新闻
	 * @param @param record
	 * @param @param req
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月23日
	 */
	@RequestMapping(value = "insertSelective", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String insertSelective(Journalism record,String[] result ,HttpServletRequest req,HttpSession session){
		NewsPic newsPic=new NewsPic();
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			record.setTime(new Date());
			int nun=journalismService.insertSelective(record); //添加新闻内容
			long id=record.getId();
			if(result!=null){
				for (String string : result) {
					newsPic.setJournalism_id(id);
					newsPic.setPicture(string);
					newsPicService.insertSelective(newsPic);  //添加新闻图片
				}	
			}
			if(nun!=0){
		 		return FastJsonUtil.getResponseJson(0, "添加成功", null);
		 	}else {
		 		return FastJsonUtil.getResponseJson(-1, "添加失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return dealException(-200, "系统异常", e);
		}
	}
	/**
	 * @Title: updateByPrimaryKeySelective
	 * @description 修改新闻内容
	 * @param @param record
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月25日
	 */
	@RequestMapping(value = "updateByPrimaryKeySelective", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String updateByPrimaryKeySelective(Journalism record,HttpServletRequest req,HttpSession session){
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			int num=journalismService.updateByPrimaryKeySelective(record);
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
     * @Title: deleteByPrimaryKey
     * @description 删除一条新闻资讯
     * @param @param id
     * @param @return    
     * @return int    
     * @author linhongyu
     * @createDate 2019年4月30日
     */
	@RequestMapping(value = "deleteByPrimaryKey", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String deleteByPrimaryKey(Long id,HttpSession session){
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			int num=journalismService.deleteByPrimaryKey(id);
			if(num!=0){
				return FastJsonUtil.getResponseJson(0, "删除成功", null);	
			}else {
				return FastJsonUtil.getResponseJson(-1, "删除失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return dealException(-200, "系统异常", e);
		}
	}
}
