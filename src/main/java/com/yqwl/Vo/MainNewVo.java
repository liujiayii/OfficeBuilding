package com.yqwl.Vo;

import java.util.List;

import com.yqwl.pojo.Journalism;

public class MainNewVo extends Journalism{
	/**  字段的含义 */
	private static final long serialVersionUID = -8665905357615037155L;
	private List<Journalism> industry;
	private List<Journalism> strategy;
	public List<Journalism> getIndustry() {
		return industry;
	}
	public void setIndustry(List<Journalism> industry) {
		this.industry = industry;
	}
	public List<Journalism> getStrategy() {
		return strategy;
	}
	public void setStrategy(List<Journalism> strategy) {
		this.strategy = strategy;
	}
	@Override
	public String toString() {
		return "MainNewVo [industry=" + industry + ", strategy=" + strategy + "]";
	}
	
}
