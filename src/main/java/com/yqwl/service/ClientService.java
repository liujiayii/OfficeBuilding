package com.yqwl.service;

import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.yqwl.pojo.Client;

/**
 *
 * @ClassName: ClientService
 * @description Client表的service实现接口
 *
 * @author linhongyu
 * @createDate 2019年4月16日
 */
public interface ClientService {
	/**
	 * @Title: insert
	 * @description 新增一条用户登录信息
	 * @param @param record
	 * @param @return
	 * @param @throws Exception    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年4月29日
	 */
	int insert(Client record) throws Exception;
	/**
	 * @Title: seleceFindId
	 * @description 通过手机号查询用户
	 * @param @param phones
	 * @param @return
	 * @param @throws Exception    
	 * @return Client    
	 * @author linhongyu
	 * @createDate 2019年4月29日
	 */
	Client seleceFindId(Long phones) throws Exception;
	/**
	 * @Title: selectClient
	 * @description 查询客户列表并分页
	 * @param @param page
	 * @param @param limit
	 * @param @return    
	 * @return List<Client>    
	 * @author linhongyu
	 * @createDate 2019年5月5日
	 */
	Map<String, Object> selectClient(@Param("page") Integer page,@Param("limit") Integer limit) ;
}
