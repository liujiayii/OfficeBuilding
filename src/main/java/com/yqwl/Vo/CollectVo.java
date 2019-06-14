package com.yqwl.Vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.yqwl.pojo.Collect;
import com.yqwl.pojo.HousesNew;

/**
 *
 * @ClassName: CollectVo
 * @description 用一句话描述这个类的作用
 * @author linhongyu
 * @createDate 2019年6月12日
 */
public class CollectVo extends Collect implements Serializable{

	/**  字段的含义 */
	private static final long serialVersionUID = 893105331781220312L;
	
	private HousesNew housesNew;
	private String work_name;
	private String house_picture;
	private Date times;
	private Integer types;
	private Integer office_space;
	private BigDecimal money;
	private Integer money_unit;
	private Integer location;
	
	public String getWork_name() {
		return work_name;
	}

	public void setWork_name(String work_name) {
		this.work_name = work_name;
	}

	public String getHouse_picture() {
		return house_picture;
	}

	public void setHouse_picture(String house_picture) {
		this.house_picture = house_picture;
	}

	public Date getTimes() {
		return times;
	}

	public void setTimes(Date times) {
		this.times = times;
	}

	public Integer getTypes() {
		return types;
	}

	public void setTypes(Integer types) {
		this.types = types;
	}

	public Integer getOffice_space() {
		return office_space;
	}

	public void setOffice_space(Integer office_space) {
		this.office_space = office_space;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public Integer getMoney_unit() {
		return money_unit;
	}

	public void setMoney_unit(Integer money_unit) {
		this.money_unit = money_unit;
	}

	public Integer getLocation() {
		return location;
	}

	public void setLocation(Integer location) {
		this.location = location;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public HousesNew getHousesNew() {
		return housesNew;
	}

	public void setHousesNew(HousesNew housesNew) {
		this.housesNew = housesNew;
	}

	@Override
	public String toString() {
		return "CollectVo [housesNew=" + housesNew + ", work_name=" + work_name + ", house_picture=" + house_picture
				+ ", times=" + times + ", types=" + types + ", office_space=" + office_space + ", money=" + money
				+ ", money_unit=" + money_unit + ", location=" + location + "]";
	}
	
}
