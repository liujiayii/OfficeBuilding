package com.yqwl.service;

import java.math.BigInteger;
import java.util.List;

import com.yqwl.pojo.Photo;

/**
 *
 * @ClassName: PhotoService
 * @description 用一句话描述这个类的作用
 *
 * @author 姓名全拼
 * @createDate 2019年4月9日
 */
public interface PhotoService {
	
	public List<Photo> selectPhoto(long id);
}
