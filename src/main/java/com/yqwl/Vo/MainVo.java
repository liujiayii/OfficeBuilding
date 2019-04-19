package com.yqwl.Vo;

import com.yqwl.pojo.Building;
import com.yqwl.pojo.HomePageRecommended;
import com.yqwl.pojo.HousesNew;

public class MainVo extends HomePageRecommended{
	
	/**  字段的含义 */
	private static final long serialVersionUID = 1L;
	
	private Building building;
	private HousesNew housesNew;
	public Building getBuilding() {
		return building;
	}
	public void setBuilding(Building building) {
		this.building = building;
	}
	public HousesNew getHousesNew() {
		return housesNew;
	}
	public void setHousesNew(HousesNew housesNew) {
		this.housesNew = housesNew;
	}
	@Override
	public String toString() {
		return "MainVo [building=" + building + ", housesNew=" + housesNew + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((building == null) ? 0 : building.hashCode());
		result = prime * result + ((housesNew == null) ? 0 : housesNew.hashCode());
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
		MainVo other = (MainVo) obj;
		if (building == null) {
			if (other.building != null)
				return false;
		} else if (!building.equals(other.building))
			return false;
		if (housesNew == null) {
			if (other.housesNew != null)
				return false;
		} else if (!housesNew.equals(other.housesNew))
			return false;
		return true;
	}
	
	
}
