package com.yqwl.pojo;

import java.io.Serializable;
import java.util.Date;

public class Owner implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_owner.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_owner.home_id
     *
     * @mbggenerated
     */
    private Long home_id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_owner.number
     *
     * @mbggenerated
     */
    private String number;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_owner.maker
     *
     * @mbggenerated
     */
    private String maker;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_owner.time
     *
     * @mbggenerated
     */
    private Date time;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_owner
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_owner.id
     *
     * @return the value of t_owner.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_owner.id
     *
     * @param id the value for t_owner.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_owner.home_id
     *
     * @return the value of t_owner.home_id
     *
     * @mbggenerated
     */
    public Long getHome_id() {
        return home_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_owner.home_id
     *
     * @param home_id the value for t_owner.home_id
     *
     * @mbggenerated
     */
    public void setHome_id(Long home_id) {
        this.home_id = home_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_owner.number
     *
     * @return the value of t_owner.number
     *
     * @mbggenerated
     */
    public String getNumber() {
        return number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_owner.number
     *
     * @param number the value for t_owner.number
     *
     * @mbggenerated
     */
    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_owner.maker
     *
     * @return the value of t_owner.maker
     *
     * @mbggenerated
     */
    public String getMaker() {
        return maker;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_owner.maker
     *
     * @param maker the value for t_owner.maker
     *
     * @mbggenerated
     */
    public void setMaker(String maker) {
        this.maker = maker == null ? null : maker.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_owner.time
     *
     * @return the value of t_owner.time
     *
     * @mbggenerated
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_owner.time
     *
     * @param time the value for t_owner.time
     *
     * @mbggenerated
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_owner
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
        Owner other = (Owner) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getHome_id() == null ? other.getHome_id() == null : this.getHome_id().equals(other.getHome_id()))
            && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
            && (this.getMaker() == null ? other.getMaker() == null : this.getMaker().equals(other.getMaker()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_owner
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getHome_id() == null) ? 0 : getHome_id().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getMaker() == null) ? 0 : getMaker().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_owner
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
        sb.append(", home_id=").append(home_id);
        sb.append(", number=").append(number);
        sb.append(", maker=").append(maker);
        sb.append(", time=").append(time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}