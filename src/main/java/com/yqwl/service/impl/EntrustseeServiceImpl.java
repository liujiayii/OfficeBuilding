package com.yqwl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yqwl.Vo.EntrustseeVo;
import com.yqwl.dao.EntrustseeMapper;
import com.yqwl.pojo.Entrustsee;
import com.yqwl.service.EntrustseeService;

/**
 *
 * @ClassName: EntrustseeServiceImpl
 * @description 用一句话描述这个类的作用
 *
 * @author 姓名全拼
 * @createDate 2019年4月10日
 */
@Service("entrustseeService")
public class EntrustseeServiceImpl implements EntrustseeService{
	@Resource
	private EntrustseeMapper entrustseeMapper;
	
	/**
	 * @Title: insert
	 * @description 添加一条预约看房数据
	 * @param @param record
	 * @param @return    
	 * @return String    
	 * @author 姓名全拼
	 * @createDate 2019年4月10日
	 */
	@Override
	public int insert(Entrustsee record) {
		// TODO Auto-generated method stub
		return entrustseeMapper.insert(record);
	}
	/**
	 * @Title: updateType
	 * @description 修改预约看房状态
	 * @param @param seetype
	 * @param @return    
	 * @return String    
	 * @author 姓名全拼
	 * @createDate 2019年4月10日
	 */
	@Override
	public int updateType(Entrustsee record) {
		// TODO Auto-generated method stub
		return entrustseeMapper.updateType(record);
	}
	/**
	 * @Title: selectAllEN
	 * @description 后台查询所有预约看房
	 * @param @param record
	 * @param @param page
	 * @param @param limit
	 * @param @return    
	 * @return String    
	 * @author 姓名全拼
	 * @createDate 2019年4月10日
	 */
	@Override
	public List<EntrustseeVo> selectAllEN(EntrustseeVo record) {
		// TODO Auto-generated method stub
		return entrustseeMapper.selectAllEN(record);
	}

}
