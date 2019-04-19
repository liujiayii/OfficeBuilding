package com.yqwl.service;

import java.util.List;

import com.yqwl.Vo.MainNewVo;
import com.yqwl.Vo.MainVo;
import com.yqwl.pojo.Existing;

public interface HomePageRecommendedService {

	List<MainVo> homePageRecommended(Integer cityId, Integer type) throws Exception;

	MainNewVo homePageNew() throws Exception;

	Existing homePageCity()throws Exception;

}
