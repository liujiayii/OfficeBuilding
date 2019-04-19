package com.yqwl.service;

import java.util.List;

import com.yqwl.pojo.Region;

public interface RegionService {

	List<Region> listRegionByPid(String pid) throws Exception;

}
