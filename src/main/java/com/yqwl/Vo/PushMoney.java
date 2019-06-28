package com.yqwl.Vo;

public class PushMoney {
	private String name;
	private String cause;
	private Integer proportion;
	private Double performance;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public Integer getProportion() {
		return proportion;
	}
	public void setProportion(Integer proportion) {
		this.proportion = proportion;
	}
	public Double getPerformance() {
		return performance;
	}
	public void setPerformance(Double performance) {
		this.performance = performance;
	}
	@Override
	public String toString() {
		return "PushMoney [name=" + name + ", cause=" + cause + ", proportion=" + proportion + ", performance="
				+ performance + "]";
	}
	
}
