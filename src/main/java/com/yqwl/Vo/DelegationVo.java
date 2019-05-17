package com.yqwl.Vo;

import java.io.Serializable;

import com.yqwl.pojo.Delegation;

/**
 *
 * @ClassName: DelegationVo
 * @description Delegation的Vo类
 * @author linhongyu
 * @createDate 2019年4月10日
 */
public class DelegationVo extends Delegation implements Serializable{
	/**  字段的含义 */
	private static final long serialVersionUID = 1L;
	/** 页数 */
	private int page=0;
	/** 分页条数 */
	private int limit=5;
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
	@Override
	public String toString() {
		return "DelegationVo [page=" + page + ", limit=" + limit + ", count=" + count + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + limit;
		result = prime * result + page;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DelegationVo other = (DelegationVo) obj;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (limit != other.limit)
			return false;
		if (page != other.page)
			return false;
		return true;
	}
	
}
