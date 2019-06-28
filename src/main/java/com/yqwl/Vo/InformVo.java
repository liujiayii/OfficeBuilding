package com.yqwl.Vo;

import com.yqwl.pojo.Inform;

public class InformVo extends Inform{

	/**  字段的含义 */
	private static final long serialVersionUID = 686353742912801500L;
	/**经纪人真实姓名*/
	private String real_name;
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "InformVo [real_name=" + real_name + "]";
	}
	
}
