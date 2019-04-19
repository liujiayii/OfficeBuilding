
package com.yqwl.service.impl;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.yqwl.dao.PhotoMapper;
import com.yqwl.pojo.Photo;
import com.yqwl.service.PhotoService;

/**
 *
 * @ClassName: PhotoServiceImpl
 * @description 用一句话描述这个类的作用
 *
 * @author 姓名全拼
 * @createDate 2019年4月9日
 */
@Service("photoService")
public class PhotoServiceImpl implements PhotoService{

	@Resource
	private PhotoMapper photoMapper;
	
	@Override
	public List<Photo> selectPhoto(long id) {
		return photoMapper.selectPhoto(id);
	}

}
