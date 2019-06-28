package com.yqwl.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.yqwl.Vo.UserListVo;
import com.yqwl.Vo.UserVo;
import com.yqwl.common.utils.Pager;
import com.yqwl.pojo.User;
import com.yqwl.pojo.UserFollowUp;
import com.yqwl.pojo.UserPhone;

public interface UserService {

	Integer insert(User user, String... phone) throws Exception;

	Integer update(User user) throws Exception;

	UserVo getByid(Long id) throws Exception;

	PageInfo<User> listAll(Pager pager) throws Exception;

	Integer insertUserFollowUp(UserFollowUp userFollowUp) throws Exception;

	Integer updateUserPhone(UserPhone userPhone) throws Exception;
	/**
	 * @Title: selectListShop
	 * @description 通过区县id查询分店id
	 * @param @param region_id
	 * @param @return    
	 * @return List<User>    
	 * @author linhongyu
	 * @createDate 2019年6月13日
	 */
	List<User> selectListShop(Long region_id) throws Exception;
	/**
	 * @Title: selectAllSome
	 * @description 通过经纪人id查询客源
	 * @param @param shopId
	 * @param @param startTime
	 * @param @param endTime
	 * @param @return    
	 * @return List<Map<String,Object>>    
	 * @author linhongyu
	 * @createDate 2019年6月17日
	 */
	public List<Map<String, Object>> selectAllSome(Long shopId,Date startTime,Date endTime) throws Exception;

	Integer insertUserPhone(UserPhone userPhone) throws Exception;

	List<User> findAll() throws Exception;

}
