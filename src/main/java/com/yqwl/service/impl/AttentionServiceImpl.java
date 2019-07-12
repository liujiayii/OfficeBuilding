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

	/**
	 * @Title: selectInfor
	 * @description 判断该该房源或商厦是否被收藏
	 * @param @param user_phone
	 * @param @param houses_new_id
	 * @param @param type
	 * @param @return
	 * @param @throws Exception    
	 * @return Attention    
	 * @author linhongyu
	 * @createDate 2019年7月11日
	 */
	@Override
	public Attention selectInfor(Long user_phone, Long houses_new_id, int type) throws Exception {
		return attentionMapper.selectInfor(user_phone, houses_new_id, type);
	}
	/**
	 * @Title: deletTnfor
	 * @description 前台页面取消收藏
	 * @param @param user_phone
	 * @param @param houses_new_id
	 * @param @param type
	 * @param @return    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年7月11日
	 */
	@Override
	public int deletTnfor(Long user_phone, Long houses_new_id, int type) {
		return attentionMapper.deletTnfor(user_phone, houses_new_id, type);
	}

}
