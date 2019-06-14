package com.yqwl.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
	public List<Inform> selectByInform(Long broker_id) {
		return informMapper.selectByInform(broker_id);
	}

}
