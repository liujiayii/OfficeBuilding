package com.yqwl.Vo;

import com.yqwl.pojo.Shop;

public class ShopVo extends Shop {
	/**  字段的含义 */
	private static final long serialVersionUID = 2603211190162163244L;
	private String Region;

	public String getRegion() {
		return Region;
	}

	public void setRegion(String region) {
		Region = region;
	}

	@Override
	public String toString() {
		return "ShopVo [Region=" + Region + "]";
	}
	
}
