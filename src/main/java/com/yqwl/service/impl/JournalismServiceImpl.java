package com.yqwl.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yqwl.Vo.JournalismVo;
import com.yqwl.common.utils.UpdateFiles;
import com.yqwl.dao.JournalismMapper;
import com.yqwl.dao.NewsPicMapper;
import com.yqwl.pojo.Journalism;
import com.yqwl.pojo.NewsPic;
import com.yqwl.service.JournalismService;

/**
 *
 * @ClassName: JournalismServiceImpl
 * @description 新闻咨询表serviceimpl业务层
 *
 * @author linhongyu
 * @createDate 2019年4月12日
 */
@Service("journalismService")
@Transactional(rollbackFor = { Exception.class })
public class JournalismServiceImpl implements JournalismService{

	@Resource
	private JournalismMapper journalismMapper;
	@Resource
	private NewsPicMapper newsPicMapper;
	/***
     * @Title: selectJour
     * @description 通过分类查询所有新闻
     * @param @param record
     * @param @return    
     * @return List<JournalismVo>    
     * @author linhongyu
     * @createDate 2019年4月12日
     */
	@Override
	public List<JournalismVo> selectJour(JournalismVo records) throws Exception{
		return journalismMapper.selectJour(records);
	}
	/**
	 * @Title: selectByPrimaryKey
	 * @description 查询该条新闻详情
	 * @param @param id
	 * @param @return
	 * @param @throws Exception    
	 * @return Journalism    
	 * @author linhongyu
	 * @createDate 2019年4月28日
	 */
	@Override
	public Journalism selectByPrimaryKey(Long id) throws Exception{
		//增加浏览量
		Journalism selectByPrimaryKey = journalismMapper.selectByPrimaryKey(id);
		Long a=selectByPrimaryKey.getPage_view();
		long b=a+1; //加一
		Journalism record=new Journalism();
		record.setPage_view(b);
		record.setId(id);
		journalismMapper.updateJourna(record);
		return journalismMapper.selectByPrimaryKey(id);
	}
	@Override
	public int updateByPrimaryKeySelective(Journalism record) throws Exception{
		return journalismMapper.updateByPrimaryKeySelective(record);
	}
	/**
     * @description 查询上一篇 新闻
     * @author linhongyu
     * @createDate 2019年4月14日
     */
	@Override
	public Journalism selectPrevious(Journalism record) throws Exception{
		return journalismMapper.selectPrevious(record);
	}
	/**
     * @description 查询下一篇 新闻
     * @author linhongyu
     * @createDate 2019年4月14日
     */
	@Override
	public Journalism selectNext(Journalism record) throws Exception{
		return journalismMapper.selectNext(record);
	}
	/**
     * @Title: selectAllAome
     * @description 后台查询新闻信息并分页
     * @param @param records
     * @param @return    
     * @return List<JournalismVo>    
     * @author linhongyu
     * @createDate 2019年4月23日
     */
	@Override
	public List<JournalismVo> selectAllAome(JournalismVo records) throws Exception{
		return journalismMapper.selectAllAome(records);
	}
	  /**
	   * @Title: selectCountJour
	   * @description 后台查询新闻信息条数
	   * @param @param records
	   * @param @return    
	   * @return Integer    
	   * @author linhongyu
	   * @createDate 2019年4月28日
	   */
	@Override
	public Integer selectCountJour(JournalismVo records) throws Exception{
		return journalismMapper.selectCountJour(records);
	}
	/**
     * @Title: insertSelective
     * @description 新增新闻资讯表数据
     * @param @param record
     * @param @return    
     * @return int    
     * @author linhongyu
     * @createDate 2019年4月28日
     */
	@Override
	public int insertSelective(Journalism record) throws Exception{
		return journalismMapper.insertSelective(record);
	}
	/**
     * @Title: deleteByPrimaryKey
     * @description 删除一条新闻资讯
     * @param @param id
     * @param @return    
     * @return int    
     * @author linhongyu
     * @createDate 2019年4月30日
     */
	@Override
	public int deleteByPrimaryKey(Long id) throws Exception{
		Journalism ts=journalismMapper.selectByPrimaryKey(id);
		String urls=ts.getJour_pic();
		UpdateFiles.deleatFile(urls);
		int num=journalismMapper.deleteByPrimaryKey(id);
		Long journalism_id=id;
		List<NewsPic> newsPics=newsPicMapper.selectPic(journalism_id);
		for(int i=0;i<newsPics.size();i++){
			Long ids=newsPics.get(i).getId();
			NewsPic name = newsPicMapper.selectByPrimaryKey(ids);
			String url=name.getPicture();
				try {
					UpdateFiles.deleatFile(url);
					newsPicMapper.deleteByPrimaryKey(ids);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		return num;
	}

}
