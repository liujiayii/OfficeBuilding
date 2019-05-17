
package com.yqwl.Vo;

import java.io.Serializable;
import com.yqwl.pojo.Entrustsee;

/**
 *
 * @ClassName: EntrustseeVo
 * @description Entrustsee表的Vo类
 *
 * @author linhongyu
 * @createDate 2019年4月10日
 */
public class EntrustseeVo extends Entrustsee implements Serializable{
	/**  字段的含义 */
	private static final long serialVersionUID = 1L;
	private Integer page;
	private Integer limit;
	private Integer count;
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	@Override
	public String toString() {
		return "EntrustseeVo [page=" + page + ", limit=" + limit + ", count=" + count + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((limit == null) ? 0 : limit.hashCode());
		result = prime * result + ((page == null) ? 0 : page.hashCode());
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
		EntrustseeVo other = (EntrustseeVo) obj;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (limit == null) {
			if (other.limit != null)
				return false;
		} else if (!limit.equals(other.limit))
			return false;
		if (page == null) {
			if (other.page != null)
				return false;
		} else if (!page.equals(other.page))
			return false;
		return true;
	}
	 
}
