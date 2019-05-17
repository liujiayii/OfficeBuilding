package com.yqwl.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yqwl.Vo.MainNewVo;
import com.yqwl.Vo.MainVo;
import com.yqwl.common.utils.Pager;
import com.yqwl.pojo.Existing;
import com.yqwl.pojo.HomePageRecommended;

public interface HomePageRecommendedService {

	List<MainVo> homePageRecommended(Integer cityId, Integer type) throws Exception;

	MainNewVo homePageNew() throws Exception;

	List<Existing> homePageCity() throws Exception;

	Integer insert(HomePageRecommended homePageRecommended) throws Exception;

	Integer delete(Long id) throws Exception;

	PageInfo<Existing> pagerListAll(Pager pager) throws Exception;

	Integer insert(Existing existing) throws Exception;

	Integer deleteExisting(Long id) throws Exception;

}
