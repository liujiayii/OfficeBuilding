package com.yqwl.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

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
	public int insertSelective(Attention record) {
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
	public int deleteByPrimaryKey(Long id) {
		return attentionMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Attention selectFinfAll(Attention record) {
		return attentionMapper.selectFinfAll(record);
	}

	@Override
	public List<AttentionVo> selectScend(AttentionVo records) {
		return attentionMapper.selectScend(records);
	}

	@Override
	public Integer selectCount(AttentionVo records) {
		return attentionMapper.selectCount(records);
	}

	@Override
	public List<AttentionVo> selectThird(AttentionVo records) {
		return attentionMapper.selectThird(records);
	}

}
