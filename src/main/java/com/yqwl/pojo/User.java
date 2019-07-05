package com.yqwl.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.id
	 * @mbggenerated
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.category
	 * @mbggenerated
	 */
	private Integer category;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.name
	 * @mbggenerated
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.address
	 * @mbggenerated
	 */
	private String address;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.demand_acreage
	 * @mbggenerated
	 */
	private Integer demand_acreage;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.demand_money
	 * @mbggenerated
	 */
	private Integer demand_money;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.demand_address
	 * @mbggenerated
	 */
	private String demand_address;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.time
	 * @mbggenerated
	 */
	private Date time;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.broker_id
	 * @mbggenerated
	 */
	private Long broker_id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.region_id
	 * @mbggenerated
	 */
	private Integer region_id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.building_id
	 * @mbggenerated
	 */
	private Long building_id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.remark
	 * @mbggenerated
	 */
	private String remark;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_user
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.id
	 * @return  the value of t_user.id
	 * @mbggenerated
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.id
	 * @param id  the value for t_user.id
	 * @mbggenerated
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.category
	 * @return  the value of t_user.category
	 * @mbggenerated
	 */
	public Integer getCategory() {
		return category;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.category
	 * @param category  the value for t_user.category
	 * @mbggenerated
	 */
	public void setCategory(Integer category) {
		this.category = category;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.name
	 * @return  the value of t_user.name
	 * @mbggenerated
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.name
	 * @param name  the value for t_user.name
	 * @mbggenerated
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.address
	 * @return  the value of t_user.address
	 * @mbggenerated
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.address
	 * @param address  the value for t_user.address
	 * @mbggenerated
	 */
	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.demand_acreage
	 * @return  the value of t_user.demand_acreage
	 * @mbggenerated
	 */
	public Integer getDemand_acreage() {
		return demand_acreage;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.demand_acreage
	 * @param demand_acreage  the value for t_user.demand_acreage
	 * @mbggenerated
	 */
	public void setDemand_acreage(Integer demand_acreage) {
		this.demand_acreage = demand_acreage;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.demand_money
	 * @return  the value of t_user.demand_money
	 * @mbggenerated
	 */
	public Integer getDemand_money() {
		return demand_money;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.demand_money
	 * @param demand_money  the value for t_user.demand_money
	 * @mbggenerated
	 */
	public void setDemand_money(Integer demand_money) {
		this.demand_money = demand_money;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.demand_address
	 * @return  the value of t_user.demand_address
	 * @mbggenerated
	 */
	public String getDemand_address() {
		return demand_address;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.demand_address
	 * @param demand_address  the value for t_user.demand_address
	 * @mbggenerated
	 */
	public void setDemand_address(String demand_address) {
		this.demand_address = demand_address == null ? null : demand_address.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.time
	 * @return  the value of t_user.time
	 * @mbggenerated
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.time
	 * @param time  the value for t_user.time
	 * @mbggenerated
	 */
	public void setTime(Date time) {
		this.time = time;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.broker_id
	 * @return  the value of t_user.broker_id
	 * @mbggenerated
	 */
	public Long getBroker_id() {
		return broker_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.broker_id
	 * @param broker_id  the value for t_user.broker_id
	 * @mbggenerated
	 */
	public void setBroker_id(Long broker_id) {
		this.broker_id = broker_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.region_id
	 * @return  the value of t_user.region_id
	 * @mbggenerated
	 */
	public Integer getRegion_id() {
		return region_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.region_id
	 * @param region_id  the value for t_user.region_id
	 * @mbggenerated
	 */
	public void setRegion_id(Integer region_id) {
		this.region_id = region_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.building_id
	 * @return  the value of t_user.building_id
	 * @mbggenerated
	 */
	public Long getBuilding_id() {
		return building_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.building_id
	 * @param building_id  the value for t_user.building_id
	 * @mbggenerated
	 */
	public void setBuilding_id(Long building_id) {
		this.building_id = building_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.remark
	 * @return  the value of t_user.remark
	 * @mbggenerated
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.remark
	 * @param remark  the value for t_user.remark
	 * @mbggenerated
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user
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
		User other = (User) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getCategory() == null ? other.getCategory() == null
						: this.getCategory().equals(other.getCategory()))
				&& (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
				&& (this.getAddress() == null ? other.getAddress() == null
						: this.getAddress().equals(other.getAddress()))
				&& (this.getDemand_acreage() == null ? other.getDemand_acreage() == null
						: this.getDemand_acreage().equals(other.getDemand_acreage()))
				&& (this.getDemand_money() == null ? other.getDemand_money() == null
						: this.getDemand_money().equals(other.getDemand_money()))
				&& (this.getDemand_address() == null ? other.getDemand_address() == null
						: this.getDemand_address().equals(other.getDemand_address()))
				&& (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
				&& (this.getBroker_id() == null ? other.getBroker_id() == null
						: this.getBroker_id().equals(other.getBroker_id()))
				&& (this.getRegion_id() == null ? other.getRegion_id() == null
						: this.getRegion_id().equals(other.getRegion_id()))
				&& (this.getBuilding_id() == null ? other.getBuilding_id() == null
						: this.getBuilding_id().equals(other.getBuilding_id()))
				&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user
	 * @mbggenerated
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getCategory() == null) ? 0 : getCategory().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
		result = prime * result + ((getDemand_acreage() == null) ? 0 : getDemand_acreage().hashCode());
		result = prime * result + ((getDemand_money() == null) ? 0 : getDemand_money().hashCode());
		result = prime * result + ((getDemand_address() == null) ? 0 : getDemand_address().hashCode());
		result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
		result = prime * result + ((getBroker_id() == null) ? 0 : getBroker_id().hashCode());
		result = prime * result + ((getRegion_id() == null) ? 0 : getRegion_id().hashCode());
		result = prime * result + ((getBuilding_id() == null) ? 0 : getBuilding_id().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		return result;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user
	 * @mbggenerated
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", category=").append(category);
		sb.append(", name=").append(name);
		sb.append(", address=").append(address);
		sb.append(", demand_acreage=").append(demand_acreage);
		sb.append(", demand_money=").append(demand_money);
		sb.append(", demand_address=").append(demand_address);
		sb.append(", time=").append(time);
		sb.append(", broker_id=").append(broker_id);
		sb.append(", region_id=").append(region_id);
		sb.append(", building_id=").append(building_id);
		sb.append(", remark=").append(remark);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}