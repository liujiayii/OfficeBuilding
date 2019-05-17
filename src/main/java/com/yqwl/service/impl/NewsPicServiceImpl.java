package com.yqwl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yqwl.dao.NewsPicMapper;
import com.yqwl.pojo.NewsPic;
import com.yqwl.service.NewsPicService;

/**
 *
 * @ClassName: NewsPicServiceImpl
 * @description 用一句话描述这个类的作用
 *
 * @author 姓名全拼
 * @createDate 2019年4月23日
 */
@Service("newsPicService")
@Transactional(rollbackFor = { Exception.class })
public class NewsPicServiceImpl implements NewsPicService{

	@Resource
	private NewsPicMapper newsPicMapper;
	/* (non-Javadoc)
	 * @see com.yqwl.service.NewsPicService#insertSelective(com.yqwl.pojo.NewsPic)
	 */
	@Override
	public int insertSelective(NewsPic record) {
		// TODO Auto-generated method stub
		return newsPicMapper.insertSelective(record);
	}

}
