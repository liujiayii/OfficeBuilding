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
	/** 页数 */
	private int page;
	/** 分页条数 */
	private int limit;
	private Integer count;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
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
		return "FeedbackVo [real_name=" + real_name + ", page=" + page + ", limit=" + limit + ", count=" + count + "]";
	}
	
}
