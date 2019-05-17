
package com.yqwl.service.impl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yqwl.dao.PhotoMapper;
import com.yqwl.pojo.Photo;
import com.yqwl.service.PhotoService;

/**
 *
 * @ClassName: PhotoServiceImpl
 * @description 商厦图片表serviceImpl业务层
 *
 * @author linhongyu
 * @createDate 2019年4月9日
 */
@Service("photoService")
@Transactional(rollbackFor = { Exception.class })
public class PhotoServiceImpl implements PhotoService{

	@Resource
	private PhotoMapper photoMapper;
	/**
	 * @Title: selectPhoto
	 * @description 查询该商厦所有图片
	 * @param @param id
	 * @param @return    
	 * @return List<Photo>    
	 * @author linhongyu
	 * @createDate 2019年4月28日
	 */
	@Override
	public List<Photo> selectPhoto(Long id) throws Exception{
		return photoMapper.selectPhoto(id);
	}
	/**
	 * @Title: insertSelective
	 * @description 新增商厦图片
	 * @param @param record
	 * @param @return    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年4月28日
	 */
	@Override
	public int insertSelective(Photo record) {
		return photoMapper.insertSelective(record);
	}

	@Override
	public List<Photo> listByBuildingId(Long buildingId) {
		return photoMapper.listByBuildingId(buildingId);
	}

	@Override
	public Photo selectByPrimaryKey(Long id) {
		return photoMapper.selectByPrimaryKey(id);
	}
	/**
	 * @Title: deleteByPrimaryKey
	 * @description 删除商厦图片
	 * @param @param id
	 * @param @return    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年4月28日
	 */
	@Override
	public int deleteByPrimaryKey(Long id) {
		return photoMapper.deleteByPrimaryKey(id);
	}

}
