package com.yqwl.service;

import com.github.pagehelper.PageInfo;
import com.yqwl.common.utils.Pager;
import com.yqwl.pojo.DivideInto;

/**
 * 
 * @ClassName: DelegationService
 * @description 分成设置实现接口
 *
 * @author liuhangjing
 * @createDate 2019年06月09日
 *
 */
public interface DivideIntoService {

	PageInfo<DivideInto> listALL(Pager pager) throws Exception;

	Integer insertDivideInto(DivideInto divideInto) throws Exception;

	Integer updateDivideInto(DivideInto divideInto) throws Exception;

	Integer deleteDivideInto(Long id) throws Exception;

	DivideInto selectDivideIntoById(Long id) throws Exception;
	
}
