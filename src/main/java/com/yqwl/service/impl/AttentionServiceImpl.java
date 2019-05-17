package com.yqwl.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yqwl.Vo.AttentionVo;
import com.yqwl.dao.AttentionMapper;
import com.yqwl.pojo.Attention;
import com.yqwl.service.AttentionService;

/**
 *
 * @ClassName: AttentionServiceImpl
 * @description 用一句话描述这个类的作用
 *
 * @author linhongyu
 * @createDate 2019年4月11日
 */
@Service("attentionService")
@Transactional(rollbackFor = { Exception.class })
public class AttentionServiceImpl implements AttentionService{

	@Resource
	private AttentionMapper attentionMapper;
		
	/**
	 * @Title: insertSelective
	 * @description 添加收藏
	 * @param @param record
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月11日
	 */
	@Override
	public int insertSelective(Attention record) throws Exception{
		// TODO Auto-generated method stub
		return attentionMapper.insertSelective(record);
	}

	/**
	 * @Title: deleteByPrimaryKey
	 * @description 取消收藏
	 * @param @param id
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年4月11日
	 */
	@Override
	public int deleteByPrimaryKey(Long id) throws Exception{
		return attentionMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Attention selectFinfAll(Attention record) throws Exception{
		return attentionMapper.selectFinfAll(record);
	}

	@Override
	public List<AttentionVo> selectScend(AttentionVo records) throws Exception{
		return attentionMapper.selectScend(records);
	}

	@Override
	public Integer selectCount(AttentionVo records) throws Exception{
		return attentionMapper.selectCount(records);
	}

	@Override
	public List<AttentionVo> selectThird(AttentionVo records) throws Exception{
		return attentionMapper.selectThird(records);
	}

}
