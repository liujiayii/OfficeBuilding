package com.yqwl.pojo;

import java.io.Serializable;
import java.util.Date;

public class Delegation implements Serializable {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_delegation.id
	 * @mbggenerated
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_delegation.demand
	 * @mbggenerated
	 */
	private String demand;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_delegation.user_name
	 * @mbggenerated
	 */
	private String user_name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_delegation.phone_number
	 * @mbggenerated
	 */
	private Long phone_number;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_delegation.make_time
	 * @mbggenerated
	 */
	private Date make_time;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_delegation.make_type
	 * @mbggenerated
	 */
	private Integer make_type;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_delegation.broker_id
	 * @mbggenerated
	 */
	private Long broker_id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_delegation.city_id
	 * @mbggenerated
	 */
	private Long city_id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_delegation.remark
	 * @mbggenerated
	 */
	private String remark;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_delegation
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_delegation.id
	 * @return  the value of t_delegation.id
	 * @mbggenerated
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_delegation.id
	 * @param id  the value for t_delegation.id
	 * @mbggenerated
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_delegation.demand
	 * @return  the value of t_delegation.demand
	 * @mbggenerated
	 */
	public String getDemand() {
		return demand;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_delegation.demand
	 * @param demand  the value for t_delegation.demand
	 * @mbggenerated
	 */
	public void setDemand(String demand) {
		this.demand = demand == null ? null : demand.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_delegation.user_name
	 * @return  the value of t_delegation.user_name
	 * @mbggenerated
	 */
	public String getUser_name() {
		return user_name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_delegation.user_name
	 * @param user_name  the value for t_delegation.user_name
	 * @mbggenerated
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name == null ? null : user_name.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_delegation.phone_number
	 * @return  the value of t_delegation.phone_number
	 * @mbggenerated
	 */
	public Long getPhone_number() {
		return phone_number;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_delegation.phone_number
	 * @param phone_number  the value for t_delegation.phone_number
	 * @mbggenerated
	 */
	public void setPhone_number(Long phone_number) {
		this.phone_number = phone_number;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_delegation.make_time
	 * @return  the value of t_delegation.make_time
	 * @mbggenerated
	 */
	public Date getMake_time() {
		return make_time;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_delegation.make_time
	 * @param make_time  the value for t_delegation.make_time
	 * @mbggenerated
	 */
	public void setMake_time(Date make_time) {
		this.make_time = make_time;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_delegation.make_type
	 * @return  the value of t_delegation.make_type
	 * @mbggenerated
	 */
	public Integer getMake_type() {
		return make_type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_delegation.make_type
	 * @param make_type  the value for t_delegation.make_type
	 * @mbggenerated
	 */
	public void setMake_type(Integer make_type) {
		this.make_type = make_type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_delegation.broker_id
	 * @return  the value of t_delegation.broker_id
	 * @mbggenerated
	 */
	public Long getBroker_id() {
		return broker_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_delegation.broker_id
	 * @param broker_id  the value for t_delegation.broker_id
	 * @mbggenerated
	 */
	public void setBroker_id(Long broker_id) {
		this.broker_id = broker_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_delegation.city_id
	 * @return  the value of t_delegation.city_id
	 * @mbggenerated
	 */
	public Long getCity_id() {
		return city_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_delegation.city_id
	 * @param city_id  the value for t_delegation.city_id
	 * @mbggenerated
	 */
	public void setCity_id(Long city_id) {
		this.city_id = city_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_delegation.remark
	 * @return  the value of t_delegation.remark
	 * @mbggenerated
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_delegation.remark
	 * @param remark  the value for t_delegation.remark
	 * @mbggenerated
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_delegation
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
		Delegation other = (Delegation) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getDemand() == null ? other.getDemand() == null : this.getDemand().equals(other.getDemand()))
				&& (this.getUser_name() == null ? other.getUser_name() == null
						: this.getUser_name().equals(other.getUser_name()))
				&& (this.getPhone_number() == null ? other.getPhone_number() == null
						: this.getPhone_number().equals(other.getPhone_number()))
				&& (this.getMake_time() == null ? other.getMake_time() == null
						: this.getMake_time().equals(other.getMake_time()))
				&& (this.getMake_type() == null ? other.getMake_type() == null
						: this.getMake_type().equals(other.getMake_type()))
				&& (this.getBroker_id() == null ? other.getBroker_id() == null
						: this.getBroker_id().equals(other.getBroker_id()))
				&& (this.getCity_id() == null ? other.getCity_id() == null
						: this.getCity_id().equals(other.getCity_id()))
				&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_delegation
	 * @mbggenerated
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getDemand() == null) ? 0 : getDemand().hashCode());
		result = prime * result + ((getUser_name() == null) ? 0 : getUser_name().hashCode());
		result = prime * result + ((getPhone_number() == null) ? 0 : getPhone_number().hashCode());
		result = prime * result + ((getMake_time() == null) ? 0 : getMake_time().hashCode());
		result = prime * result + ((getMake_type() == null) ? 0 : getMake_type().hashCode());
		result = prime * result + ((getBroker_id() == null) ? 0 : getBroker_id().hashCode());
		result = prime * result + ((getCity_id() == null) ? 0 : getCity_id().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		return result;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_delegation
	 * @mbggenerated
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", demand=").append(demand);
		sb.append(", user_name=").append(user_name);
		sb.append(", phone_number=").append(phone_number);
		sb.append(", make_time=").append(make_time);
		sb.append(", make_type=").append(make_type);
		sb.append(", broker_id=").append(broker_id);
		sb.append(", city_id=").append(city_id);
		sb.append(", remark=").append(remark);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}