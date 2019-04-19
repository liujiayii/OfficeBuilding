package com.yqwl.controller;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.yqwl.Vo.JournalismVo;
import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.common.utils.UpdateFiles;
import com.yqwl.pojo.Journalism;
import com.yqwl.service.JournalismService;

/**
 *
 * @ClassName: JournalismController
 * @description 用一句话描述这个类的作用
 *
 * @author 姓名全拼
 * @createDate 2019年4月12日
 */
@Controller
@RequestMapping("journalism")
public class JournalismController {

	@Resource
	private JournalismService journalismService;

	/**
	 * @Title: selectJour
	 * @description 查询新闻资讯
	 * @param @param  records
	 * @param @param page
	 * @param @param limit
	 * @param @return
	 * @return String
	 * @author linhongyu
	 * @createDate 2019年4月12日
	 */
	@RequestMapping(value = "selectJour", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectJour(JournalismVo records, Integer page, Integer limit) {
		try {
			records.setPage((page - 1) * limit);
			records.setLimit(limit);
			List<JournalismVo> selectJour = journalismService.selectJour(records);
			if (selectJour.size() > 0) {
				return FastJsonUtil.getResponseJson(0, "查询成功", selectJour);
			} else {
				return FastJsonUtil.getResponseJson(-1, "查询失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return FastJsonUtil.getResponseJson(-200, "系统异常", e);
		}
	}

	/** 上传图片 */
	@RequestMapping(value = "uploading", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String uploading(HttpServletRequest req) {
		try {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req;
			List<MultipartFile> files = multipartRequest.getFiles("pic");
			for (MultipartFile multipartFile : files) {
				Map<String, String> map;
				map = UpdateFiles.update(multipartFile);
				String urls = map.get("Path");
				if (urls != null) {
					return FastJsonUtil.getResponseJson(0, "添加成功", urls);
				} else {
					return FastJsonUtil.getResponseJson(-1, "添加失败", null);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return FastJsonUtil.getResponseJson(-200, "系统异常", e);
		}
		return null;
	}
	
	/**
	 * @Title: selectByPrimaryKey
	 * @description 通过id查询新闻资讯详情
	 * @param @param id
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月12日
	 */
	@RequestMapping(value = "selectByPrimaryKey", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectByPrimaryKey(Long id) {
		//增加浏览量
		Journalism selectByPrimaryKey = journalismService.selectByPrimaryKey(id);
		Long a=selectByPrimaryKey.getPage_view();
		long b=a+1; //加一
		Journalism record=new Journalism();
		record.setPage_view(b);
		journalismService.updateByPrimaryKeySelective(record);
		try {
			Journalism Primary = journalismService.selectByPrimaryKey(id);
			if (Primary!= null) {
				return FastJsonUtil.getResponseJson(0, "查询成功", Primary);
			} else {
				return FastJsonUtil.getResponseJson(-1, "查询失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return FastJsonUtil.getResponseJson(-200, "系统异常", e);
		}
	}
	
	/**
     * @description 查询上一篇 新闻
     * @author linhongyu
     * @createDate 2019年4月14日
     */
	@RequestMapping(value = "selectPrevious", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectPrevious(Journalism record) {
		try {
			Journalism one=journalismService.selectPrevious(record);
			if (one!=null) {
				return FastJsonUtil.getResponseJson(0, "查询成功", one);
			} else {
				return FastJsonUtil.getResponseJson(-1, "查询失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return FastJsonUtil.getResponseJson(-200, "系统异常", e);
		}
	}
	/**
     * @description 查询下一篇 新闻
     * @author linhongyu
     * @createDate 2019年4月14日
     */
	@RequestMapping(value = "selectNext", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectNext(Journalism record){
		try {
			Journalism two=journalismService.selectNext(record);
			if (two!=null) {
				return FastJsonUtil.getResponseJson(0, "查询成功", two);
			} else {
				return FastJsonUtil.getResponseJson(-1, "查询失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return FastJsonUtil.getResponseJson(-200, "系统异常", e);
		}
	}
}
