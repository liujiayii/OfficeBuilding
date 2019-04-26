package com.yqwl.pojo;

import java.io.Serializable;

public class Shop implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_shop.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_shop.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_shop.region_id
     *
     * @mbggenerated
     */
    private Long region_id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_shop
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_shop.id
     *
     * @return the value of t_shop.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_shop.id
     *
     * @param id the value for t_shop.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_shop.name
     *
     * @return the value of t_shop.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_shop.name
     *
     * @param name the value for t_shop.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_shop.region_id
     *
     * @return the value of t_shop.region_id
     *
     * @mbggenerated
     */
    public Long getRegion_id() {
        return region_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_shop.region_id
     *
     * @param region_id the value for t_shop.region_id
     *
     * @mbggenerated
     */
    public void setRegion_id(Long region_id) {
        this.region_id = region_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_shop
     *
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
        Shop other = (Shop) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getRegion_id() == null ? other.getRegion_id() == null : this.getRegion_id().equals(other.getRegion_id()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_shop
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getRegion_id() == null) ? 0 : getRegion_id().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_shop
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", region_id=").append(region_id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}