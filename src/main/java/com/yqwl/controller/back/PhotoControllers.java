package com.yqwl.controller.back;

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

import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.common.utils.UpdateFiles;
import com.yqwl.common.web.BaseController;
import com.yqwl.pojo.Photo;
import com.yqwl.service.PhotoService;

/**
 *
 * @ClassName: PhotoControllers
 * @description 商厦图片后台controller层
 *
 * @author linhongyu
 * @createDate 2019年4月23日
 */
@Controller
@RequestMapping("photo")
public class PhotoControllers extends BaseController{

	@Resource
	private PhotoService photoService;
	/**
	 * @Title: insertSelective
	 * @description 单独添加商厦图片
	 * @param @param record
	 * @param @param req
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月23日
	 */
		@RequestMapping(value = "insertSelective", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
		@ResponseBody
		public String insertSelective(Photo record,HttpServletRequest req){
			try {
				MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req;
				List<MultipartFile> filess = multipartRequest.getFiles("pics");
				for (MultipartFile multipartFile : filess) {
					Map<String, String> mapes;
					mapes = UpdateFiles.update(multipartFile);
					String urlss = mapes.get("Path");
					record.setPhoto(urlss);
					int num=photoService.insertSelective(record);
					if(num!=0){
				 		return FastJsonUtil.getResponseJson(0, "添加成功", null);
				 	}else {
				 		return FastJsonUtil.getResponseJson(-1, "添加失败", null);
					}
				}	
			} catch (Exception e) {
				e.printStackTrace();
				return dealException(-200, "系统异常", e);
			}
			return null;
		}
		
		/**
		 * @Title: deleteloading
		 * @description 删除图片
		 * @param @param url
		 * @param @return    
		 * @return String    
		 * @author linhongyu
		 * @createDate 2019年4月25日
		 */
		@RequestMapping(value = "deleteloading", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
		@ResponseBody
		public String deleteloading(Long id) {
			try {
			Photo photo=photoService.selectByPrimaryKey(id);
			String urls=photo.getPhoto();
			UpdateFiles.deleatFile(urls);
			int num=photoService.deleteByPrimaryKey(id);
					if (num != 0) {
						return FastJsonUtil.getResponseJson(0, "删除成功", urls);
					} else {
						return FastJsonUtil.getResponseJson(-1, "删除失败", null);
					}
			} catch (Exception e) {
				e.printStackTrace();
				return dealException(-200, "系统异常", e);
			}
		}
}
