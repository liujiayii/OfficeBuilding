package com.yqwl.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yqwl.Vo.InformVo;
import com.yqwl.dao.InformMapper;
import com.yqwl.pojo.Inform;
import com.yqwl.service.InformService;

/**
 *
 * @ClassName: InformServiceImpl
 * @description 撤单表的业务实现层
 * @author linhongyu
 * @createDate 2019年6月10日
 */
@Service("InformService")
@Transactional(rollbackFor = { Exception.class })
public class InformServiceImpl implements InformService{

	@Autowired
	private InformMapper informMapper;
	
	/**
	 * @Title: selectByInform
	 * @description 通过经纪人id查询是否有被通知撤单的数据
	 * @param @param broker_id
	 * @param @return    
	 * @return List<Inform>    
	 * @author linhongyu
	 * @createDate 2019年6月10日
	 */
	@Override
	public List<InformVo> selectByInform(Long broker_id) throws Exception{
		return informMapper.selectByInform(broker_id);
	}

	/**
     * @Title: deleteKey
     * @description 取消撤单
     * @param @param broker_id
     * @param @param home_id
     * @param @return    
     * @return int    
     * @author linhongyu
     * @createDate 2019年7月4日
     */
	@Override
	public int deleteInform(Long broker_id, Long home_id) throws Exception{
		int num = informMapper.deleteKey(broker_id, home_id);
		return num;
	}

	/**
	 * @Title: selectTrue
	 * @description 查询该房源是否有撤单
	 * @param @param home_id
	 * @param @param broker_id
	 * @param @return    
	 * @return List<Inform>    
	 * @author linhongyu
	 * @createDate 2019年7月8日
	 */
	@Override
	public List<Inform> selectTrue(Long home_id, Long broker_id) {
		return informMapper.selectTrue(home_id, broker_id);
	}

}
