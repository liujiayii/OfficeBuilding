package com.yqwl.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.yqwl.Vo.JournalismVo;
import com.yqwl.dao.JournalismMapper;
import com.yqwl.pojo.Journalism;
import com.yqwl.service.JournalismService;

/**
 *
 * @ClassName: JournalismServiceImpl
 * @description 用一句话描述这个类的作用
 *
 * @author 姓名全拼
 * @createDate 2019年4月12日
 */
@Service("journalismService")
public class JournalismServiceImpl implements JournalismService{

	@Resource
	private JournalismMapper journalismMapper;
	/* (non-Javadoc)
	 * @see com.yqwl.service.JournalismService#selectJour(com.yqwl.Vo.JournalismVo)
	 */
	@Override
	public List<JournalismVo> selectJour(JournalismVo records) {
		// TODO Auto-generated method stub
		return journalismMapper.selectJour(records);
	}
	/* (non-Javadoc)
	 * @see com.yqwl.service.JournalismService#selectByPrimaryKey(java.lang.Long)
	 */
	@Override
	public Journalism selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return journalismMapper.selectByPrimaryKey(id);
	}
	/* (non-Javadoc)
	 * @see com.yqwl.service.JournalismService#updateByPrimaryKeySelective(com.yqwl.pojo.Journalism)
	 */
	@Override
	public int updateByPrimaryKeySelective(Journalism record) {
		// TODO Auto-generated method stub
		return journalismMapper.updateByPrimaryKeySelective(record);
	}
	/**
     * @description 查询上一篇 新闻
     * @author linhongyu
     * @createDate 2019年4月14日
     */
	@Override
	public Journalism selectPrevious(Journalism record) {
		return journalismMapper.selectPrevious(record);
	}
	/**
     * @description 查询下一篇 新闻
     * @author linhongyu
     * @createDate 2019年4月14日
     */
	@Override
	public Journalism selectNext(Journalism record) {
		return journalismMapper.selectNext(record);
	}

}
