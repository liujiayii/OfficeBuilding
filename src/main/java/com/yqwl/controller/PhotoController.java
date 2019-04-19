
package com.yqwl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yqwl.Vo.HousesNewVo;
import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.pojo.Photo;
import com.yqwl.service.PhotoService;

/**
 *
 * @ClassName: PhotoController
 * @description 用一句话描述这个类的作用
 *
 * @author 姓名全拼
 * @createDate 2019年4月10日
 */
@Controller
@RequestMapping("photo")
public class PhotoController {

	@Resource
	private PhotoService photoService;
	
	@RequestMapping(value = "selectPhoto", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectPhoto(long id){
		try {
			List<Photo> photos= photoService.selectPhoto(id);
			return FastJsonUtil.getResponseJson(1, "查询成功", photos);
		} catch (Exception e) {
			e.printStackTrace();
			return FastJsonUtil.getResponseJson(1, "系统异常", e);
		}
	}
}
