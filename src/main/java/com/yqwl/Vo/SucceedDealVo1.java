package com.yqwl.Vo;

import java.util.List;

import com.yqwl.pojo.SuccedDealCost;
import com.yqwl.pojo.SucceedDeal;
import com.yqwl.pojo.UserPhone;

public class SucceedDealVo1 extends SucceedDeal {
	private List<PushMoney> pushMoneys;
	private List<SuccedDealCost> succedDealCosts;
	private List<UserPhone> userPhones;
	public List<PushMoney> getPushMoneys() {
		return pushMoneys;
	}
	public void setPushMoneys(List<PushMoney> pushMoneys) {
		this.pushMoneys = pushMoneys;
	}
	public List<SuccedDealCost> getSuccedDealCosts() {
		return succedDealCosts;
	}
	public void setSuccedDealCosts(List<SuccedDealCost> succedDealCosts) {
		this.succedDealCosts = succedDealCosts;
	}
	public List<UserPhone> getUserPhones() {
		return userPhones;
	}
	public void setUserPhones(List<UserPhone> userPhones) {
		this.userPhones = userPhones;
	}
	@Override
	public String toString() {
		return "SucceedDealVo1 [pushMoneys=" + pushMoneys + ", succedDealCosts=" + succedDealCosts + ", userPhones="
				+ userPhones + "]";
	}
	
}
