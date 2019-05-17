package com.yqwl.Vo;

import java.util.List;

import com.yqwl.pojo.Broker;
import com.yqwl.pojo.Building;
import com.yqwl.pojo.HousesNew;
import com.yqwl.pojo.Picture;
import com.yqwl.pojo.PlotBuild;
import com.yqwl.pojo.PlotDoor;
import com.yqwl.pojo.Shop;

public class BackHousesVo extends HousesNew {

	/**  字段的含义 */
	private static final long serialVersionUID = 1929719908410549719L;
	
	private Building building;
	
	private List<Picture> pictures;
	
	private Broker broker;
	
	private Shop shop;
	
	private PlotDoor plotDoor;
	private PlotBuild plotBuild;
	
	public PlotDoor getPlotDoor() {
		return plotDoor;
	}

	public void setPlotDoor(PlotDoor plotDoor) {
		this.plotDoor = plotDoor;
	}

	public PlotBuild getPlotBuild() {
		return plotBuild;
	}

	public void setPlotBuild(PlotBuild plotBuild) {
		this.plotBuild = plotBuild;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

	public Broker getBroker() {
		return broker;
	}

	public void setBroker(Broker broker) {
		this.broker = broker;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	
}
