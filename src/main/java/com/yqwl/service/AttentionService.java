package com.yqwl.service;

import java.util.List;

import com.yqwl.Vo.AttentionVo;
import com.yqwl.pojo.Attention;

/**
 *
 * @ClassName: AttentionService
 * @description 用一句话描述这个类的作用
 *
 * @author linhongyu
 * @createDate 2019年4月11日
 */
public interface AttentionService {
	/**
	 * @Title: insertSelective
	 * @description 新增一条收藏信息
	 * @param @param record
	 * @param @return
	 * @param @throws Exception    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年4月30日
	 */
	int insertSelective(Attention record) throws Exception;
	/**
	 * @Title: deleteByPrimaryKey
	 * @description 删除用来取消一条收藏数据
	 * @param @param id
	 * @param @return
	 * @param @throws Exception    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年4月30日
	 */
	int deleteByPrimaryKey(Long id) throws Exception;
	/**
	 * @Title: selectFinfAll
	 * @description 查询id用于查重
	 * @param @param record
	 * @param @return    
	 * @return Attention    
	 * @author linhongyu
	 * @createDate 2019年4月30日
	 */
	Attention selectFinfAll(Attention record) throws Exception;
	/**
	 * @Title: selectScend
	 * @description 查询收藏的商厦信息
	 * @param @param records
	 * @param @return    
	 * @return List<AttentionVo>    
	 * @author linhongyu
	 * @createDate 2019年4月30日
	 */
	List<AttentionVo> selectScend(AttentionVo records) throws Exception;
	/**
	 * @Title: selectThird
	 * @description 查询收藏的房源信息
	 * @param @param records
	 * @param @return    
	 * @return List<AttentionVo>    
	 * @author linhongyu
	 * @createDate 2019年4月30日
	 */
	List<AttentionVo> selectThird(AttentionVo records) throws Exception;
	/**
	 * @Title: selectCount
	 * @description 查询收藏数据条数
	 * @param @param records
	 * @param @return    
	 * @return Integer    
	 * @author linhongyu
	 * @createDate 2019年4月30日
	 */
	Integer selectCount(AttentionVo records) throws Exception;
}
