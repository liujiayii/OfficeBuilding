package com.yqwl.service;

import java.util.List;

import com.yqwl.pojo.Picture;

/**
 *
 * @ClassName: PictureService
 * @description 用一句话描述这个类的作用
 *
 * @author 姓名全拼
 * @createDate 2019年4月10日
 */
public interface PictureService {
	public List<Picture> selectPic(long id);

}
