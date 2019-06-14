package com.yqwl.Vo;

import com.yqwl.pojo.SucceedDeal;

public class SucceedDealVo extends SucceedDeal {
	private String region_name;
	private String mansion_name;
	private String Succeed_name;
	public String getRegion_name() {
		return region_name;
	}
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}
	public String getMansion_name() {
		return mansion_name;
	}
	public void setMansion_name(String mansion_name) {
		this.mansion_name = mansion_name;
	}
	public String getSucceed_name() {
		return Succeed_name;
	}
	public void setSucceed_name(String succeed_name) {
		Succeed_name = succeed_name;
	}
	@Override
	public String toString() {
		return "SucceedDealVo [region_name=" + region_name + ", mansion_name=" + mansion_name + ", Succeed_name="
				+ Succeed_name + "]";
	}
	
}
