package com.yqwl.service;
import java.util.List;
import com.yqwl.pojo.Photo;

/**
 *
 * @ClassName: PhotoService
 * @description 商厦图片表service接口
 *
 * @author linhongyu
 * @createDate 2019年4月9日
 */
public interface PhotoService {
	/**
	 * @Title: selectPhoto
	 * @description 查询商厦所有图片
	 * @param @param id
	 * @param @return    
	 * @return List<Photo>    
	 * @author linhongyu
	 * @createDate 2019年4月28日
	 */
	public List<Photo> selectPhoto(Long id) throws Exception;
	/**
	 * @Title: insertSelective
	 * @description 新增商厦图片
	 * @param @param record
	 * @param @return    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年4月28日
	 */
	int insertSelective(Photo record);

	/**
	 *
	 * @Title: listByBuildingId
	 * @description 通过商厦id查询图片
	 *
	 * @param @param building_id
	 * @param @return    
	 * @return List<Photo>    
	 *
	 * @author linhongyu
	 * @createDate 2019年4月25日
	 */
	public List<Photo> listByBuildingId(Long buildingId);
	/**
	 * @Title: selectByPrimaryKey
	 * @description 通过id查询
	 * @param @param id
	 * @param @return    
	 * @return Photo    
	 * @author linhongyu
	 * @createDate 2019年4月29日
	 */
	Photo selectByPrimaryKey(Long id);
	/**
	 * @Title: deleteByPrimaryKey
	 * @description 删除商厦图片
	 * @param @param id
	 * @param @return    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年4月28日
	 */
	int deleteByPrimaryKey(Long id);
}
