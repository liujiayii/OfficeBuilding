package com.yqwl.Vo;

import java.io.Serializable;

import com.yqwl.pojo.FollowUp;

/**
 *
 * @ClassName: FollowUpVo
 * @description 用一句话描述这个类的作用
 * @author linhongyu
 * @createDate 2019年6月12日
 */
public class FollowUpVo extends FollowUp implements Serializable{
	/**  字段的含义 */
	private static final long serialVersionUID = 3134568628371101151L;
	/**经纪人真实姓名*/
	private String real_name;
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	@Override
	public String toString() {
		return "FollowUpVo [real_name=" + real_name + "]";
	}
	
}
