package com.yqwl.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	Attention selectInfor(Long user_phone,Long houses_new_id,int type) throws Exception;
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
	int deletTnfor(@Param("user_phone")Long user_phone,@Param("houses_new_id")Long houses_new_id,@Param("type")int type);

}
