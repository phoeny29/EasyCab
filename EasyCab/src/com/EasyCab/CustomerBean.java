package com.EasyCab;

public class CustomerBean {
	String userName;
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLongt() {
		return longt;
	}

	public void setLongt(double longt) {
		this.longt = longt;
	}

	double lat;
	double longt;

	public CustomerBean(String userName, double lat, double longt) {
		this.userName = userName;
		this.lat = lat;
		this.longt = longt;
	}

}
