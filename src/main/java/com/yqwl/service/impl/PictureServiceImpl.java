package com.yqwl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yqwl.dao.PictureMapper;
import com.yqwl.pojo.Picture;
import com.yqwl.service.PictureService;

/**
 *
 * @ClassName: PictureServiceImpl
 * @description 用一句话描述这个类的作用
 *
 * @author 姓名全拼
 * @createDate 2019年4月10日
 */
@Service("pictureService")
@Transactional(rollbackFor = { Exception.class })
public class PictureServiceImpl implements PictureService{

	@Resource
	private PictureMapper pictureMapper;
	/**
	 * 查询图片信息
	 */
	@Override
	public List<Picture> selectPic(Long id) throws Exception{
		return pictureMapper.selectPic(id);
	}
	
	/** 后台插入房源图片 */
	@Override
	public int insertSelective(Picture record){
		
		return pictureMapper.insertSelective(record);
	}

}
