package com.yqwl.Vo;

/**
 * 
 * @ClassName: HousesNewAnalysisVo
 *
 * @description 用一句话描述这个类的作用
 *
 * @author yaozijun
 *
 * @createDate 2019年6月10日
 */
public class HousesNewAnalysisVo {
	/** 正常 */
	private Integer normal;
	/** 暂缓 */
	private Integer postpone;
	/** 他售 */
	private Integer else_sell;
	/** 他租 */
	private Integer else_rent;
	/** 未知 */
	private Integer unknown;
	/** 撤单 */
	private Integer revoke;
	/** 我租 */
	private Integer oneself_rent;
	/** 我售 */
	private Integer oneself_sell;
	/** 待确认 */
	private Integer be_confirmed;
	/** 已撤回 */
	private Integer recall;
	
	
	public Integer getNormal() {
		return normal;
	}


	public void setNormal(Integer normal) {
		this.normal = normal;
	}


	public Integer getPostpone() {
		return postpone;
	}


	public void setPostpone(Integer postpone) {
		this.postpone = postpone;
	}


	public Integer getElse_sell() {
		return else_sell;
	}


	public void setElse_sell(Integer else_sell) {
		this.else_sell = else_sell;
	}


	public Integer getElse_rent() {
		return else_rent;
	}


	public void setElse_rent(Integer else_rent) {
		this.else_rent = else_rent;
	}


	public Integer getUnknown() {
		return unknown;
	}


	public void setUnknown(Integer unknown) {
		this.unknown = unknown;
	}


	public Integer getRevoke() {
		return revoke;
	}


	public void setRevoke(Integer revoke) {
		this.revoke = revoke;
	}


	public Integer getOneself_rent() {
		return oneself_rent;
	}


	public void setOneself_rent(Integer oneself_rent) {
		this.oneself_rent = oneself_rent;
	}


	public Integer getOneself_sell() {
		return oneself_sell;
	}


	public void setOneself_sell(Integer oneself_sell) {
		this.oneself_sell = oneself_sell;
	}


	public Integer getBe_confirmed() {
		return be_confirmed;
	}


	public void setBe_confirmed(Integer be_confirmed) {
		this.be_confirmed = be_confirmed;
	}


	public Integer getRecall() {
		return recall;
	}


	public void setRecall(Integer recall) {
		this.recall = recall;
	}


	@Override
	public String toString() {
		return "HousesNewAnalysisVo [normal=" + normal + ", postpone=" + postpone + ", else_sell=" + else_sell
				+ ", else_rent=" + else_rent + ", unknown=" + unknown + ", revoke=" + revoke + ", oneself_rent="
				+ oneself_rent + ", oneself_sell=" + oneself_sell + ", be_confirmed=" + be_confirmed + ", recall="
				+ recall + "]";
	}
	
	
	
	
	

}
