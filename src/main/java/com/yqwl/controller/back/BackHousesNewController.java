package com.yqwl.controller.back;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yqwl.pojo.Owner;
import com.github.pagehelper.PageInfo;
import com.yqwl.Vo.BackHousesVo;
import com.yqwl.Vo.BrokerVo;
import com.yqwl.Vo.FeedbackVo;
import com.yqwl.Vo.HousesNewVo;
import com.yqwl.Vo.HousesVo;
import com.yqwl.common.utils.Constants;
import com.yqwl.common.utils.FastJsonUtil;
import com.yqwl.common.utils.Pager;
import com.yqwl.common.web.BaseController;
import com.yqwl.dao.InformMapper;
import com.yqwl.dao.OwnerMapper;
import com.yqwl.pojo.HousesNew;
import com.yqwl.pojo.Inform;
import com.yqwl.pojo.Picture;
import com.yqwl.pojo.PlotBuild;
import com.yqwl.pojo.PlotDoor;
import com.yqwl.service.FeedbackService;
import com.yqwl.service.HousesNewService;
import com.yqwl.service.PictureService;

/**
 * 
 * @ClassName: BackHousesNewController
 *
 * @description 后台房源表功能控制层
 *
 * @author yaozijun
 *
 * @createDate 2019年4月23日
 */
@Controller
@Scope("prototype")
@RequestMapping("BackHousesNew")
public class BackHousesNewController extends BaseController {
	@Autowired
	private HousesNewService housesNewService;
	@Autowired
	private PictureService pictureService;
	@Resource
	private FeedbackService feedbackService;
	@Autowired
	private InformMapper informMapper;
	@Autowired
	private OwnerMapper ownerMapper;
	/**
	 * 
	 * @Title: selectBackHousesNewList
	 *
	 * @description 后台列表显示房源
	 *
	 * @param @param
	 *            pager
	 * @param @return
	 * 
	 * @return String
	 *
	 * @author yaozijun
	 *
	 * @createDate 2019年4月23日
	 */
	@RequestMapping(value = "selectBackHousesNewList", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectBackHousesNewList(Pager pager, HttpSession session) {
		try {
			int code = 0;
			String msg = null;
			/** 判断是否登录 */
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				PageInfo<HousesNew> result = housesNewService.listHousesNewByCondition(pager);
				if (result.getTotal() != 0) {
					msg = "查询成功";
					return FastJsonUtil.getResponseJson(code, msg, result);
				}
				code = -1;
				msg = "查询失败";
				return FastJsonUtil.getResponseJson(code, msg, null);
			}
			return FastJsonUtil.getResponseJson("-2", "未登录");
		} catch (Exception e) {
			return dealException(-200, "系统异常", e);
		}
	}

	/**
	 * 
	 * @Title: ListBackHousesNew
	 * @description 查询本店房源
	 * @param pager
	 * @param session
	 * @return String
	 * @author likai
	 * @createDate 2019年5月2日 下午2:56:24
	 */
	@RequestMapping(value = "ListBackHousesNew", method = RequestMethod.GET, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String ListBackHousesNew(Pager pager, HttpSession session) {
		try {
			int code = 0;
			String msg = null;
			/** 判断是否登录 */
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				PageInfo<HousesVo> result = housesNewService.ListBackHousesNew(pager, brokerVo.getId());
				if (result.getTotal() != 0) {
					msg = "查询成功";
					return FastJsonUtil.getResponseJson(code, msg, result);
				}
				code = -1;
				msg = "查询失败";
				return FastJsonUtil.getResponseJson(code, msg, null);
			}
			return FastJsonUtil.getResponseJson("-2", "未登录");
		} catch (Exception e) {
			return dealException(-200, "系统异常", e);
		}
	}

	/**
	 * 
	 * @Title: getById
	 * @description 查询店铺详情
	 * @param Id
	 * @param session
	 * @return String
	 * @author likai
	 * @createDate 2019年5月2日 下午3:07:12
	 */
	@RequestMapping(value = "getById", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String getById(Long id, HttpSession session) {
		try {
			int code = 0;
			String msg = null;
			/** 判断是否登录 */
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				Map<String, Object> map = new HashMap<>();
				BackHousesVo result = housesNewService.getById(id);
				List<Owner> own=ownerMapper.selectHome(id);
				map.put("result", result);
				map.put("own", own);
				if (map.size()!=0) {
					msg = "查询成功";
					return FastJsonUtil.getResponseJson(code, msg, map);
				}
				code = -1;
				msg = "查询失败";
				return FastJsonUtil.getResponseJson(code, msg, null);
			}
			return FastJsonUtil.getResponseJson("-2", "未登录");
		} catch (Exception e) {
			return dealException(-200, "系统异常", e);
		}
	}

	/**
	 * 
	 * @Title: insertSelective
	 *
	 * @description 后台新增房源信息及图片信息
	 *
	 * @param @param
	 *            record
	 * @param @param
	 *            brokerId
	 * @param @param
	 *            picture
	 * @param @return
	 * 
	 * @return String
	 *
	 * @author yaozijun
	 *
	 * @createDate 2019年4月23日
	 */
	@RequestMapping(value = "insertSelective", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String insertSelective(HousesNew record, HttpSession session,String number ,String... urls) {
		try {
			/** 判断是否登录 */
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				int count = housesNewService.insertSelective(record, brokerVo.getId(),number ,urls);
				if (count != 0) {
					return FastJsonUtil.getResponseJson(0, "新增成功", null);
				} else {
					return FastJsonUtil.getResponseJson(-1, "新增失败", null);
				}
			}
			return FastJsonUtil.getResponseJson("-2", "未登录");
		} catch (Exception e) {
			return dealException(-200, "系统异常", e);
		}
	}

	/**
	 * 
	 * @Title: updateByPrimaryKeySelective
	 *
	 * @description 后台修改房源信息及图片信息
	 *
	 * @param @param
	 *            record
	 * @param @param
	 *            session
	 * @param @param
	 *            urls
	 * @param @return
	 * 
	 * @return String
	 *
	 * @author yaozijun
	 *
	 * @createDate 2019年4月23日
	 */
	@RequestMapping(value = "updateByPrimaryKeySelective", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String updateByPrimaryKeySelective(HousesNew record, HttpSession session, String... urls) {
		try {
			/** 判断是否登录 */
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				int count = housesNewService.updateByPrimaryKeySelective(record, brokerVo.getId(), urls);
				if (count != 0) {
					return FastJsonUtil.getResponseJson(0, "修改成功", null);
				} else {
					return FastJsonUtil.getResponseJson(-1, "修改失败", null);
				}
			}
			return FastJsonUtil.getResponseJson("-2", "未登录");
		} catch (Exception e) {
			return dealException(-200, "系统异常", e);
		}
	}
	
	/**
	 *
	 * @Title: updateTypes
	 * @description 修改上下架状态
	 * @param @param record
	 * @param @return    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年7月9日
	 */
	@RequestMapping(value = "updateTypes", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String updateTypes(HousesNew record, HttpSession session) {
		try {
			/** 判断是否登录 */
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				int count = housesNewService.updateTypes(record);
				if (count != 0) {
					return FastJsonUtil.getResponseJson(0, "修改成功", null);
				} else {
					return FastJsonUtil.getResponseJson(-1, "修改失败", null);
				}
			}
			return FastJsonUtil.getResponseJson("-2", "未登录");
		} catch (Exception e) {
			return dealException(-200, "系统异常", e);
		}
	}

	/**
	 * 
	 * @Title: delHome
	 * @description 删除房源
	 * @param session
	 * @param homeId
	 * @return String
	 * @author likai
	 * @createDate 2019年5月3日 下午5:49:59
	 */
	@ResponseBody
	@RequestMapping(value = "/delHome", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String delHome(HttpSession session, Long homeId) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				int result = housesNewService.delHome(homeId);
				if (result != 0) {
					msg = "删除成功";
					return FastJsonUtil.getResponseJson(code, msg, result);
				}
				code = -1;
				msg = "删除失败";
				return FastJsonUtil.getResponseJson(code, msg, null);
			}
			msg = "未登录";
			return FastJsonUtil.getResponseJson("-2", msg);
		} catch (Exception e) {
			code = -200;
			msg = "系统异常";
			return dealException(code, msg, e);
		}
	}

	/**
	 * 
	 * @Title: getPlotBuildByConditions
	 * @description 根据楼盘Id查询座栋信息
	 * @param session
	 * @param BuildingId
	 * @return String
	 * @author likai
	 * @createDate 2019年4月30日 上午9:24:57
	 */
	@ResponseBody
	@RequestMapping(value = "/getPlotBuildByConditions", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String getPlotBuildByConditions(HttpSession session, Long BuildingId) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				List<PlotBuild> result = housesNewService.getPlotBuildByConditions(BuildingId);
				if (result.size() != 0) {
					msg = "查询成功";
					return FastJsonUtil.getResponseJson(code, msg, result);
				}
				code = -1;
				msg = "查询失败";
				return FastJsonUtil.getResponseJson(code, msg, null);
			}
			msg = "未登录";
			return FastJsonUtil.getResponseJson("-2", msg);
		} catch (Exception e) {
			code = -200;
			msg = "系统异常";
			return dealException(code, msg, e);
		}
	}

	/**
	 * 
	 * @Title: getPlotDoorByConditions
	 * @description 根据座栋信息查询门牌号
	 * @param session
	 * @param BuildId
	 * @return String
	 * @author likai
	 * @createDate 2019年4月30日 上午9:25:20
	 */
	@ResponseBody
	@RequestMapping(value = "/getPlotDoorByConditions", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String getPlotDoorByConditions(HttpSession session, Long BuildId) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				List<PlotDoor> result = housesNewService.getPlotDoorByConditions(BuildId);
				if (result.size() != 0) {
					msg = "查询成功";
					return FastJsonUtil.getResponseJson(code, msg, result);
				}
				code = -1;
				msg = "查询失败";
				return FastJsonUtil.getResponseJson(code, msg, null);
			}
			msg = "未登录";
			return FastJsonUtil.getResponseJson("-2", msg);
		} catch (Exception e) {
			code = -200;
			msg = "系统异常";
			return dealException(code, msg, e);
		}
	}

	/**
	 * 
	 * 
	 * @Title: insertPlotDoor
	 * @description 新增门牌号
	 * @param session
	 * @param plotDoor
	 * @return String
	 * @author likai
	 * @createDate 2019年4月30日 上午9:34:59
	 */
	@ResponseBody
	@RequestMapping(value = "/insertPlotDoor", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String insertPlotDoor(HttpSession session, PlotDoor plotDoor) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				int result = housesNewService.insertPlotDoor(plotDoor);
				if (result != 0) {
					msg = "新增成功";
					return FastJsonUtil.getResponseJson(code, msg, result);
				}
				code = -1;
				msg = "新增失败";
				return FastJsonUtil.getResponseJson(code, msg, null);
			}
			msg = "未登录";
			return FastJsonUtil.getResponseJson("-2", msg);
		} catch (Exception e) {
			code = -200;
			msg = "系统异常";
			return dealException(code, msg, e);
		}
	}

	/**
	 * 
	 * @Title: insertDoor
	 * @description 批量增加门牌号
	 * @param session
	 * @param build_id
	 * @param flooors
	 * @param startDoor
	 * @param endDoor
	 * @return String
	 * @author likai
	 * @createDate 2019年5月9日 下午2:33:39
	 */
	@ResponseBody
	@RequestMapping(value = "/insertDoor", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String insertDoor(HttpSession session, Long build_id, Integer flooors, Integer startDoor, Integer endDoor,
			@RequestParam(required = false, value = "span") List<Integer> span) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				int result = housesNewService.insertDoor(build_id, flooors, startDoor, endDoor, span);
				if (result != 0) {
					msg = "新增成功";
					return FastJsonUtil.getResponseJson(code, msg, result);
				}
				code = -1;
				msg = "新增失败";
				return FastJsonUtil.getResponseJson(code, msg, null);
			}
			msg = "未登录";
			return FastJsonUtil.getResponseJson("-2", msg);
		} catch (Exception e) {
			code = -200;
			msg = "系统异常";
			return dealException(code, msg, e);
		}
	}

	/**
	 * 
	 * @Title: insertPlotBuild
	 * @description 新增座栋
	 * @param session
	 * @param plotBuild
	 * @return String
	 * @author likai
	 * @createDate 2019年4月30日 上午10:03:43
	 */
	@ResponseBody
	@RequestMapping(value = "/insertPlotBuild", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String insertPlotBuild(HttpSession session, PlotBuild plotBuild) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				int result = housesNewService.insertPlotBuild(plotBuild);
				if (result != 0) {
					msg = "新增成功";
					return FastJsonUtil.getResponseJson(code, msg, result);
				}
				code = -1;
				msg = "新增失败";
				return FastJsonUtil.getResponseJson(code, msg, null);
			}
			msg = "未登录";
			return FastJsonUtil.getResponseJson("-2", msg);
		} catch (Exception e) {
			code = -200;
			msg = "系统异常";
			return dealException(code, msg, e);
		}
	}

	/**
	 * 
	 * @Title: updatePlotBuild
	 * @description 修改座栋
	 * @param session
	 * @param plotBuild
	 * @return String
	 * @author likai
	 * @createDate 2019年4月30日 上午10:04:28
	 */
	@ResponseBody
	@RequestMapping(value = "/updatePlotBuild", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String updatePlotBuild(HttpSession session, PlotBuild plotBuild) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				int result = housesNewService.updatePlotBuild(plotBuild);
				if (result != 0) {
					msg = "修改成功";
					return FastJsonUtil.getResponseJson(code, msg, result);
				}
				code = -1;
				msg = "修改失败";
				return FastJsonUtil.getResponseJson(code, msg, null);
			}
			msg = "未登录";
			return FastJsonUtil.getResponseJson("-2", msg);
		} catch (Exception e) {
			code = -200;
			msg = "系统异常";
			return dealException(code, msg, e);
		}
	}

	/**
	 * 
	 * @Title: updatePlotDoor
	 * @description 修改门牌号
	 * @param session
	 * @param plotDoor
	 * @return String
	 * @author likai
	 * @createDate 2019年4月30日 上午10:04:44
	 */
	@ResponseBody
	@RequestMapping(value = "/updatePlotDoor", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String updatePlotDoor(HttpSession session, PlotDoor plotDoor) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				int result = housesNewService.updatePlotDoor(plotDoor);
				if (result != 0) {
					msg = "修改成功";
					return FastJsonUtil.getResponseJson(code, msg, result);
				}
				code = -1;
				msg = "修改失败";
				return FastJsonUtil.getResponseJson(code, msg, null);
			}
			msg = "未登录";
			return FastJsonUtil.getResponseJson("-2", msg);
		} catch (Exception e) {
			code = -200;
			msg = "系统异常";
			return dealException(code, msg, e);
		}
	}

	/**
	 * 
	 * @Title: deletePlotDoor
	 * @description 删除门牌号
	 * @param session
	 * @param id
	 * @return String
	 * @author likai
	 * @createDate 2019年4月30日 上午10:05:26
	 */
	@ResponseBody
	@RequestMapping(value = "/deletePlotDoor", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String deletePlotDoor(HttpSession session, Long id) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				int result = housesNewService.deletePlotDoor(id);
				if (result != 0) {
					msg = "删除成功";
					return FastJsonUtil.getResponseJson(code, msg, result);
				}
				code = -1;
				msg = "删除失败";
				return FastJsonUtil.getResponseJson(code, msg, null);
			}
			msg = "未登录";
			return FastJsonUtil.getResponseJson("-2", msg);
		} catch (Exception e) {
			code = -200;
			msg = "系统异常";
			return dealException(code, msg, e);
		}
	}

	/**
	 * 
	 * @Title: deletePlotDoorByFloor
	 * @description 删除座栋某个楼层的所有门牌号
	 * @param session
	 * @param buildId
	 * @param floor
	 * @return String
	 * @author likai
	 * @createDate 2019年6月4日 上午10:49:29
	 */
	@ResponseBody
	@RequestMapping(value = "/deletePlotDoorByFloor", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String deletePlotDoorByFloor(HttpSession session, Long buildId, Integer floor) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				int result = housesNewService.deletePlotDoorByFloor(buildId, floor);
				if (result != 0) {
					msg = "删除成功";
					return FastJsonUtil.getResponseJson(code, msg, result);
				}
				code = -1;
				msg = "删除失败";
				return FastJsonUtil.getResponseJson(code, msg, null);
			}
			msg = "未登录";
			return FastJsonUtil.getResponseJson("-2", msg);
		} catch (Exception e) {
			code = -200;
			msg = "系统异常";
			return dealException(code, msg, e);
		}
	}

	/**
	 * 
	 * @Title: deletePlotBuild
	 * @description 删除座栋
	 * @param session
	 * @param id
	 * @return String
	 * @author likai
	 * @createDate 2019年4月30日 上午10:05:41
	 */
	@ResponseBody
	@RequestMapping(value = "/deletePlotBuild", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String deletePlotBuild(HttpSession session, Long id) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				int result = housesNewService.deletePlotBuild(id);
				if (result != 0) {
					msg = "删除成功";
					return FastJsonUtil.getResponseJson(code, msg, result);
				}
				code = -1;
				msg = "删除失败";
				return FastJsonUtil.getResponseJson(code, msg, null);
			}
			msg = "未登录";
			return FastJsonUtil.getResponseJson("-2", msg);
		} catch (Exception e) {
			code = -200;
			msg = "系统异常";
			return dealException(code, msg, e);
		}
	}

	/**
	 * 
	 * @Title: getPlotDoorById
	 * @description 根据Id查询门牌号
	 * @param session
	 * @param id
	 * @return String
	 * @author likai
	 * @createDate 2019年5月4日 上午11:41:34
	 */
	@ResponseBody
	@RequestMapping(value = "/getPlotDoorById", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String getPlotDoorById(HttpSession session, Long id) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				PlotDoor result = housesNewService.getPlotDoorById(id);
				if (result != null) {
					msg = "查询成功";
					return FastJsonUtil.getResponseJson(code, msg, result);
				}
				code = -1;
				msg = "查询失败";
				return FastJsonUtil.getResponseJson(code, msg, null);
			}
			msg = "未登录";
			return FastJsonUtil.getResponseJson("-2", msg);
		} catch (Exception e) {
			code = -200;
			msg = "系统异常";
			return dealException(code, msg, e);
		}
	}

	/**
	 * 
	 * @Title: getPlotBuildById
	 * @description 根据Id查询座栋
	 * @param session
	 * @param id
	 * @return String
	 * @author likai
	 * @createDate 2019年5月4日 上午11:41:58
	 */
	@ResponseBody
	@RequestMapping(value = "/getPlotBuildById", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String getPlotBuildById(HttpSession session, Long id) {
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo != null) {
				PlotBuild result = housesNewService.getPlotBuildById(id);
				if (result != null) {
					msg = "查询成功";
					return FastJsonUtil.getResponseJson(code, msg, result);
				}
				code = -1;
				msg = "查询失败";
				return FastJsonUtil.getResponseJson(code, msg, null);
			}
			msg = "未登录";
			return FastJsonUtil.getResponseJson("-2", msg);
		} catch (Exception e) {
			code = -200;
			msg = "系统异常";
			return dealException(code, msg, e);
		}
	}

	/**
	 * @Title: updateSelective
	 * @description 修改房源状态活开盘修改
	 * @param @param
	 *            record
	 * @param @return
	 * @return int
	 * @author linhongyu
	 * @createDate 2019年6月12日
	 */
	@RequestMapping(value = "updateSelective", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String updateSelective(HousesNew record, HttpSession session) {
		try {
			/** 判断是否登录 */
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo == null) {
				return FastJsonUtil.getResponseJson("-2", "未登录");
			}
				record.setBegin_time(new Date());
				record.setWhether(1);
				int count = housesNewService.updateByPrimaryKey(record);
				if (count != 0) {
					return FastJsonUtil.getResponseJson(0, "开盘成功", null);
				} else {
					return FastJsonUtil.getResponseJson(-1, "开盘失败", null);
				}
		} catch (Exception e) {
			return dealException(-200, "系统异常", e);
		}
	}
	/**
	 * @Title: selectLabel
	 * @description 判断房源标签
	 * @param @param id
	 * @param @param session
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年6月13日
	 */
	@RequestMapping(value = "selectLabel", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	@ResponseBody
	public String selectLabel(Long[] id, HttpSession session) {
		try {
			/** 判断是否登录 */
			
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if (brokerVo == null) {
				return FastJsonUtil.getResponseJson("-2", "未登录");
				}
				Date date = new Date();
				List<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
				for (Long bigInteger : id) {
					ArrayList<String> list = new ArrayList<String>();
					HousesNewVo date1 = housesNewService.selectByFindID(bigInteger);
					List<Picture> pictures = pictureService.selectPic(bigInteger);
					List<FeedbackVo> feedbacks = feedbackService.selectListKey(bigInteger);
					List<Inform> inform = informMapper.selectTypeSix(bigInteger);
					if(date1!=null){
						if (date == date1.getBegin_time()) {
							list.add("新");
						}
					}
					if(pictures!=null){
						if (pictures.size() > 0) {
							list.add("图");
						}
					}
					if(feedbacks!=null){
						if (feedbacks.size() > 0) {
							list.add("带");
						}
					}
					if (inform.size() > 0) {
						list.add("撤");
					}
					lists.add(list);
				}
				if (lists.size() > 0) {
					return FastJsonUtil.getResponseJson(0, "查询成功", lists);
				} else {
					return FastJsonUtil.getResponseJson(-1, "查询失败", null);
				}
		} catch (Exception e) {
			return dealException(-200, "系统异常", e);
		}
	}
	
	/**
	 * 
	 * @Title: getDecisionAnalysis
	 *
	 * @description 添加决策分析(根据条件查询相关经纪人房源状况)
	 *
	 * @param @param shopId
	 * @param @param startTime
	 * @param @param endTime
	 * @param @return 
	 * 
	 * @return String    
	 *
	 * @author yaozijun
	 *
	 * @createDate 2019年6月14日
	 */
	@ResponseBody
	@RequestMapping(value = "/getDecisionAnalysis", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String getDecisionAnalysis (Long shopId,Date startTime,Date endTime){
		int code = 0;
		String msg = null;
		try {
			List<Map<String, Object>> list = housesNewService.getDecisionAnalysis(shopId,startTime,endTime);
			if (list.size() != 0) {
				msg = "查询成功";
				
				return FastJsonUtil.getResponseJson(code, msg, list);
			}
			code = -1;
			msg = "查询失败";
			
			return FastJsonUtil.getResponseJson(code, msg, null);
		} catch (Exception e) {
			code = -200;
			msg = "系统异常";
			logger.error(e.getMessage(), e);
			
			return FastJsonUtil.getResponseJson(code, msg, e);
		}
	}
	/**
	 * @Title: selectPaireds
	 * @description 查询房源是否有匹配房源
	 * @param @param demand_acreage
	 * @param @param demand_money
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年6月18日
	 */
	@ResponseBody
	@RequestMapping(value = "/selectPaireds", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String selectPaireds (int demand_acreage,int demand_money,int region_id,Long building_id, Integer page,Integer limit,HttpSession session){
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			List<HousesNewVo> list = housesNewService.selectPaireds(demand_acreage,demand_money,region_id,building_id,page,limit);
			if (list.size() != 0) {
				msg = "查询成功";
				
				return FastJsonUtil.getResponseJson(code, msg, list);
			}
			code = -1;
			msg = "没有符合的房源";
			
			return FastJsonUtil.getResponseJson(code, msg, null);
		} catch (Exception e) {
			code = -200;
			msg = "系统异常";
			logger.error(e.getMessage(), e);
			
			return FastJsonUtil.getResponseJson(code, msg, e);
		}
	}
	/**
	 * @Title: insertNumber
	 * @description 添加一条业主电话
	 * @param @param record
	 * @param @param session
	 * @param @return    
	 * @return String    
	 * @author linhongyu
	 * @createDate 2019年7月5日
	 */
	@ResponseBody
	@RequestMapping(value = "/insertNumber", method = RequestMethod.POST, produces = Constants.HTML_PRODUCE_TYPE)
	public String insertNumber (Owner record,HttpSession session){
		int code = 0;
		String msg = null;
		try {
			BrokerVo brokerVo = (BrokerVo) session.getAttribute(Constants.Login_User);
			if(brokerVo==null){
				return FastJsonUtil.getResponseJson(-2, "未登录", null);
			}
			record.setTime(new Date());
			int num = ownerMapper.insertSelective(record);
			if (num != 0) {
				msg = "添加成功";
				
				return FastJsonUtil.getResponseJson(code, msg, null);
			}
			code = -1;
			msg = "添加失败";
			
			return FastJsonUtil.getResponseJson(code, msg, null);
		} catch (Exception e) {
			code = -200;
			msg = "系统异常";
			logger.error(e.getMessage(), e);
			
			return FastJsonUtil.getResponseJson(code, msg, e);
		}
	}
}
