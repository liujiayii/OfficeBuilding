package com.yqwl.dao;
import java.util.List;
import com.yqwl.Vo.JournalismVo;
import com.yqwl.Vo.MainNewVo;
import com.yqwl.pojo.Journalism;
public interface JournalismMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_journalism
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_journalism
	 * @mbggenerated
	 */
	int insert(Journalism record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_journalism
	 * @mbggenerated
	 */
	int insertSelective(Journalism record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_journalism
	 * @mbggenerated
	 */
	Journalism selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_journalism
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(Journalism record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_journalism
	 * @mbggenerated
	 */
	int updateByPrimaryKeyWithBLOBs(Journalism record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_journalism
	 * @mbggenerated
	 */
	int updateByPrimaryKey(Journalism record);

	Journalism getByTime();

	List<Journalism> listBytype(int type);
    /***
     * @Title: selectJour
     * @description 查询所有新闻
     * @param @param record
     * @param @return    
     * @return List<JournalismVo>    
     * @author linhongyu
     * @createDate 2019年4月12日
     */
    List<JournalismVo> selectJour(JournalismVo records);
    /**
     * @description 查询上一篇 新闻
     * @author linhongyu
     * @createDate 2019年4月14日
     */
    Journalism selectPrevious(Journalism record);
    /**
     * @description 查询下一篇 新闻
     * @author linhongyu
     * @createDate 2019年4月14日
     */
    Journalism selectNext(Journalism record);
}