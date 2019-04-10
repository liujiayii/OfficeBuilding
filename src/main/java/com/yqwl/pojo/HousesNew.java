package com.yqwl.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class HousesNew implements Serializable {

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
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_houses_new
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_houses_new.id
	 * @return  the value of t_houses_new.id
	 * @mbggenerated
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_houses_new.id
	 * @param id  the value for t_houses_new.id
	 * @mbggenerated
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_houses_new.houes_number
	 * @return  the value of t_houses_new.houes_number
	 * @mbggenerated
	 */
	public String getHoues_number() {
		return houes_number;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_houses_new.houes_number
	 * @param houes_number  the value for t_houses_new.houes_number
	 * @mbggenerated
	 */
	public void setHoues_number(String houes_number) {
		this.houes_number = houes_number == null ? null : houes_number.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_houses_new.building_id
	 * @return  the value of t_houses_new.building_id
	 * @mbggenerated
	 */
	public Long getBuilding_id() {
		return building_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_houses_new.building_id
	 * @param building_id  the value for t_houses_new.building_id
	 * @mbggenerated
	 */
	public void setBuilding_id(Long building_id) {
		this.building_id = building_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_houses_new.work_name
	 * @return  the value of t_houses_new.work_name
	 * @mbggenerated
	 */
	public String getWork_name() {
		return work_name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_houses_new.work_name
	 * @param work_name  the value for t_houses_new.work_name
	 * @mbggenerated
	 */
	public void setWork_name(String work_name) {
		this.work_name = work_name == null ? null : work_name.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_houses_new.office_space
	 * @return  the value of t_houses_new.office_space
	 * @mbggenerated
	 */
	public Integer getOffice_space() {
		return office_space;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_houses_new.office_space
	 * @param office_space  the value for t_houses_new.office_space
	 * @mbggenerated
	 */
	public void setOffice_space(Integer office_space) {
		this.office_space = office_space;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_houses_new.Location_number
	 * @return  the value of t_houses_new.Location_number
	 * @mbggenerated
	 */
	public Integer getLocation_number() {
		return location_number;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_houses_new.Location_number
	 * @param location_number  the value for t_houses_new.Location_number
	 * @mbggenerated
	 */
	public void setLocation_number(Integer location_number) {
		this.location_number = location_number;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_houses_new.house_type
	 * @return  the value of t_houses_new.house_type
	 * @mbggenerated
	 */
	public String getHouse_type() {
		return house_type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_houses_new.house_type
	 * @param house_type  the value for t_houses_new.house_type
	 * @mbggenerated
	 */
	public void setHouse_type(String house_type) {
		this.house_type = house_type == null ? null : house_type.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_houses_new.location
	 * @return  the value of t_houses_new.location
	 * @mbggenerated
	 */
	public Integer getLocation() {
		return location;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_houses_new.location
	 * @param location  the value for t_houses_new.location
	 * @mbggenerated
	 */
	public void setLocation(Integer location) {
		this.location = location;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_houses_new.money
	 * @return  the value of t_houses_new.money
	 * @mbggenerated
	 */
	public BigDecimal getMoney() {
		return money;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_houses_new.money
	 * @param money  the value for t_houses_new.money
	 * @mbggenerated
	 */
	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_houses_new.money_unit
	 * @return  the value of t_houses_new.money_unit
	 * @mbggenerated
	 */
	public Integer getMoney_unit() {
		return money_unit;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_houses_new.money_unit
	 * @param money_unit  the value for t_houses_new.money_unit
	 * @mbggenerated
	 */
	public void setMoney_unit(Integer money_unit) {
		this.money_unit = money_unit;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_houses_new.rent_time
	 * @return  the value of t_houses_new.rent_time
	 * @mbggenerated
	 */
	public Integer getRent_time() {
		return rent_time;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_houses_new.rent_time
	 * @param rent_time  the value for t_houses_new.rent_time
	 * @mbggenerated
	 */
	public void setRent_time(Integer rent_time) {
		this.rent_time = rent_time;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_houses_new.times
	 * @return  the value of t_houses_new.times
	 * @mbggenerated
	 */
	public Date getTimes() {
		return times;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_houses_new.times
	 * @param times  the value for t_houses_new.times
	 * @mbggenerated
	 */
	public void setTimes(Date times) {
		this.times = times;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_houses_new.fitment
	 * @return  the value of t_houses_new.fitment
	 * @mbggenerated
	 */
	public Integer getFitment() {
		return fitment;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_houses_new.fitment
	 * @param fitment  the value for t_houses_new.fitment
	 * @mbggenerated
	 */
	public void setFitment(Integer fitment) {
		this.fitment = fitment;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_houses_new.types
	 * @return  the value of t_houses_new.types
	 * @mbggenerated
	 */
	public Integer getTypes() {
		return types;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_houses_new.types
	 * @param types  the value for t_houses_new.types
	 * @mbggenerated
	 */
	public void setTypes(Integer types) {
		this.types = types;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_houses_new.entering_broker_id
	 * @return  the value of t_houses_new.entering_broker_id
	 * @mbggenerated
	 */
	public Integer getEntering_broker_id() {
		return entering_broker_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_houses_new.entering_broker_id
	 * @param entering_broker_id  the value for t_houses_new.entering_broker_id
	 * @mbggenerated
	 */
	public void setEntering_broker_id(Integer entering_broker_id) {
		this.entering_broker_id = entering_broker_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_houses_new.solid_broker_id
	 * @return  the value of t_houses_new.solid_broker_id
	 * @mbggenerated
	 */
	public Integer getSolid_broker_id() {
		return solid_broker_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_houses_new.solid_broker_id
	 * @param solid_broker_id  the value for t_houses_new.solid_broker_id
	 * @mbggenerated
	 */
	public void setSolid_broker_id(Integer solid_broker_id) {
		this.solid_broker_id = solid_broker_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_houses_new.maintain_broker_id
	 * @return  the value of t_houses_new.maintain_broker_id
	 * @mbggenerated
	 */
	public Integer getMaintain_broker_id() {
		return maintain_broker_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_houses_new.maintain_broker_id
	 * @param maintain_broker_id  the value for t_houses_new.maintain_broker_id
	 * @mbggenerated
	 */
	public void setMaintain_broker_id(Integer maintain_broker_id) {
		this.maintain_broker_id = maintain_broker_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_houses_new.whether
	 * @return  the value of t_houses_new.whether
	 * @mbggenerated
	 */
	public Integer getWhether() {
		return whether;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_houses_new.whether
	 * @param whether  the value for t_houses_new.whether
	 * @mbggenerated
	 */
	public void setWhether(Integer whether) {
		this.whether = whether;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_houses_new
	 * @mbggenerated
	 */
	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		HousesNew other = (HousesNew) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getHoues_number() == null ? other.getHoues_number() == null
						: this.getHoues_number().equals(other.getHoues_number()))
				&& (this.getBuilding_id() == null ? other.getBuilding_id() == null
						: this.getBuilding_id().equals(other.getBuilding_id()))
				&& (this.getWork_name() == null ? other.getWork_name() == null
						: this.getWork_name().equals(other.getWork_name()))
				&& (this.getOffice_space() == null ? other.getOffice_space() == null
						: this.getOffice_space().equals(other.getOffice_space()))
				&& (this.getLocation_number() == null ? other.getLocation_number() == null
						: this.getLocation_number().equals(other.getLocation_number()))
				&& (this.getHouse_type() == null ? other.getHouse_type() == null
						: this.getHouse_type().equals(other.getHouse_type()))
				&& (this.getLocation() == null ? other.getLocation() == null
						: this.getLocation().equals(other.getLocation()))
				&& (this.getMoney() == null ? other.getMoney() == null : this.getMoney().equals(other.getMoney()))
				&& (this.getMoney_unit() == null ? other.getMoney_unit() == null
						: this.getMoney_unit().equals(other.getMoney_unit()))
				&& (this.getRent_time() == null ? other.getRent_time() == null
						: this.getRent_time().equals(other.getRent_time()))
				&& (this.getTimes() == null ? other.getTimes() == null : this.getTimes().equals(other.getTimes()))
				&& (this.getFitment() == null ? other.getFitment() == null
						: this.getFitment().equals(other.getFitment()))
				&& (this.getTypes() == null ? other.getTypes() == null : this.getTypes().equals(other.getTypes()))
				&& (this.getEntering_broker_id() == null ? other.getEntering_broker_id() == null
						: this.getEntering_broker_id().equals(other.getEntering_broker_id()))
				&& (this.getSolid_broker_id() == null ? other.getSolid_broker_id() == null
						: this.getSolid_broker_id().equals(other.getSolid_broker_id()))
				&& (this.getMaintain_broker_id() == null ? other.getMaintain_broker_id() == null
						: this.getMaintain_broker_id().equals(other.getMaintain_broker_id()))
				&& (this.getWhether() == null ? other.getWhether() == null
						: this.getWhether().equals(other.getWhether()));
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_houses_new
	 * @mbggenerated
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getHoues_number() == null) ? 0 : getHoues_number().hashCode());
		result = prime * result + ((getBuilding_id() == null) ? 0 : getBuilding_id().hashCode());
		result = prime * result + ((getWork_name() == null) ? 0 : getWork_name().hashCode());
		result = prime * result + ((getOffice_space() == null) ? 0 : getOffice_space().hashCode());
		result = prime * result + ((getLocation_number() == null) ? 0 : getLocation_number().hashCode());
		result = prime * result + ((getHouse_type() == null) ? 0 : getHouse_type().hashCode());
		result = prime * result + ((getLocation() == null) ? 0 : getLocation().hashCode());
		result = prime * result + ((getMoney() == null) ? 0 : getMoney().hashCode());
		result = prime * result + ((getMoney_unit() == null) ? 0 : getMoney_unit().hashCode());
		result = prime * result + ((getRent_time() == null) ? 0 : getRent_time().hashCode());
		result = prime * result + ((getTimes() == null) ? 0 : getTimes().hashCode());
		result = prime * result + ((getFitment() == null) ? 0 : getFitment().hashCode());
		result = prime * result + ((getTypes() == null) ? 0 : getTypes().hashCode());
		result = prime * result + ((getEntering_broker_id() == null) ? 0 : getEntering_broker_id().hashCode());
		result = prime * result + ((getSolid_broker_id() == null) ? 0 : getSolid_broker_id().hashCode());
		result = prime * result + ((getMaintain_broker_id() == null) ? 0 : getMaintain_broker_id().hashCode());
		result = prime * result + ((getWhether() == null) ? 0 : getWhether().hashCode());
		return result;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_houses_new
	 * @mbggenerated
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", houes_number=").append(houes_number);
		sb.append(", building_id=").append(building_id);
		sb.append(", work_name=").append(work_name);
		sb.append(", office_space=").append(office_space);
		sb.append(", location_number=").append(location_number);
		sb.append(", house_type=").append(house_type);
		sb.append(", location=").append(location);
		sb.append(", money=").append(money);
		sb.append(", money_unit=").append(money_unit);
		sb.append(", rent_time=").append(rent_time);
		sb.append(", times=").append(times);
		sb.append(", fitment=").append(fitment);
		sb.append(", types=").append(types);
		sb.append(", entering_broker_id=").append(entering_broker_id);
		sb.append(", solid_broker_id=").append(solid_broker_id);
		sb.append(", maintain_broker_id=").append(maintain_broker_id);
		sb.append(", whether=").append(whether);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}