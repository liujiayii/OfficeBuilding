package com.yqwl.service;

import com.github.pagehelper.PageInfo;
import com.yqwl.common.utils.Pager;
import com.yqwl.pojo.Group;

public interface GroupService {

	Integer insert(Group group) throws Exception;

	Integer update(Group group) throws Exception;

	Group getByid(Long id) throws Exception;

	PageInfo<Group> ListAll(Pager pager) throws Exception;

}
