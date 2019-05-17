package com.yqwl.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yqwl.common.utils.Pager;
import com.yqwl.pojo.Group;

public interface GroupService {

	Integer insert(Group group) throws Exception;

	Integer update(Group group) throws Exception;

	Group getByid(Long id) throws Exception;

	PageInfo<Group> ListAll(Pager pager) throws Exception;

	List<Group> getByShopId(Long shopId) throws Exception;

	Integer delete(Long id) throws Exception;

}
