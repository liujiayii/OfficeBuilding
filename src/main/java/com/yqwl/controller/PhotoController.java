package com.yqwl.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.pojo.Photo;
import com.yqwl.service.PhotoService;

/**
 *
 * @ClassName: PhotoController
 * @description 前台显示图片的controller层
 *
 * @author linhongyu
 * @createDate 2019年4月10日
 */
@Controller
@RequestMapping("photo")
public class PhotoController {

	@Resource
	private PhotoService photoService;
	/**
	 * @Title: selectPhoto
	 * @description 查询商厦图片
	 * @param @param id
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月23日
	 */
	@RequestMapping(value = "selectPhoto", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectPhoto(Long buildingId){
		try {
			List<Photo> photos= photoService.listByBuildingId(buildingId);
			if(photos.size()>0){
				return FastJsonUtil.getResponseJson(0, "查询成功", photos);
			}else {
				return FastJsonUtil.getResponseJson(-1, "查询成功", photos);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return FastJsonUtil.getResponseJson(-200, "系统异常", e);
		}
	}
	
}
