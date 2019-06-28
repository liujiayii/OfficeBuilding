package com.yqwl.Vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import com.yqwl.pojo.Building;
import com.yqwl.pojo.Photo;

/**
 *
 * @ClassName: BuildingListVo
 * @description 用一句话描述这个类的作用
 *
 * @author 姓名全拼
 * @createDate 2019年4月14日
 */
public class BuildingListVo extends Building implements Serializable{

	/**  字段的含义 */
	private static final long serialVersionUID = 1L;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_building.id
	 * @mbggenerated
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_building.mansion_name
	 * @mbggenerated
	 */
	private String mansion_name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_building.mansion_picture
	 * @mbggenerated
	 */
	private String mansion_picture;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_building.region_sh_id
	 * @mbggenerated
	 */
	private Integer region_sh_id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_building.region_shname
	 * @mbggenerated
	 */
	private String region_shname;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_building.region_city_id
	 * @mbggenerated
	 */
	private Integer region_city_id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_building.region_cityname
	 * @mbggenerated
	 */
	private String region_cityname;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_building.region_id
	 * @mbggenerated
	 */
	private Integer region_id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_building.region_name
	 * @mbggenerated
	 */
	private String region_name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_building.district
	 * @mbggenerated
	 */
	private String district;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_building.floor
	 * @mbggenerated
	 */
	private Integer floor;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_building.traffic_condition
	 * @mbggenerated
	 */
	private String traffic_condition;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_building.activate_time
	 * @mbggenerated
	 */
	private Integer activate_time;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_building.property_fee
	 * @mbggenerated
	 */
	private BigDecimal property_fee;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_building.parking_fee
	 * @mbggenerated
	 */
	private BigDecimal parking_fee;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_building.conditioners_fee
	 * @mbggenerated
	 */
	private BigDecimal conditioners_fee;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_building.intro
	 * @mbggenerated
	 */
	private String intro;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_building.circum
	 * @mbggenerated
	 */
	private String circum;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_building.longitude
	 * @mbggenerated
	 */
	private String longitude;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_building.latitude
	 * @mbggenerated
	 */
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_broker.real_name
	 * @mbggenerated
	 */
	private String real_name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_broker.phonemunber
	 * @mbggenerated
	 */
	private Long phonemunber;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_broker.picture
	 * @mbggenerated
	 */
	/** 页数 */
	private int page=0;
	/** 分页条数 */
	private int limit=5;
	private Integer counts;
	private String picture;
	private String latitude;
	//在组房源
	private BigInteger count;
	//房屋可用面积
	private Integer officeSum;
	//商厦图片
	private List<Photo> photo;
	
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
	public Integer getCounts() {
		return counts;
	}
	public void setCounts(Integer counts) {
		this.counts = counts;
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
	public String getMansion_picture() {
		return mansion_picture;
	}
	public void setMansion_picture(String mansion_picture) {
		this.mansion_picture = mansion_picture;
	}
	public Integer getRegion_sh_id() {
		return region_sh_id;
	}
	public void setRegion_sh_id(Integer region_sh_id) {
		this.region_sh_id = region_sh_id;
	}
	public String getRegion_shname() {
		return region_shname;
	}
	public void setRegion_shname(String region_shname) {
		this.region_shname = region_shname;
	}
	public Integer getRegion_city_id() {
		return region_city_id;
	}
	public void setRegion_city_id(Integer region_city_id) {
		this.region_city_id = region_city_id;
	}
	public String getRegion_cityname() {
		return region_cityname;
	}
	public void setRegion_cityname(String region_cityname) {
		this.region_cityname = region_cityname;
	}
	public Integer getRegion_id() {
		return region_id;
	}
	public void setRegion_id(Integer region_id) {
		this.region_id = region_id;
	}
	public String getRegion_name() {
		return region_name;
	}
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public Integer getFloor() {
		return floor;
	}
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
	public String getTraffic_condition() {
		return traffic_condition;
	}
	public void setTraffic_condition(String traffic_condition) {
		this.traffic_condition = traffic_condition;
	}
	public Integer getActivate_time() {
		return activate_time;
	}
	public void setActivate_time(Integer activate_time) {
		this.activate_time = activate_time;
	}
	public BigDecimal getProperty_fee() {
		return property_fee;
	}
	public void setProperty_fee(BigDecimal property_fee) {
		this.property_fee = property_fee;
	}
	public BigDecimal getParking_fee() {
		return parking_fee;
	}
	public void setParking_fee(BigDecimal parking_fee) {
		this.parking_fee = parking_fee;
	}
	public BigDecimal getConditioners_fee() {
		return conditioners_fee;
	}
	public void setConditioners_fee(BigDecimal conditioners_fee) {
		this.conditioners_fee = conditioners_fee;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getCircum() {
		return circum;
	}
	public void setCircum(String circum) {
		this.circum = circum;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public Long getPhonemunber() {
		return phonemunber;
	}
	public void setPhonemunber(Long phonemunber) {
		this.phonemunber = phonemunber;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public BigInteger getCount() {
		return count;
	}
	public void setCount(BigInteger count) {
		this.count = count;
	}
	public Integer getOfficeSum() {
		return officeSum;
	}
	public void setOfficeSum(Integer officeSum) {
		this.officeSum = officeSum;
	}
	public List<Photo> getPhoto() {
		return photo;
	}
	public void setPhoto(List<Photo> photo) {
		this.photo = photo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "BuildingListVo [id=" + id + ", mansion_name=" + mansion_name + ", mansion_picture=" + mansion_picture
				+ ", region_sh_id=" + region_sh_id + ", region_shname=" + region_shname + ", region_city_id="
				+ region_city_id + ", region_cityname=" + region_cityname + ", region_id=" + region_id
				+ ", region_name=" + region_name + ", district=" + district + ", floor=" + floor
				+ ", traffic_condition=" + traffic_condition + ", activate_time=" + activate_time + ", property_fee="
				+ property_fee + ", parking_fee=" + parking_fee + ", conditioners_fee=" + conditioners_fee + ", intro="
				+ intro + ", circum=" + circum + ", longitude=" + longitude + ", real_name=" + real_name
				+ ", phonemunber=" + phonemunber + ", page=" + page + ", limit=" + limit + ", counts=" + counts
				+ ", picture=" + picture + ", latitude=" + latitude + ", count=" + count + ", officeSum=" + officeSum
				+ ", photo=" + photo + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activate_time == null) ? 0 : activate_time.hashCode());
		result = prime * result + ((circum == null) ? 0 : circum.hashCode());
		result = prime * result + ((conditioners_fee == null) ? 0 : conditioners_fee.hashCode());
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((counts == null) ? 0 : counts.hashCode());
		result = prime * result + ((district == null) ? 0 : district.hashCode());
		result = prime * result + ((floor == null) ? 0 : floor.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((intro == null) ? 0 : intro.hashCode());
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + limit;
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
		result = prime * result + ((mansion_name == null) ? 0 : mansion_name.hashCode());
		result = prime * result + ((mansion_picture == null) ? 0 : mansion_picture.hashCode());
		result = prime * result + ((officeSum == null) ? 0 : officeSum.hashCode());
		result = prime * result + page;
		result = prime * result + ((parking_fee == null) ? 0 : parking_fee.hashCode());
		result = prime * result + ((phonemunber == null) ? 0 : phonemunber.hashCode());
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result + ((picture == null) ? 0 : picture.hashCode());
		result = prime * result + ((property_fee == null) ? 0 : property_fee.hashCode());
		result = prime * result + ((real_name == null) ? 0 : real_name.hashCode());
		result = prime * result + ((region_city_id == null) ? 0 : region_city_id.hashCode());
		result = prime * result + ((region_cityname == null) ? 0 : region_cityname.hashCode());
		result = prime * result + ((region_id == null) ? 0 : region_id.hashCode());
		result = prime * result + ((region_name == null) ? 0 : region_name.hashCode());
		result = prime * result + ((region_sh_id == null) ? 0 : region_sh_id.hashCode());
		result = prime * result + ((region_shname == null) ? 0 : region_shname.hashCode());
		result = prime * result + ((traffic_condition == null) ? 0 : traffic_condition.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BuildingListVo other = (BuildingListVo) obj;
		if (activate_time == null) {
			if (other.activate_time != null)
				return false;
		} else if (!activate_time.equals(other.activate_time))
			return false;
		if (circum == null) {
			if (other.circum != null)
				return false;
		} else if (!circum.equals(other.circum))
			return false;
		if (conditioners_fee == null) {
			if (other.conditioners_fee != null)
				return false;
		} else if (!conditioners_fee.equals(other.conditioners_fee))
			return false;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (counts == null) {
			if (other.counts != null)
				return false;
		} else if (!counts.equals(other.counts))
			return false;
		if (district == null) {
			if (other.district != null)
				return false;
		} else if (!district.equals(other.district))
			return false;
		if (floor == null) {
			if (other.floor != null)
				return false;
		} else if (!floor.equals(other.floor))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (intro == null) {
			if (other.intro != null)
				return false;
		} else if (!intro.equals(other.intro))
			return false;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (limit != other.limit)
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		if (mansion_name == null) {
			if (other.mansion_name != null)
				return false;
		} else if (!mansion_name.equals(other.mansion_name))
			return false;
		if (mansion_picture == null) {
			if (other.mansion_picture != null)
				return false;
		} else if (!mansion_picture.equals(other.mansion_picture))
			return false;
		if (officeSum == null) {
			if (other.officeSum != null)
				return false;
		} else if (!officeSum.equals(other.officeSum))
			return false;
		if (page != other.page)
			return false;
		if (parking_fee == null) {
			if (other.parking_fee != null)
				return false;
		} else if (!parking_fee.equals(other.parking_fee))
			return false;
		if (phonemunber == null) {
			if (other.phonemunber != null)
				return false;
		} else if (!phonemunber.equals(other.phonemunber))
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		if (picture == null) {
			if (other.picture != null)
				return false;
		} else if (!picture.equals(other.picture))
			return false;
		if (property_fee == null) {
			if (other.property_fee != null)
				return false;
		} else if (!property_fee.equals(other.property_fee))
			return false;
		if (real_name == null) {
			if (other.real_name != null)
				return false;
		} else if (!real_name.equals(other.real_name))
			return false;
		if (region_city_id == null) {
			if (other.region_city_id != null)
				return false;
		} else if (!region_city_id.equals(other.region_city_id))
			return false;
		if (region_cityname == null) {
			if (other.region_cityname != null)
				return false;
		} else if (!region_cityname.equals(other.region_cityname))
			return false;
		if (region_id == null) {
			if (other.region_id != null)
				return false;
		} else if (!region_id.equals(other.region_id))
			return false;
		if (region_name == null) {
			if (other.region_name != null)
				return false;
		} else if (!region_name.equals(other.region_name))
			return false;
		if (region_sh_id == null) {
			if (other.region_sh_id != null)
				return false;
		} else if (!region_sh_id.equals(other.region_sh_id))
			return false;
		if (region_shname == null) {
			if (other.region_shname != null)
				return false;
		} else if (!region_shname.equals(other.region_shname))
			return false;
		if (traffic_condition == null) {
			if (other.traffic_condition != null)
				return false;
		} else if (!traffic_condition.equals(other.traffic_condition))
			return false;
		return true;
	}
	
}
