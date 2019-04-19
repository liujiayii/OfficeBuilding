 /**
  *
  * @Title: EntrustseeService.java
* @Package com.yqwl.service
  * @Description: TODO(用一句话描述该文件做什么)
  *
* @author admin
* @date 2019年4月10日
*/
package com.yqwl.service;

import java.util.List;

import com.yqwl.Vo.EntrustseeVo;
import com.yqwl.pojo.Entrustsee;

/**
 *
 * @ClassName: EntrustseeService
 * @description 用一句话描述这个类的作用
 *
 * @author 姓名全拼
 * @createDate 2019年4月10日
 */
public interface EntrustseeService {
	/**
	 * 新增一条预约看房数据
	 */
	int insert(Entrustsee record);
	/**
	 * 修改预约看房状态
	 */
	int updateType(Entrustsee record);
	/**
	 * 后台查询所有预约看房
	 */
	List<EntrustseeVo> selectAllEN(EntrustseeVo record);

}
