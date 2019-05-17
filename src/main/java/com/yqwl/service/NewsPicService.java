package com.yqwl.service;

import com.yqwl.pojo.NewsPic;

/**
 *
 * @ClassName: NewsPicService
 * @description 新闻图片service层
 *
 * @author linhongyu
 * @createDate 2019年4月23日
 */
public interface NewsPicService {
	/**
	 * @Title: insertSelective
	 * @description 新增一条数据
	 * @param @param record
	 * @param @return    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年4月29日
	 */
	int insertSelective(NewsPic record) throws Exception;

}
