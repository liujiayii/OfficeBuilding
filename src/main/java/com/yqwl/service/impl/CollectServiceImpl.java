package com.yqwl.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.yqwl.Vo.CollectVo;
import com.yqwl.dao.CollectMapper;
import com.yqwl.pojo.Collect;
import com.yqwl.service.CollectService;

/**
 *
 * @ClassName: CollectServiceImpl
 * @description 用一句话描述这个类的作用
 * @author linhongyu
 * @createDate 2019年6月12日
 */
@Service("collectService")
@Transactional(rollbackFor = { Exception.class })
public class CollectServiceImpl implements CollectService{

	@Autowired
	private CollectMapper collectMapper;
	/**
	 * @Title: insertSelective
	 * @description 经纪人收藏房源
	 * @param @param record
	 * @param @return    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年6月12日
	 */
	@Override
	public int insertSelective(Collect record) throws Exception{
		return collectMapper.insertSelective(record);
	}

	/**
	 * @Title: deleteByPrimaryKey
	 * @description 经纪人取消收藏
	 * @param @param id
	 * @param @return    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年6月12日
	 */
	@Override
	public int deleteByPrimaryKey(Long id) throws Exception{
		return collectMapper.deleteByPrimaryKey(id);
	}

	/**
     * @Title: selectListCo
     * @description 查询经纪人收藏房源信息
     * @param @param broker_id
     * @param @return    
     * @return List<CollectVo>    
     * @author linhongyu
     * @createDate 2019年6月13日
     */
	@Override
	public Map<String, Object> selectListCo(Long broker_id,Integer page,Integer limit) throws Exception{
		Map<String, Object> map = new HashMap<>();
		List<CollectVo> collectVos=collectMapper.selectListCo(broker_id,page,limit);
		Integer count=collectMapper.selectCollCount(broker_id);
		map.put("date", collectVos);
		map.put("count", count);
		return map;
	}

	/**
     * @Title: selectTwo
     * @description 判断房源是否已收藏
     * @param @param broker_id
     * @param @param home_id
     * @param @return    
     * @return Collect    
     * @author linhongyu
     * @createDate 2019年6月13日
     */
	@Override
	public Collect selectTwo(Collect record) throws Exception {
		return collectMapper.selectTwo(record);
	}

}
