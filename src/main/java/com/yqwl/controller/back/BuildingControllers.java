package com.yqwl.controller.back;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yqwl.Vo.BrokerVo;
import com.yqwl.Vo.BuildingListVo;
import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.common.web.BaseController;
import com.yqwl.pojo.Building;
import com.yqwl.pojo.Photo;
import com.yqwl.service.BuildingService;
import com.yqwl.service.PhotoService;

/**
 *
 * @ClassName: BuildingController
 * @description 商厦管理后台controller层
 *
 * @author linhongyu
 * @createDate 2019年4月22日
 */
@Controller
@RequestMapping("building")
public class BuildingControllers extends BaseController {
	@Autowired
	private BuildingService buildingService;
	@Autowired
	private PhotoService photoService;

	/**
	 * @Title: insertSelective
	 * @description 新增一条商厦信息
	 * @param @param
	 *            record
	 * @param @param
	 *            req
	 * @param @return
	 * @return String
	 * @author linhongyu
	 * @createDate 2019年4月22日
	 */
	@RequestMapping(value = "insertSelective", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String insertSelective(Building record, HttpSession session, String[] picture) {
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo == null) {
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			record.setTimes(new Date());
			int num = buildingService.insertSelective(record);
			long id = record.getId();
			Photo photo = new Photo();
			if (picture != null) {
				for (String string : picture) {
					photo.setBuilding_id(id);
					photo.setPhoto(string);
					photoService.insertSelective(photo);
				}
			}
			if (num != 0) {
				return FastJsonUtil.getResponseJson(0, "添加成功", null);
			} else {
				return FastJsonUtil.getResponseJson(-1, "添加失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return dealException(-200, "系统异常", e);
		}
	}

	/**
	 * @Title: updateBy
	 * @description 修改一条商厦信息
	 * @param @param
	 *            record
	 * @param @param
	 *            req
	 * @param @return
	 * @return String
	 * @author linhongyu
	 * @createDate 2019年4月22日
	 */
	@RequestMapping(value = "updateBy", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String updateBy(Building record, HttpServletRequest req, HttpSession session, String[] picture) {
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo == null) {
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			long id = record.getId();
			Photo photo = new Photo();
			record.setTimes(new Date());
			int num = buildingService.updateByPrimaryKeySelective(record);
			if (num != 0) {
				for (String string : picture) {
					photo.setBuilding_id(id);
					photo.setPhoto(string);
					photoService.insertSelective(photo);
				}
				return FastJsonUtil.getResponseJson(0, "修改成功", null);
			} else {
				return FastJsonUtil.getResponseJson(-1, "修改失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return dealException(-200, "系统异常", e);
		}
	}

	/**
	 * @Title: selectByPrimaryKey
	 * @description 通过id查询详情
	 * @param @param
	 *            id
	 * @param @return
	 * @return String
	 * @author linhongyu
	 * @createDate 2019年4月22日
	 */
	@RequestMapping(value = "selectByPrimaryKey", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectByPrimaryKey(Long id, HttpSession session) {
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo == null) {
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			Map<String, Object> building = buildingService.selectByPrimaryKey(id);
			if (building != null) {
				return FastJsonUtil.getResponseJson(0, "查询成功", building);
			} else {
				return FastJsonUtil.getResponseJson(-1, "查询失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return dealException(-200, "系统异常", e);
		}
	}

	/**
	 * @Title: selectBuilding
	 * @description 通过城市查询商厦信息
	 * @param @param
	 *            building
	 * @param @param
	 *            page
	 * @param @param
	 *            limit
	 * @param @return
	 * @return String
	 * @author linhongyu
	 * @createDate 2019年4月23日
	 */
	@RequestMapping(value = "selectBuilding", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectBuilding(BuildingListVo building, Integer page, Integer limit, HttpSession session) {
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo == null) {
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			building.setPage((page - 1) * limit);
			building.setLimit(limit);
			List<BuildingListVo> buildingListVos = buildingService.selectBuilding(building);
			Integer counts = buildingService.selectContBuil(building);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("date", buildingListVos);
			map.put("counts", counts);
			if (buildingListVos.size() > 0) {
				return FastJsonUtil.getResponseJson(0, "查询成功", map);
			} else {
				return FastJsonUtil.getResponseJson(-1, "查询失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return dealException(-200, "系统异常", e);
		}
	}

	
	
	/**
	 * 
	 * @Title: listBybuildingByCity
	 * @description 根据城市查询所有楼盘
	 * @param cityId
	 * @param session
	 * @return
	 * String
	 * @author likai
	 * @createDate 2019年7月4日 下午5:17:46
	 */
	@RequestMapping(value = "listBybuildingByCity", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String listBybuildingByCity(Integer cityId,@RequestParam(required = false)Integer regionId,HttpSession session) {
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo == null) {
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			List<Building> buildings = buildingService.listBybuildingByCity(cityId,regionId);
			if (buildings.size() > 0) {
				return FastJsonUtil.getResponseJson(0, "查询成功", buildings);
			} else {
				return FastJsonUtil.getResponseJson(-1, "查询失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return dealException(-200, "系统异常", e);
		}
	}
	
	/**
	 * @Title: deleteByPrimaryKey
	 * @description 删除一条商厦信息
	 * @param @param
	 *            id
	 * @param @param
	 *            session
	 * @param @return
	 * @return String
	 * @author linhongyu
	 * @createDate 2019年4月30日
	 */
	@RequestMapping(value = "deleteByPrimaryKey", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String deleteByPrimaryKey(Long id, HttpSession session) {
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo == null) {
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			int num = buildingService.deleteByPrimaryKey(id);
			if (num == 1) {
				return FastJsonUtil.getResponseJson(0, "删除成功", null);
			} else if (num == -101) {
				return FastJsonUtil.getResponseJson(-101, "删除失败，商厦有房源出租", null);
			} else if (num == -102) {
				return FastJsonUtil.getResponseJson(-102, "删除失败，商厦有客户关注", null);
			} else if (num == -103) {
				return FastJsonUtil.getResponseJson(-103, "删除失败，首页展示有该商厦", null);
			} else {
				return FastJsonUtil.getResponseJson(-1, "删除失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return dealException(-200, "系统异常", e);
		}
	}

	/**
	 * 
	 * @Title: listAllByCityId
	 * @description 查询一个城市的所有写字楼
	 * @param cityId
	 * @param session
	 * @return String
	 * @author likai
	 * @createDate 2019年5月2日 下午2:50:15
	 */
	@RequestMapping(value = "listAllByCityId", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String listAllByCityId(Long cityId, HttpSession session) {
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo == null) {
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			List<Building> building = buildingService.listAllByCityId(cityId);
			if (building.size() > 0) {
				return FastJsonUtil.getResponseJson(0, "查询成功", building);
			} else {
				return FastJsonUtil.getResponseJson(-1, "查询失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return dealException(-200, "系统异常", e);
		}
	}

	/**
	 * 
	 * @Title: listAllByRegionId
	 * @description 根据区县搜索楼盘
	 * @param cityId
	 * @param session
	 * @return String
	 * @author likai
	 * @createDate 2019年6月18日 上午10:33:27
	 */
	@RequestMapping(value = "listAllByRegionId", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String listAllByRegionId(Long regionId, HttpSession session) {
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo == null) {
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			List<Building> building = buildingService.listAllByRegionId(regionId);
			if (building.size() > 0) {
				return FastJsonUtil.getResponseJson(0, "查询成功", building);
			} else {
				return FastJsonUtil.getResponseJson(-1, "查询失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return dealException(-200, "系统异常", e);
		}
	}
}
