package com.yqwl.pojo;

import java.io.Serializable;
import java.util.Date;

public class FollowUp implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_follow_up.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_follow_up.broker_id
     *
     * @mbggenerated
     */
    private Long broker_id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_follow_up.home_id
     *
     * @mbggenerated
     */
    private Long home_id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_follow_up.type
     *
     * @mbggenerated
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_follow_up.follow
     *
     * @mbggenerated
     */
    private Integer follow;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_follow_up.content
     *
     * @mbggenerated
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_follow_up.brokers_id
     *
     * @mbggenerated
     */
    private Long brokers_id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_follow_up.remind_time
     *
     * @mbggenerated
     */
    private Date remind_time;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_follow_up.remind_content
     *
     * @mbggenerated
     */
    private String remind_content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_follow_up.retreat
     *
     * @mbggenerated
     */
    private Integer retreat;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_follow_up
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_follow_up.id
     *
     * @return the value of t_follow_up.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_follow_up.id
     *
     * @param id the value for t_follow_up.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_follow_up.broker_id
     *
     * @return the value of t_follow_up.broker_id
     *
     * @mbggenerated
     */
    public Long getBroker_id() {
        return broker_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_follow_up.broker_id
     *
     * @param broker_id the value for t_follow_up.broker_id
     *
     * @mbggenerated
     */
    public void setBroker_id(Long broker_id) {
        this.broker_id = broker_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_follow_up.home_id
     *
     * @return the value of t_follow_up.home_id
     *
     * @mbggenerated
     */
    public Long getHome_id() {
        return home_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_follow_up.home_id
     *
     * @param home_id the value for t_follow_up.home_id
     *
     * @mbggenerated
     */
    public void setHome_id(Long home_id) {
        this.home_id = home_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_follow_up.type
     *
     * @return the value of t_follow_up.type
     *
     * @mbggenerated
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_follow_up.type
     *
     * @param type the value for t_follow_up.type
     *
     * @mbggenerated
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_follow_up.follow
     *
     * @return the value of t_follow_up.follow
     *
     * @mbggenerated
     */
    public Integer getFollow() {
        return follow;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_follow_up.follow
     *
     * @param follow the value for t_follow_up.follow
     *
     * @mbggenerated
     */
    public void setFollow(Integer follow) {
        this.follow = follow;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_follow_up.content
     *
     * @return the value of t_follow_up.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_follow_up.content
     *
     * @param content the value for t_follow_up.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_follow_up.brokers_id
     *
     * @return the value of t_follow_up.brokers_id
     *
     * @mbggenerated
     */
    public Long getBrokers_id() {
        return brokers_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_follow_up.brokers_id
     *
     * @param brokers_id the value for t_follow_up.brokers_id
     *
     * @mbggenerated
     */
    public void setBrokers_id(Long brokers_id) {
        this.brokers_id = brokers_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_follow_up.remind_time
     *
     * @return the value of t_follow_up.remind_time
     *
     * @mbggenerated
     */
    public Date getRemind_time() {
        return remind_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_follow_up.remind_time
     *
     * @param remind_time the value for t_follow_up.remind_time
     *
     * @mbggenerated
     */
    public void setRemind_time(Date remind_time) {
        this.remind_time = remind_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_follow_up.remind_content
     *
     * @return the value of t_follow_up.remind_content
     *
     * @mbggenerated
     */
    public String getRemind_content() {
        return remind_content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_follow_up.remind_content
     *
     * @param remind_content the value for t_follow_up.remind_content
     *
     * @mbggenerated
     */
    public void setRemind_content(String remind_content) {
        this.remind_content = remind_content == null ? null : remind_content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_follow_up.retreat
     *
     * @return the value of t_follow_up.retreat
     *
     * @mbggenerated
     */
    public Integer getRetreat() {
        return retreat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_follow_up.retreat
     *
     * @param retreat the value for t_follow_up.retreat
     *
     * @mbggenerated
     */
    public void setRetreat(Integer retreat) {
        this.retreat = retreat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_follow_up
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
        FollowUp other = (FollowUp) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBroker_id() == null ? other.getBroker_id() == null : this.getBroker_id().equals(other.getBroker_id()))
            && (this.getHome_id() == null ? other.getHome_id() == null : this.getHome_id().equals(other.getHome_id()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getFollow() == null ? other.getFollow() == null : this.getFollow().equals(other.getFollow()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getBrokers_id() == null ? other.getBrokers_id() == null : this.getBrokers_id().equals(other.getBrokers_id()))
            && (this.getRemind_time() == null ? other.getRemind_time() == null : this.getRemind_time().equals(other.getRemind_time()))
            && (this.getRemind_content() == null ? other.getRemind_content() == null : this.getRemind_content().equals(other.getRemind_content()))
            && (this.getRetreat() == null ? other.getRetreat() == null : this.getRetreat().equals(other.getRetreat()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_follow_up
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBroker_id() == null) ? 0 : getBroker_id().hashCode());
        result = prime * result + ((getHome_id() == null) ? 0 : getHome_id().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getFollow() == null) ? 0 : getFollow().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getBrokers_id() == null) ? 0 : getBrokers_id().hashCode());
        result = prime * result + ((getRemind_time() == null) ? 0 : getRemind_time().hashCode());
        result = prime * result + ((getRemind_content() == null) ? 0 : getRemind_content().hashCode());
        result = prime * result + ((getRetreat() == null) ? 0 : getRetreat().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_follow_up
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
        sb.append(", broker_id=").append(broker_id);
        sb.append(", home_id=").append(home_id);
        sb.append(", type=").append(type);
        sb.append(", follow=").append(follow);
        sb.append(", content=").append(content);
        sb.append(", brokers_id=").append(brokers_id);
        sb.append(", remind_time=").append(remind_time);
        sb.append(", remind_content=").append(remind_content);
        sb.append(", retreat=").append(retreat);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}