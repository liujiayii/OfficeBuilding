package com.yqwl.pojo;

import java.io.Serializable;

public class BrokerRole implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_broker_role.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_broker_role.broker_id
     *
     * @mbggenerated
     */
    private Long broker_id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_broker_role.role_id
     *
     * @mbggenerated
     */
    private Long role_id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_broker_role
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_broker_role.id
     *
     * @return the value of t_broker_role.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_broker_role.id
     *
     * @param id the value for t_broker_role.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_broker_role.broker_id
     *
     * @return the value of t_broker_role.broker_id
     *
     * @mbggenerated
     */
    public Long getBroker_id() {
        return broker_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_broker_role.broker_id
     *
     * @param broker_id the value for t_broker_role.broker_id
     *
     * @mbggenerated
     */
    public void setBroker_id(Long broker_id) {
        this.broker_id = broker_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_broker_role.role_id
     *
     * @return the value of t_broker_role.role_id
     *
     * @mbggenerated
     */
    public Long getRole_id() {
        return role_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_broker_role.role_id
     *
     * @param role_id the value for t_broker_role.role_id
     *
     * @mbggenerated
     */
    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_broker_role
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
        BrokerRole other = (BrokerRole) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBroker_id() == null ? other.getBroker_id() == null : this.getBroker_id().equals(other.getBroker_id()))
            && (this.getRole_id() == null ? other.getRole_id() == null : this.getRole_id().equals(other.getRole_id()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_broker_role
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBroker_id() == null) ? 0 : getBroker_id().hashCode());
        result = prime * result + ((getRole_id() == null) ? 0 : getRole_id().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_broker_role
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
        sb.append(", role_id=").append(role_id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}