package com.yqwl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yqwl.common.utils.Pager;
import com.yqwl.dao.DivideIntoMapper;
import com.yqwl.pojo.DivideInto;
import com.yqwl.service.DivideIntoService;

@Service("divideIntoService")
@Transactional(rollbackFor = { Exception.class })
public class DivideIntoServiceImpl implements DivideIntoService{
	
	@Resource
	private DivideIntoMapper divideIntoMapper;

	@Override
	public PageInfo<DivideInto> listALL(Pager pager) throws Exception {
		// 分页
		PageHelper.startPage(pager);
		List<DivideInto> list = divideIntoMapper.listAll();
		return new PageInfo<DivideInto>(list);
	}

	@Override
	public Integer insertDivideInto(DivideInto divideInto) {
		return divideIntoMapper.insert(divideInto);
	}

	@Override
	public Integer updateDivideInto(DivideInto divideInto) throws Exception {
		
		return divideIntoMapper.updateByPrimaryKeySelective(divideInto);
	}

	@Override
	public Integer deleteDivideInto(Long id) throws Exception {
		return divideIntoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public DivideInto selectDivideIntoById(Long id) throws Exception {
		
		return divideIntoMapper.selectByPrimaryKey(id);
	}
	
}
