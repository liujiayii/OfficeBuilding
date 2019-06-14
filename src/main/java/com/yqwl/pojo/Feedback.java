package com.yqwl.pojo;

import java.io.Serializable;
import java.util.Date;

public class Feedback implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_feedback.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_feedback.hone_id
     *
     * @mbggenerated
     */
    private Long hone_id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_feedback.broker_id
     *
     * @mbggenerated
     */
    private Long broker_id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_feedback.centext
     *
     * @mbggenerated
     */
    private String centext;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_feedback.time
     *
     * @mbggenerated
     */
    private Date time;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_feedback
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_feedback.id
     *
     * @return the value of t_feedback.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_feedback.id
     *
     * @param id the value for t_feedback.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_feedback.hone_id
     *
     * @return the value of t_feedback.hone_id
     *
     * @mbggenerated
     */
    public Long getHone_id() {
        return hone_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_feedback.hone_id
     *
     * @param hone_id the value for t_feedback.hone_id
     *
     * @mbggenerated
     */
    public void setHone_id(Long hone_id) {
        this.hone_id = hone_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_feedback.broker_id
     *
     * @return the value of t_feedback.broker_id
     *
     * @mbggenerated
     */
    public Long getBroker_id() {
        return broker_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_feedback.broker_id
     *
     * @param broker_id the value for t_feedback.broker_id
     *
     * @mbggenerated
     */
    public void setBroker_id(Long broker_id) {
        this.broker_id = broker_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_feedback.centext
     *
     * @return the value of t_feedback.centext
     *
     * @mbggenerated
     */
    public String getCentext() {
        return centext;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_feedback.centext
     *
     * @param centext the value for t_feedback.centext
     *
     * @mbggenerated
     */
    public void setCentext(String centext) {
        this.centext = centext == null ? null : centext.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_feedback.time
     *
     * @return the value of t_feedback.time
     *
     * @mbggenerated
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_feedback.time
     *
     * @param time the value for t_feedback.time
     *
     * @mbggenerated
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_feedback
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
        Feedback other = (Feedback) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getHone_id() == null ? other.getHone_id() == null : this.getHone_id().equals(other.getHone_id()))
            && (this.getBroker_id() == null ? other.getBroker_id() == null : this.getBroker_id().equals(other.getBroker_id()))
            && (this.getCentext() == null ? other.getCentext() == null : this.getCentext().equals(other.getCentext()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_feedback
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getHone_id() == null) ? 0 : getHone_id().hashCode());
        result = prime * result + ((getBroker_id() == null) ? 0 : getBroker_id().hashCode());
        result = prime * result + ((getCentext() == null) ? 0 : getCentext().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_feedback
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
        sb.append(", hone_id=").append(hone_id);
        sb.append(", broker_id=").append(broker_id);
        sb.append(", centext=").append(centext);
        sb.append(", time=").append(time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}