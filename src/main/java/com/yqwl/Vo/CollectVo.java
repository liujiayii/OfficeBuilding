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
	private String name;
	private String mansion_name;
	private Integer door_num;
	/** 页数 */
	private int page;
	/** 分页条数 */
	private int limit;
	private Integer count;
	private String real_name;
	private Integer whether;
	private Integer fitment;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMansion_name() {
		return mansion_name;
	}

	public void setMansion_name(String mansion_name) {
		this.mansion_name = mansion_name;
	}

	public Integer getDoor_num() {
		return door_num;
	}

	public void setDoor_num(Integer door_num) {
		this.door_num = door_num;
	}

	public String getReal_name() {
		return real_name;
	}

	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}

	public Integer getWhether() {
		return whether;
	}

	public void setWhether(Integer whether) {
		this.whether = whether;
	}

	public Integer getFitment() {
		return fitment;
	}

	public void setFitment(Integer fitment) {
		this.fitment = fitment;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

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
				+ ", money_unit=" + money_unit + ", location=" + location + ", name=" + name + ", mansion_name="
				+ mansion_name + ", door_num=" + door_num + ", page=" + page + ", limit=" + limit + ", count=" + count
				+ ", real_name=" + real_name + ", whether=" + whether + ", fitment=" + fitment + "]";
	}
	
}
