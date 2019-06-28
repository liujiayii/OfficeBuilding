package com.yqwl.Vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @ClassName: HousesNewVo
 * @description 用一句话描述这个类的作用
 *
 * @author 姓名全拼
 * @createDate 2019年4月9日
 */
public class HousesNewVo implements Serializable{
	/**  字段的含义 */
	private static final long serialVersionUID = 1L;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_houses_new.id
	 * @mbggenerated
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_houses_new.houes_number
	 * @mbggenerated
	 */
	private String houes_number;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_houses_new.building_id
	 * @mbggenerated
	 */
	private Long building_id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_houses_new.work_name
	 * @mbggenerated
	 */
	private String work_name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_houses_new.office_space
	 * @mbggenerated
	 */
	private Integer office_space;
	private Integer office_spaceOne;
	private Integer office_spaceTwo;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_houses_new.house_picture
	 * @mbggenerated
	 */
	private String house_picture;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_houses_new.Location_number
	 * @mbggenerated
	 */
	private Integer location_number;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_houses_new.house_type
	 * @mbggenerated
	 */
	private String house_type;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_houses_new.location
	 * @mbggenerated
	 */
	private Integer location;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_houses_new.money
	 * @mbggenerated
	 */
	private BigDecimal money;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_houses_new.money_unit
	 * @mbggenerated
	 */
	private Integer money_unit;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_houses_new.rent_time
	 * @mbggenerated
	 */
	private Integer rent_time;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_houses_new.times
	 * @mbggenerated
	 */
	private Date times;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_houses_new.fitment
	 * @mbggenerated
	 */
	private Integer fitment;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_houses_new.types
	 * @mbggenerated
	 */
	private Integer types;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_houses_new.entering_broker_id
	 * @mbggenerated
	 */
	private Integer entering_broker_id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_houses_new.solid_broker_id
	 * @mbggenerated
	 */
	private Integer solid_broker_id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_houses_new.maintain_broker_id
	 * @mbggenerated
	 */
	private Integer maintain_broker_id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_houses_new.whether
	 * @mbggenerated
	 */
	private Integer whether;
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
	private Date activate_time;
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
	private String latitude;
	/** 页数 */
	private int page=0;
	/** 分页条数 */
	private int limit=5;
	
	public String getHouse_picture() {
		return house_picture;
	}
	public void setHouse_picture(String house_picture) {
		this.house_picture = house_picture;
	}
	public Integer getOffice_spaceOne() {
		return office_spaceOne;
	}
	public void setOffice_spaceOne(Integer office_spaceOne) {
		this.office_spaceOne = office_spaceOne;
	}
	public Integer getOffice_spaceTwo() {
		return office_spaceTwo;
	}
	public void setOffice_spaceTwo(Integer office_spaceTwo) {
		this.office_spaceTwo = office_spaceTwo;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHoues_number() {
		return houes_number;
	}
	public void setHoues_number(String houes_number) {
		this.houes_number = houes_number;
	}
	public Long getBuilding_id() {
		return building_id;
	}
	public void setBuilding_id(Long building_id) {
		this.building_id = building_id;
	}
	public String getWork_name() {
		return work_name;
	}
	public void setWork_name(String work_name) {
		this.work_name = work_name;
	}
	public Integer getOffice_space() {
		return office_space;
	}
	public void setOffice_space(Integer office_space) {
		this.office_space = office_space;
	}
	public Integer getLocation_number() {
		return location_number;
	}
	public void setLocation_number(Integer location_number) {
		this.location_number = location_number;
	}
	public String getHouse_type() {
		return house_type;
	}
	public void setHouse_type(String house_type) {
		this.house_type = house_type;
	}
	public Integer getLocation() {
		return location;
	}
	public void setLocation(Integer location) {
		this.location = location;
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
	public Integer getRent_time() {
		return rent_time;
	}
	public void setRent_time(Integer rent_time) {
		this.rent_time = rent_time;
	}
	public Date getTimes() {
		return times;
	}
	public void setTimes(Date times) {
		this.times = times;
	}
	public Integer getFitment() {
		return fitment;
	}
	public void setFitment(Integer fitment) {
		this.fitment = fitment;
	}
	public Integer getTypes() {
		return types;
	}
	public void setTypes(Integer types) {
		this.types = types;
	}
	public Integer getEntering_broker_id() {
		return entering_broker_id;
	}
	public void setEntering_broker_id(Integer entering_broker_id) {
		this.entering_broker_id = entering_broker_id;
	}
	public Integer getSolid_broker_id() {
		return solid_broker_id;
	}
	public void setSolid_broker_id(Integer solid_broker_id) {
		this.solid_broker_id = solid_broker_id;
	}
	public Integer getMaintain_broker_id() {
		return maintain_broker_id;
	}
	public void setMaintain_broker_id(Integer maintain_broker_id) {
		this.maintain_broker_id = maintain_broker_id;
	}
	public Integer getWhether() {
		return whether;
	}
	public void setWhether(Integer whether) {
		this.whether = whether;
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
	public Date getActivate_time() {
		return activate_time;
	}
	public void setActivate_time(Date activate_time) {
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
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activate_time == null) ? 0 : activate_time.hashCode());
		result = prime * result + ((building_id == null) ? 0 : building_id.hashCode());
		result = prime * result + ((circum == null) ? 0 : circum.hashCode());
		result = prime * result + ((conditioners_fee == null) ? 0 : conditioners_fee.hashCode());
		result = prime * result + ((district == null) ? 0 : district.hashCode());
		result = prime * result + ((entering_broker_id == null) ? 0 : entering_broker_id.hashCode());
		result = prime * result + ((fitment == null) ? 0 : fitment.hashCode());
		result = prime * result + ((floor == null) ? 0 : floor.hashCode());
		result = prime * result + ((houes_number == null) ? 0 : houes_number.hashCode());
		result = prime * result + ((house_picture == null) ? 0 : house_picture.hashCode());
		result = prime * result + ((house_type == null) ? 0 : house_type.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((intro == null) ? 0 : intro.hashCode());
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + limit;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((location_number == null) ? 0 : location_number.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
		result = prime * result + ((maintain_broker_id == null) ? 0 : maintain_broker_id.hashCode());
		result = prime * result + ((mansion_name == null) ? 0 : mansion_name.hashCode());
		result = prime * result + ((mansion_picture == null) ? 0 : mansion_picture.hashCode());
		result = prime * result + ((money == null) ? 0 : money.hashCode());
		result = prime * result + ((money_unit == null) ? 0 : money_unit.hashCode());
		result = prime * result + ((office_space == null) ? 0 : office_space.hashCode());
		result = prime * result + ((office_spaceOne == null) ? 0 : office_spaceOne.hashCode());
		result = prime * result + ((office_spaceTwo == null) ? 0 : office_spaceTwo.hashCode());
		result = prime * result + page;
		result = prime * result + ((parking_fee == null) ? 0 : parking_fee.hashCode());
		result = prime * result + ((property_fee == null) ? 0 : property_fee.hashCode());
		result = prime * result + ((region_city_id == null) ? 0 : region_city_id.hashCode());
		result = prime * result + ((region_cityname == null) ? 0 : region_cityname.hashCode());
		result = prime * result + ((region_id == null) ? 0 : region_id.hashCode());
		result = prime * result + ((region_name == null) ? 0 : region_name.hashCode());
		result = prime * result + ((region_sh_id == null) ? 0 : region_sh_id.hashCode());
		result = prime * result + ((region_shname == null) ? 0 : region_shname.hashCode());
		result = prime * result + ((rent_time == null) ? 0 : rent_time.hashCode());
		result = prime * result + ((solid_broker_id == null) ? 0 : solid_broker_id.hashCode());
		result = prime * result + ((times == null) ? 0 : times.hashCode());
		result = prime * result + ((traffic_condition == null) ? 0 : traffic_condition.hashCode());
		result = prime * result + ((types == null) ? 0 : types.hashCode());
		result = prime * result + ((whether == null) ? 0 : whether.hashCode());
		result = prime * result + ((work_name == null) ? 0 : work_name.hashCode());
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
		HousesNewVo other = (HousesNewVo) obj;
		if (activate_time == null) {
			if (other.activate_time != null)
				return false;
		} else if (!activate_time.equals(other.activate_time))
			return false;
		if (building_id == null) {
			if (other.building_id != null)
				return false;
		} else if (!building_id.equals(other.building_id))
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
		if (district == null) {
			if (other.district != null)
				return false;
		} else if (!district.equals(other.district))
			return false;
		if (entering_broker_id == null) {
			if (other.entering_broker_id != null)
				return false;
		} else if (!entering_broker_id.equals(other.entering_broker_id))
			return false;
		if (fitment == null) {
			if (other.fitment != null)
				return false;
		} else if (!fitment.equals(other.fitment))
			return false;
		if (floor == null) {
			if (other.floor != null)
				return false;
		} else if (!floor.equals(other.floor))
			return false;
		if (houes_number == null) {
			if (other.houes_number != null)
				return false;
		} else if (!houes_number.equals(other.houes_number))
			return false;
		if (house_picture == null) {
			if (other.house_picture != null)
				return false;
		} else if (!house_picture.equals(other.house_picture))
			return false;
		if (house_type == null) {
			if (other.house_type != null)
				return false;
		} else if (!house_type.equals(other.house_type))
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
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (location_number == null) {
			if (other.location_number != null)
				return false;
		} else if (!location_number.equals(other.location_number))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		if (maintain_broker_id == null) {
			if (other.maintain_broker_id != null)
				return false;
		} else if (!maintain_broker_id.equals(other.maintain_broker_id))
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
		if (money == null) {
			if (other.money != null)
				return false;
		} else if (!money.equals(other.money))
			return false;
		if (money_unit == null) {
			if (other.money_unit != null)
				return false;
		} else if (!money_unit.equals(other.money_unit))
			return false;
		if (office_space == null) {
			if (other.office_space != null)
				return false;
		} else if (!office_space.equals(other.office_space))
			return false;
		if (office_spaceOne == null) {
			if (other.office_spaceOne != null)
				return false;
		} else if (!office_spaceOne.equals(other.office_spaceOne))
			return false;
		if (office_spaceTwo == null) {
			if (other.office_spaceTwo != null)
				return false;
		} else if (!office_spaceTwo.equals(other.office_spaceTwo))
			return false;
		if (page != other.page)
			return false;
		if (parking_fee == null) {
			if (other.parking_fee != null)
				return false;
		} else if (!parking_fee.equals(other.parking_fee))
			return false;
		if (property_fee == null) {
			if (other.property_fee != null)
				return false;
		} else if (!property_fee.equals(other.property_fee))
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
		if (rent_time == null) {
			if (other.rent_time != null)
				return false;
		} else if (!rent_time.equals(other.rent_time))
			return false;
		if (solid_broker_id == null) {
			if (other.solid_broker_id != null)
				return false;
		} else if (!solid_broker_id.equals(other.solid_broker_id))
			return false;
		if (times == null) {
			if (other.times != null)
				return false;
		} else if (!times.equals(other.times))
			return false;
		if (traffic_condition == null) {
			if (other.traffic_condition != null)
				return false;
		} else if (!traffic_condition.equals(other.traffic_condition))
			return false;
		if (types == null) {
			if (other.types != null)
				return false;
		} else if (!types.equals(other.types))
			return false;
		if (whether == null) {
			if (other.whether != null)
				return false;
		} else if (!whether.equals(other.whether))
			return false;
		if (work_name == null) {
			if (other.work_name != null)
				return false;
		} else if (!work_name.equals(other.work_name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "HousesNewVo [id=" + id + ", houes_number=" + houes_number + ", building_id=" + building_id
				+ ", work_name=" + work_name + ", office_space=" + office_space + ", office_spaceOne=" + office_spaceOne
				+ ", office_spaceTwo=" + office_spaceTwo + ", house_picture=" + house_picture + ", location_number="
				+ location_number + ", house_type=" + house_type + ", location=" + location + ", money=" + money
				+ ", money_unit=" + money_unit + ", rent_time=" + rent_time + ", times=" + times + ", fitment="
				+ fitment + ", types=" + types + ", entering_broker_id=" + entering_broker_id + ", solid_broker_id="
				+ solid_broker_id + ", maintain_broker_id=" + maintain_broker_id + ", whether=" + whether
				+ ", mansion_name=" + mansion_name + ", mansion_picture=" + mansion_picture + ", region_sh_id="
				+ region_sh_id + ", region_shname=" + region_shname + ", region_city_id=" + region_city_id
				+ ", region_cityname=" + region_cityname + ", region_id=" + region_id + ", region_name=" + region_name
				+ ", district=" + district + ", floor=" + floor + ", traffic_condition=" + traffic_condition
				+ ", activate_time=" + activate_time + ", property_fee=" + property_fee + ", parking_fee=" + parking_fee
				+ ", conditioners_fee=" + conditioners_fee + ", intro=" + intro + ", circum=" + circum + ", longitude="
				+ longitude + ", latitude=" + latitude + ", page=" + page + ", limit=" + limit + "]";
	}
	

}
