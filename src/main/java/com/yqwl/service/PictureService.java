package com.yqwl.service;

import java.util.List;

import com.yqwl.pojo.Picture;

/**
 *
 * @ClassName: PictureService
 * @description 图片表service接口
 *
 * @author linhongyu
 * @createDate 2019年4月10日
 */
public interface PictureService {
	/**
	 * @Title: selectPic
	 * @description 通过条件查询图片
	 * @param @param id
	 * @param @return
	 * @param @throws Exception    
	 * @return List<Picture>    
	 * @author linhongyu
	 * @createDate 2019年4月29日
	 */
	public List<Picture> selectPic(Long id) throws Exception;
	
	/**
	 * @Title: insertSelective
	 * @description 后台插入房源图片
	 * @param @param picture
	 * @param @return
	 * @param @throws Exception    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年4月29日
	 */
	public int insertSelective(Picture picture) throws Exception;

}
