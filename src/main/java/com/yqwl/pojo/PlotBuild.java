package com.yqwl.pojo;

import java.io.Serializable;

public class PlotBuild implements Serializable {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_plot_build.id
	 * @mbggenerated
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_plot_build.building_id
	 * @mbggenerated
	 */
	private Long building_id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_plot_build.name
	 * @mbggenerated
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_plot_build.name_type
	 * @mbggenerated
	 */
	private String name_type;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_plot_build.unit_num
	 * @mbggenerated
	 */
	private Integer unit_num;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_plot_build.total_floor
	 * @mbggenerated
	 */
	private Integer total_floor;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_plot_build
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_plot_build.id
	 * @return  the value of t_plot_build.id
	 * @mbggenerated
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_plot_build.id
	 * @param id  the value for t_plot_build.id
	 * @mbggenerated
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_plot_build.building_id
	 * @return  the value of t_plot_build.building_id
	 * @mbggenerated
	 */
	public Long getBuilding_id() {
		return building_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_plot_build.building_id
	 * @param building_id  the value for t_plot_build.building_id
	 * @mbggenerated
	 */
	public void setBuilding_id(Long building_id) {
		this.building_id = building_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_plot_build.name
	 * @return  the value of t_plot_build.name
	 * @mbggenerated
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_plot_build.name
	 * @param name  the value for t_plot_build.name
	 * @mbggenerated
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_plot_build.name_type
	 * @return  the value of t_plot_build.name_type
	 * @mbggenerated
	 */
	public String getName_type() {
		return name_type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_plot_build.name_type
	 * @param name_type  the value for t_plot_build.name_type
	 * @mbggenerated
	 */
	public void setName_type(String name_type) {
		this.name_type = name_type == null ? null : name_type.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_plot_build.unit_num
	 * @return  the value of t_plot_build.unit_num
	 * @mbggenerated
	 */
	public Integer getUnit_num() {
		return unit_num;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_plot_build.unit_num
	 * @param unit_num  the value for t_plot_build.unit_num
	 * @mbggenerated
	 */
	public void setUnit_num(Integer unit_num) {
		this.unit_num = unit_num;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_plot_build.total_floor
	 * @return  the value of t_plot_build.total_floor
	 * @mbggenerated
	 */
	public Integer getTotal_floor() {
		return total_floor;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_plot_build.total_floor
	 * @param total_floor  the value for t_plot_build.total_floor
	 * @mbggenerated
	 */
	public void setTotal_floor(Integer total_floor) {
		this.total_floor = total_floor;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_plot_build
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
		PlotBuild other = (PlotBuild) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getBuilding_id() == null ? other.getBuilding_id() == null
						: this.getBuilding_id().equals(other.getBuilding_id()))
				&& (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
				&& (this.getName_type() == null ? other.getName_type() == null
						: this.getName_type().equals(other.getName_type()))
				&& (this.getUnit_num() == null ? other.getUnit_num() == null
						: this.getUnit_num().equals(other.getUnit_num()))
				&& (this.getTotal_floor() == null ? other.getTotal_floor() == null
						: this.getTotal_floor().equals(other.getTotal_floor()));
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_plot_build
	 * @mbggenerated
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getBuilding_id() == null) ? 0 : getBuilding_id().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getName_type() == null) ? 0 : getName_type().hashCode());
		result = prime * result + ((getUnit_num() == null) ? 0 : getUnit_num().hashCode());
		result = prime * result + ((getTotal_floor() == null) ? 0 : getTotal_floor().hashCode());
		return result;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_plot_build
	 * @mbggenerated
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", building_id=").append(building_id);
		sb.append(", name=").append(name);
		sb.append(", name_type=").append(name_type);
		sb.append(", unit_num=").append(unit_num);
		sb.append(", total_floor=").append(total_floor);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}