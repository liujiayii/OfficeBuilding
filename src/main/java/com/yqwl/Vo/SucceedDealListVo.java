package com.yqwl.Vo;

import com.yqwl.pojo.SucceedDeal;

public class SucceedDealListVo extends SucceedDeal{

	/**  字段的含义 */
	private static final long serialVersionUID = -2662931932508232267L;
	/**单数*/
	private Integer singular;
	/**成交金额*/
	private Integer brokerage;
	public Integer getSingular() {
		return singular;
	}
	public void setSingular(Integer singular) {
		this.singular = singular;
	}
	public Integer getBrokerage() {
		return brokerage;
	}
	public void setBrokerage(Integer brokerage) {
		this.brokerage = brokerage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "SucceedDealListVo [singular=" + singular + ", brokerage=" + brokerage + "]";
	}
	
	
}
