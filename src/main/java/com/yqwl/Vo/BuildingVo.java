package com.yqwl.Vo;

import java.util.List;

import com.yqwl.pojo.Broker;
import com.yqwl.pojo.Building;
import com.yqwl.pojo.HousesNew;
import com.yqwl.pojo.Photo;

public class BuildingVo extends Building {
	
	/**  字段的含义 */
	private static final long serialVersionUID = 5436900666604772967L;

	private Broker broker;
	
	private List<Photo> Photos;
	
	private List<HousesNew> housesNews;
	
	private Integer subscribeCount;
	
	public Integer getSubscribeCount() {
		return subscribeCount;
	}

	public void setSubscribeCount(Integer subscribeCount) {
		this.subscribeCount = subscribeCount;
	}

	public Broker getBroker() {
		return broker;
	}

	public void setBroker(Broker broker) {
		this.broker = broker;
	}

	public List<Photo> getPhotos() {
		return Photos;
	}

	public void setPhotos(List<Photo> photos) {
		Photos = photos;
	}

	public List<HousesNew> getHousesNews() {
		return housesNews;
	}

	public void setHousesNews(List<HousesNew> housesNews) {
		this.housesNews = housesNews;
	}

	@Override
	public String toString() {
		return "BuildingVo [broker=" + broker + ", Photos=" + Photos + ", housesNews=" + housesNews
				+ ", subscribeCount=" + subscribeCount + ", getSubscribeCount()=" + getSubscribeCount()
				+ ", getBroker()=" + getBroker() + ", getPhotos()=" + getPhotos() + ", getHousesNews()="
				+ getHousesNews() + ", getId()=" + getId() + ", getMansion_name()=" + getMansion_name()
				+ ", getMansion_picture()=" + getMansion_picture() + ", getRegion_sh_id()=" + getRegion_sh_id()
				+ ", getRegion_shname()=" + getRegion_shname() + ", getRegion_city_id()=" + getRegion_city_id()
				+ ", getRegion_cityname()=" + getRegion_cityname() + ", getRegion_id()=" + getRegion_id()
				+ ", getRegion_name()=" + getRegion_name() + ", getDistrict()=" + getDistrict() + ", getFloor()="
				+ getFloor() + ", getTraffic_condition()=" + getTraffic_condition() + ", getActivate_time()="
				+ getActivate_time() + ", getProperty_fee()=" + getProperty_fee() + ", getParking_fee()="
				+ getParking_fee() + ", getConditioners_fee()=" + getConditioners_fee() + ", getIntro()=" + getIntro()
				+ ", getCircum()=" + getCircum() + ", getBroker_id()=" + getBroker_id() + ", getLongitude()="
				+ getLongitude() + ", getLatitude()=" + getLatitude() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((Photos == null) ? 0 : Photos.hashCode());
		result = prime * result + ((broker == null) ? 0 : broker.hashCode());
		result = prime * result + ((housesNews == null) ? 0 : housesNews.hashCode());
		result = prime * result + ((subscribeCount == null) ? 0 : subscribeCount.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BuildingVo other = (BuildingVo) obj;
		if (Photos == null) {
			if (other.Photos != null)
				return false;
		} else if (!Photos.equals(other.Photos))
			return false;
		if (broker == null) {
			if (other.broker != null)
				return false;
		} else if (!broker.equals(other.broker))
			return false;
		if (housesNews == null) {
			if (other.housesNews != null)
				return false;
		} else if (!housesNews.equals(other.housesNews))
			return false;
		if (subscribeCount == null) {
			if (other.subscribeCount != null)
				return false;
		} else if (!subscribeCount.equals(other.subscribeCount))
			return false;
		return true;
	}
	
	
}
