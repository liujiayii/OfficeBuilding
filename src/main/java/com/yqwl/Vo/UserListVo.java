package com.yqwl.Vo;

import java.math.BigInteger;

import com.yqwl.pojo.User;

/**
 *
 * @ClassName: UserListVo
 * @description Vo类
 * @author linhongyu
 * @createDate 2019年6月13日
 */
public class UserListVo extends User{

	/**  字段的含义 */
	private static final long serialVersionUID = -3044855850847890657L;
	/**意向客户数量*/
	private Integer sumome;
	/**已成交客户数量*/
	private Integer sumtwo;
	public Integer getSumome() {
		return sumome;
	}
	public void setSumome(Integer sumome) {
		this.sumome = sumome;
	}
	public Integer getSumtwo() {
		return sumtwo;
	}
	public void setSumtwo(Integer sumtwo) {
		this.sumtwo = sumtwo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "UserListVo [sumome=" + sumome + ", sumtwo=" + sumtwo + "]";
	}
	
	
}
