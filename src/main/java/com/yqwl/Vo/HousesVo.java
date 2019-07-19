
package com.yqwl.Vo;

import com.yqwl.pojo.HousesNew;

/**
 *
 * @ClassName: HousesVo
 * @description 用一句话描述这个类的作用
 * @author linhongyu
 * @createDate 2019年6月24日
 */
public class HousesVo extends HousesNew{
	private String real_name;
	private Long phonemunber;
	private String mansion_name;
	private String door_num;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDoor_num() {
		return door_num;
	}
	public void setDoor_num(String door_num) {
		this.door_num = door_num;
	}
	public String getMansion_name() {
		return mansion_name;
	}
	public void setMansion_name(String mansion_name) {
		this.mansion_name = mansion_name;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public Long getPhonemunber() {
		return phonemunber;
	}
	public void setPhonemunber(Long phonemunber) {
		this.phonemunber = phonemunber;
	}
	@Override
	public String toString() {
		return "HousesVo [real_name=" + real_name + ", phonemunber=" + phonemunber + "]";
	}
	
}
