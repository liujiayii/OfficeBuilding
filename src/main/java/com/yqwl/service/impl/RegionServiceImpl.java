package com.yqwl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yqwl.dao.RegionMapper;
import com.yqwl.pojo.Region;
import com.yqwl.service.RegionService;

@Service("regionService")
@Transactional(rollbackFor = { Exception.class })
public class RegionServiceImpl implements RegionService {
	@Autowired
	private RegionMapper regionMapper;

	@Override
	public List<Region> listRegionByPid(String pid) throws Exception {
		return regionMapper.listRegionByPid(pid);
	}

	
}
