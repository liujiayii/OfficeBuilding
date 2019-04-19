package com.yqwl.Vo;

import java.math.BigDecimal;
import java.util.List;

import com.yqwl.pojo.HousesNew;

public class MapBuildingVo {
	private Long id;
	private String mansion_name;
	private String region_name;
	private String longitude;
	private String latitude;
	private String mansion_picture;
	private BigDecimal money;
	
	private List<HousesNew> housesNews;
	
	public List<HousesNew> getHousesNews() {
		return housesNews;
	}
	public void setHousesNews(List<HousesNew> housesNews) {
		this.housesNews = housesNews;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMansion_name() {
		return mansion_name;
	}
	public void setMansion_name(String mansion_name) {
		this.mansion_name = mansion_name;
	}
	public String getRegion_name() {
		return region_name;
	}
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getMansion_picture() {
		return mansion_picture;
	}
	public void setMansion_picture(String mansion_picture) {
		this.mansion_picture = mansion_picture;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	
}
