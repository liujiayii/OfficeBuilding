package com.yqwl.Vo;

import java.io.Serializable;

import com.yqwl.pojo.Feedback;

/**
 *
 * @ClassName: FeedbackVo
 * @description vo类
 * @author linhongyu
 * @createDate 2019年6月12日
 */
public class FeedbackVo  extends Feedback implements Serializable{
	/**  字段的含义 */
	private static final long serialVersionUID = 2156720730267882087L;
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
		return "FeedbackVo [real_name=" + real_name + "]";
	}
	
}
