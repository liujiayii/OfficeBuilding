package com.yqwl.service;

import java.util.List;

import com.yqwl.Vo.JournalismVo;
import com.yqwl.pojo.Journalism;

/**
 *
 * @ClassName: JournalismService
 * @description 新闻资讯功能实现接口
 *
 * @author linhongyu
 * @createDate 2019年4月12日
 */
public interface JournalismService {
	/***
     * @Title: selectJour
     * @description 通过分类查询所有新闻
     * @param @param record
     * @param @return    
     * @return List<JournalismVo>    
     * @author linhongyu
     * @createDate 2019年4月12日
     */
	List<JournalismVo> selectJour(JournalismVo records) throws Exception;
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
	Journalism selectByPrimaryKey(Long id) throws Exception;
	/**
     * @description 修改当前新闻浏览量
     * @author linhongyu
     * @createDate 2019年4月14日
     */
	int updateByPrimaryKeySelective(Journalism record) throws Exception;
	/**
     * @description 查询上一篇 新闻
     * @author linhongyu
     * @createDate 2019年4月14日
     */
    Journalism selectPrevious(Journalism record) throws Exception;
    /**
     * @description 查询下一篇 新闻
     * @author linhongyu
     * @createDate 2019年4月14日
     */
    Journalism selectNext(Journalism record) throws Exception;
    
    /**
     * @Title: selectAllAome
     * @description 后台查询新闻信息并分页
     * @param @param records
     * @param @return    
     * @return List<JournalismVo>    
     * @author linhongyu
     * @createDate 2019年4月23日
     */
    List<JournalismVo> selectAllAome(JournalismVo records) throws Exception;
    /**
	   * @Title: selectCountJour
	   * @description 后台查询新闻信息条数
	   * @param @param records
	   * @param @return    
	   * @return Integer    
	   * @author linhongyu
	   * @createDate 2019年4月28日
	   */
    Integer selectCountJour(JournalismVo records) throws Exception;
    /**
     * @Title: insertSelective
     * @description 新增新闻资讯表数据
     * @param @param record
     * @param @return    
     * @return int    
     * @author linhongyu
     * @createDate 2019年4月28日
     */
    int insertSelective(Journalism record) throws Exception;
    /**
     * @Title: deleteByPrimaryKey
     * @description 删除一条新闻资讯
     * @param @param id
     * @param @return    
     * @return int    
     * @author linhongyu
     * @throws Exception 
     * @createDate 2019年4月30日
     */
    int deleteByPrimaryKey(Long id) throws Exception;
}
